package pl.stagecrew.accountservice.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.stagecrew.accountservice.exception.AccountNotFoundException;
import pl.stagecrew.accountservice.mapper.AccountMapper;
import pl.stagecrew.accountservice.messaging.CreateAccountPublisher;
import pl.stagecrew.accountservice.model.Account;
import pl.stagecrew.accountservice.repository.AccountRepository;
import pl.stagecrew.accountservice.service.AccountService;

import java.util.List;
import java.util.UUID;

@Service
@Transactional(rollbackOn = Exception.class)
@RequiredArgsConstructor
public class AccountServiceImpl extends AbstaractService implements AccountService {

    private final AccountMapper accountMapper;
    private final AccountRepository accountRepository;
    private final CreateAccountPublisher createAccountPublisher;

    @Override
    public Account createAccount(Account account, String password) {
        Account createdAccount = accountMapper.mapToAccount(accountRepository
                .save(accountMapper.mapToAccountEntity(account)));
        createAccountPublisher.sendCreateAccountMessage(createdAccount, password);
        return createdAccount;
    }

    @Override
    public Account getAccountById(UUID id) throws AccountNotFoundException {
        return accountMapper.mapToAccount(accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException(id)));
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountMapper.mapToAccountList(accountRepository.findAll());
    }
}
