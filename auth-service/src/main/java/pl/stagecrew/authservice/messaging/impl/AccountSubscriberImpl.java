package pl.stagecrew.authservice.messaging.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.stagecrew.authservice.messaging.AccountSubscriber;
import pl.stagecrew.authservice.model.Account;
import pl.stagecrew.authservice.service.AccountService;
import pl.stagecrew.shared.event.account.CreateAccountEvent;

@Component
@RequiredArgsConstructor
public class AccountSubscriberImpl implements AccountSubscriber {

    private final AccountService accountService;

    @Override
    public void onAccountCreated(CreateAccountEvent event) {
        Account account = buildAccount(event);
        accountService.createAccount(account);
    }

    private Account buildAccount(CreateAccountEvent event) {
        Account account = new Account();
        account.setUsername(event.getUsername());
        account.setPassword(event.getPassword());
        account.setEmail(event.getEmail());
        return account;
    }
}
