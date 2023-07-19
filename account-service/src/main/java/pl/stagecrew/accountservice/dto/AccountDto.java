package pl.stagecrew.accountservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.stagecrew.shared.dto.AbstractDto;

@Getter
@Setter
@NoArgsConstructor
public class AccountDto extends AbstractDto {

    private String username;

    private String email;

    private AccountDataDto accountData;
}
