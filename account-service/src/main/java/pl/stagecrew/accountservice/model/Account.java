package pl.stagecrew.accountservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.stagecrew.shared.model.account.BasicAccount;

@Getter
@Setter
@NoArgsConstructor
public class Account extends BasicAccount {

    private AccountData accountData;
}
