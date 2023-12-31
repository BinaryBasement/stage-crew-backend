package pl.stagecrew.shared.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public abstract class AbstractModel {

    private UUID id;

    private LocalDateTime createdDate;

    private LocalDateTime lastModifiedDate;

    private Long version;
}
