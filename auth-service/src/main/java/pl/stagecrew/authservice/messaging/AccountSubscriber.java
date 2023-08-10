package pl.stagecrew.authservice.messaging;

import org.springframework.kafka.annotation.KafkaListener;
import pl.stagecrew.shared.event.account.AccountEvent;

public interface AccountSubscriber {

    @KafkaListener(topics = "create-account", groupId = "auth-service")
    void onCreateAccountEvent(AccountEvent event);
}
