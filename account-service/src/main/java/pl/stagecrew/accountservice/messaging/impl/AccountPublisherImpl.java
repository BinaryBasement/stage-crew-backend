package pl.stagecrew.accountservice.messaging.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import pl.stagecrew.accountservice.messaging.AccountPublisher;
import pl.stagecrew.accountservice.model.Account;
import pl.stagecrew.shared.event.account.CreateAccountEvent;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class AccountPublisherImpl implements AccountPublisher {

    private final KafkaTemplate<UUID, CreateAccountEvent> createAccountKafkaTemplate;

    @Override
    public void sendCreateAccountEvent(Account account, String password) {
        CreateAccountEvent createAccountEvent = buildCreateAccountEvent(account, password);

        createAccountKafkaTemplate.send("account-topic", createAccountEvent.getEventId(), createAccountEvent);
    }

    private CreateAccountEvent buildCreateAccountEvent(Account account, String password) {
        CreateAccountEvent createAccountEvent = new CreateAccountEvent();
        createAccountEvent.setUsername(account.getUsername());
        createAccountEvent.setPassword(password);
        createAccountEvent.setEmail(account.getEmail());
        return createAccountEvent;
    }
}
