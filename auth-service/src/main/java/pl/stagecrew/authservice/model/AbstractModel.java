package pl.stagecrew.authservice.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public abstract class AbstractModel {

    private UUID id;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Long version;
}
