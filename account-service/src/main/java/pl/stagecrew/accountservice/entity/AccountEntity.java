package pl.stagecrew.accountservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "accounts",
        indexes = {
                @Index(name = "idx_username", columnList = AccountEntity_.USERNAME, unique = true),
                @Index(name = "idx_email", columnList = AccountEntity_.EMAIL, unique = true)
        },
        uniqueConstraints = {
                @UniqueConstraint(name = "uc_username", columnNames = AccountEntity_.USERNAME),
                @UniqueConstraint(name = "uc_email", columnNames = AccountEntity_.EMAIL)
        })
public class AccountEntity extends AbstractEntity {

    @Column(nullable = false, updatable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "account_data_id", nullable = false)
    private AccountDataEntity accountData;

}
