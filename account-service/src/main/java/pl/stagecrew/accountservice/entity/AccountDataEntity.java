package pl.stagecrew.accountservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.stagecrew.shared.entity.AbstractEntity;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "account_data")
public class AccountDataEntity extends AbstractEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;
}
