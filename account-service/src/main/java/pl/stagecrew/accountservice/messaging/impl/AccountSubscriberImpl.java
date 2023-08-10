package pl.stagecrew.accountservice.messaging.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.stagecrew.accountservice.messaging.AccountSubscriber;
import pl.stagecrew.accountservice.service.AccountService;
import pl.stagecrew.shared.event.account.AccountEvent;
import pl.stagecrew.shared.event.account.AccountEventStatus;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class AccountSubscriberImpl implements AccountSubscriber {

    private final AccountService accountService;

    @Override
    public void onCreateAccountEvent(AccountEvent event) {
        if (Objects.requireNonNull(event.getStatus()) == AccountEventStatus.ROLLBACK) {
            handleRollbackCreateAccountEvent(event);
        }
    }

    private void handleRollbackCreateAccountEvent(AccountEvent event) {
        accountService.deleteAccount(event.getAccount().getUsername());
    }
}
