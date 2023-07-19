package pl.stagecrew.accountservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.stagecrew.accountservice.dto.AccountDataDto;
import pl.stagecrew.accountservice.entity.AccountDataEntity;
import pl.stagecrew.accountservice.model.AccountData;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountDataMapper {

    AccountData mapToAccountData(AccountDataDto accountDataDto);

    AccountDataDto mapToAccountDataDto(AccountData accountData);

    AccountData mapToAccountData(AccountDataEntity accountDataEntity);

    AccountDataEntity mapToAccountDataEntity(AccountData accountData);
}
