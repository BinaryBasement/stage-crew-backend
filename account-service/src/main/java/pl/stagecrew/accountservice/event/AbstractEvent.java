package pl.stagecrew.accountservice.event;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public abstract class AbstractEvent implements Event {

    private UUID eventId = UUID.randomUUID();

    private LocalDateTime eventDate = LocalDateTime.now();
}
