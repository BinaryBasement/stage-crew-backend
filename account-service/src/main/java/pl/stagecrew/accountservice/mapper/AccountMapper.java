package pl.stagecrew.accountservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import pl.stagecrew.accountservice.dto.AccountDto;
import pl.stagecrew.accountservice.dto.CreateAccountDto;
import pl.stagecrew.accountservice.entity.AccountEntity;
import pl.stagecrew.accountservice.model.Account;

import java.util.List;

@Mapper(componentModel = "spring", uses = {AccountDataMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountMapper {

    Account mapToAccount(CreateAccountDto createAccountDto);

    AccountDto mapToAccountDto(Account account);

    Account mapToAccount(AccountEntity accountEntity);

    AccountEntity mapToAccountEntity(Account account);

    AccountEntity mapToAccountEntity(@MappingTarget AccountEntity accountEntity, Account account);

    List<Account> mapToAccountList(List<AccountEntity> accountEntityList);

    List<AccountDto> mapToAccountDtoList(List<Account> accountList);
}
