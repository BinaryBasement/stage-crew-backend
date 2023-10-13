package pl.stagecrew.authservice.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.stagecrew.authservice.mapper.AccountMapper;
import pl.stagecrew.authservice.model.Account;
import pl.stagecrew.authservice.repository.AccountRepository;
import pl.stagecrew.authservice.service.AccountService;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountMapper accountMapper;
    private final AccountRepository accountRepository;

    @Override
    public void createAccount(Account account) {
        accountRepository.save(accountMapper.mapToAccountEntity(account));
    }

    @Override
    @Transactional
    public void deleteAccount(String username) {
        accountRepository.deleteByUsername(username);
    }
}
