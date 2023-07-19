package pl.stagecrew.authservice.messaging.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.stagecrew.authservice.messaging.AccountPublisher;
import pl.stagecrew.authservice.messaging.AccountSubscriber;
import pl.stagecrew.authservice.model.Account;
import pl.stagecrew.authservice.service.AccountService;
import pl.stagecrew.shared.event.account.AccountEvent;

@Component
@RequiredArgsConstructor
public class AccountSubscriberImpl implements AccountSubscriber {

    private final AccountService accountService;
    private final AccountPublisher accountPublisher;

    @Override
    public void onAccountEvent(AccountEvent event) {
        switch (event.getStatus()) {
            case CREATE -> handleCreateAccountEvent(event);
            case ROLLBACK -> handleRollbackAccountEvent(event);
            default -> throw new IllegalArgumentException("Unknown event status: " + event.getStatus());
        }
    }

    private void handleCreateAccountEvent(AccountEvent event) {
        Account account = buildAccount(event);
        try {
            accountService.createAccount(account);
        } catch (Exception e) {
            accountPublisher.publishRollbackAccountEvent(account);
            throw e;
        }
    }

    private void handleRollbackAccountEvent(AccountEvent event) {
        accountService.rollbackAccount(event.getAccount().getUsername());
    }

    private Account buildAccount(AccountEvent event) {
        Account account = new Account();
        account.setUsername(event.getAccount().getUsername());
        account.setPassword(event.getAccount().getPassword());
        account.setEmail(event.getAccount().getEmail());
        return account;
    }
}
