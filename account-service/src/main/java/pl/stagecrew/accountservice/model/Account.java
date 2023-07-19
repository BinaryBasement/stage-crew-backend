package pl.stagecrew.accountservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.stagecrew.shared.model.AbstractModel;

@Getter
@Setter
@NoArgsConstructor
public class Account extends AbstractModel {

    private String username;

    private String email;

    private AccountData accountData;
}
