package pl.stagecrew.accountservice.messaging;

import org.springframework.kafka.annotation.KafkaListener;
import pl.stagecrew.shared.event.account.AccountEvent;

public interface AccountSubscriber {

    @KafkaListener(topics = "create-account", groupId = "account-service")
    void onAccountEvent(AccountEvent event);
}
