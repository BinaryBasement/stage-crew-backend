package pl.stagecrew.accountservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AccountDataDto extends AbstractDto {

    private String name;

    private String surname;
}
