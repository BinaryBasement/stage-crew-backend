package pl.stagecrew.accountservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "accounts",
        indexes = {
                @Index(name = "idx_username", columnList = "username", unique = true),
                @Index(name = "idx_email", columnList = "email", unique = true)
        },
        uniqueConstraints = {
                @UniqueConstraint(name = "uc_username", columnNames = "username"),
                @UniqueConstraint(name = "uc_email", columnNames = "email")
        })
public class AccountEntity extends AbstractEntity {

    private String username;

    private String email;

    private String name;

    private String surname;
}
