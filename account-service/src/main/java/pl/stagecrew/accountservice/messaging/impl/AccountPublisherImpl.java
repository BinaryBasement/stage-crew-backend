package pl.stagecrew.accountservice.messaging.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import pl.stagecrew.accountservice.messaging.AccountPublisher;
import pl.stagecrew.accountservice.model.Account;
import pl.stagecrew.shared.event.account.AccountEvent;
import pl.stagecrew.shared.event.account.AccountEventStatus;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class AccountPublisherImpl implements AccountPublisher {

    private final KafkaTemplate<UUID, AccountEvent> kafkaTemplate;

    @Override
    public void publishCreateAccountEvent(Account account) {
        AccountEvent accountEvent = buildAccountEvent(account, AccountEventStatus.CREATE);
        kafkaTemplate.send("create-account", accountEvent.getEventId(), accountEvent);
    }

    private AccountEvent buildAccountEvent(Account account, AccountEventStatus status) {
        AccountEvent accountEvent = new AccountEvent();
        accountEvent.setAccount(account);
        accountEvent.setStatus(status);
        return accountEvent;
    }
}
