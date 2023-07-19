package pl.stagecrew.authservice.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.stagecrew.authservice.mapper.AccountMapper;
import pl.stagecrew.authservice.model.Account;
import pl.stagecrew.authservice.repository.AccountRepository;
import pl.stagecrew.authservice.service.AccountService;

@Service
@Transactional(rollbackOn = Exception.class)
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountMapper accountMapper;
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void createAccount(Account account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        try {
            accountRepository.save(accountMapper.mapToAccountEntity(account));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
