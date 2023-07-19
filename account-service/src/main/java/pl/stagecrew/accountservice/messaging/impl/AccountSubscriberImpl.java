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
    public void onAccountEvent(AccountEvent event) {
        if (Objects.requireNonNull(event.getStatus()) == AccountEventStatus.ROLLBACK) {
            handleRollbackAccountEvent(event);
        } else {
            throw new IllegalArgumentException("Unknown event status: " + event.getStatus());
        }
    }

    private void handleRollbackAccountEvent(AccountEvent event) {
        accountService.rollbackAccount(event.getAccount().getUsername());
    }
}
