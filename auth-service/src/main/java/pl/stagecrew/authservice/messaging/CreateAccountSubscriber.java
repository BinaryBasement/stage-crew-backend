package pl.stagecrew.authservice.messaging;

import org.springframework.kafka.annotation.KafkaListener;
import pl.stagecrew.authservice.event.CreateAccountEvent;

public interface CreateAccountSubscriber {

    @KafkaListener(topics = "create-account", groupId = "auth-service")
    void onAccountCreated(CreateAccountEvent event);
}
