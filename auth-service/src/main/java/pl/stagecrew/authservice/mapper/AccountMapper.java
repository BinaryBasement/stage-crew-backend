package pl.stagecrew.authservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.stagecrew.authservice.entity.AccountEntity;
import pl.stagecrew.authservice.model.Account;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountMapper {

    Account mapToAccount(AccountEntity accountEntity);

    AccountEntity mapToAccountEntity(Account account);
}
