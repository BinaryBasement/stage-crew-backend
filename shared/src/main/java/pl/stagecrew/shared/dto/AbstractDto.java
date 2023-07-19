package pl.stagecrew.shared.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public abstract class AbstractDto {

    private UUID id;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
