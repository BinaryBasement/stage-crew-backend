package pl.stagecrew.authservice.messaging.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.stagecrew.authservice.messaging.AccountPublisher;
import pl.stagecrew.authservice.messaging.AccountSubscriber;
import pl.stagecrew.authservice.model.Account;
import pl.stagecrew.authservice.service.AccountService;
import pl.stagecrew.shared.event.account.AccountEvent;
import pl.stagecrew.shared.event.account.AccountEventStatus;

@Component
@RequiredArgsConstructor
public class AccountSubscriberImpl implements AccountSubscriber {

    private final AccountService accountService;
    private final AccountPublisher accountPublisher;

    @Override
    public void onCreateAccountEvent(AccountEvent event) {
        if (event.getStatus() == AccountEventStatus.CREATE) {
            handleCreateAccountEvent(event);
        } else if (event.getStatus() == AccountEventStatus.ROLLBACK) {
            handleRollbackCreateAccountEvent(event);
        }
    }

    private void handleCreateAccountEvent(AccountEvent event) {
        Account account = buildAccount(event);
        try {
            accountService.createAccount(account);
        } catch (Exception e) {
            accountPublisher.publishRollbackAccountEvent(account);
        }
    }

    private void handleRollbackCreateAccountEvent(AccountEvent event) {
        accountService.deleteAccount(event.getAccount().getUsername());
    }

    private Account buildAccount(AccountEvent event) {
        Account account = new Account();
        account.setUsername(event.getAccount().getUsername());
        account.setPassword(event.getAccount().getPassword());
        account.setEmail(event.getAccount().getEmail());
        return account;
    }
}
