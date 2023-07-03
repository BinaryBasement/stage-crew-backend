package pl.stagecrew.accountservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public abstract class AbstractModel {

    private UUID id;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Long version;
}
