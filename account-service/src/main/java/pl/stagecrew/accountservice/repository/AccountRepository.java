package pl.stagecrew.accountservice.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.stagecrew.accountservice.entity.AccountEntity;

import java.util.UUID;

@Transactional(Transactional.TxType.MANDATORY)
public interface AccountRepository extends JpaRepository<AccountEntity, UUID> {

    void deleteByUsername(String username);
}
