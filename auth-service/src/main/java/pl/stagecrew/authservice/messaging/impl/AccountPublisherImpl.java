package pl.stagecrew.authservice.messaging.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import pl.stagecrew.authservice.messaging.AccountPublisher;
import pl.stagecrew.authservice.model.Account;
import pl.stagecrew.shared.event.account.AccountEvent;
import pl.stagecrew.shared.event.account.AccountEventStatus;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class AccountPublisherImpl implements AccountPublisher {

    private final KafkaTemplate<UUID, AccountEvent> kafkaTemplate;

    @Override
    public void publishRollbackAccountEvent(Account account) {
        AccountEvent accountEvent = buildAccountEvent(account, AccountEventStatus.ROLLBACK);
        kafkaTemplate.send("create-account", accountEvent.getEventId(), accountEvent);
    }

    private AccountEvent buildAccountEvent(Account account, AccountEventStatus status) {
        AccountEvent accountEvent = new AccountEvent();
        accountEvent.setAccount(account);
        accountEvent.setStatus(status);
        return accountEvent;
    }
}
