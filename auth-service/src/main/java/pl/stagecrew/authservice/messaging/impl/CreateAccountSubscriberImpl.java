package pl.stagecrew.authservice.messaging.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.stagecrew.authservice.event.CreateAccountEvent;
import pl.stagecrew.authservice.messaging.CreateAccountSubscriber;

@Component
@RequiredArgsConstructor
public class CreateAccountSubscriberImpl implements CreateAccountSubscriber {

    @Override
    public void onAccountCreated(CreateAccountEvent event) {
        System.out.println("Received event: " + event.getEventId());
    }
}
