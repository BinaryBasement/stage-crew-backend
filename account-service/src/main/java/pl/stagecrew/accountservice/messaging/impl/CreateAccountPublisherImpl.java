package pl.stagecrew.accountservice.messaging.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import pl.stagecrew.accountservice.event.CreateAccountEvent;
import pl.stagecrew.accountservice.event.CreateAccountStatus;
import pl.stagecrew.accountservice.messaging.CreateAccountPublisher;
import pl.stagecrew.accountservice.model.Account;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CreateAccountPublisherImpl implements CreateAccountPublisher {

    private final KafkaTemplate<UUID, CreateAccountEvent> kafkaTemplate;

    @Override
    public void sendCreateAccountMessage(Account account, String password) {
        CreateAccountEvent createAccountEvent = buildCreateAccountEvent(account, password);

        kafkaTemplate.send("create-account", createAccountEvent.getEventId(), createAccountEvent);
    }

    private CreateAccountEvent buildCreateAccountEvent(Account account, String password) {
        CreateAccountEvent createAccountEvent = new CreateAccountEvent();
        createAccountEvent.setUsername(account.getUsername());
        createAccountEvent.setPassword(password);
        createAccountEvent.setEmail(account.getEmail());
        createAccountEvent.setCreateAccountStatus(CreateAccountStatus.NEW);
        return createAccountEvent;
    }
}
