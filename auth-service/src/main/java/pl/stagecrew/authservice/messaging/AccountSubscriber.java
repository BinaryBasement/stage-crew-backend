package pl.stagecrew.authservice.messaging;

import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import pl.stagecrew.shared.event.account.CreateAccountEvent;

@KafkaListener(topics = "account-topic", groupId = "auth-service")
public interface AccountSubscriber {

    @KafkaHandler
    void onAccountCreated(CreateAccountEvent event);
}
