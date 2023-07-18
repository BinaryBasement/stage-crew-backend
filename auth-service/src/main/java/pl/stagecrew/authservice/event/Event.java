package pl.stagecrew.authservice.event;

import java.time.LocalDateTime;
import java.util.UUID;

public interface Event {

    UUID getEventId();

    LocalDateTime getEventDate();
}
