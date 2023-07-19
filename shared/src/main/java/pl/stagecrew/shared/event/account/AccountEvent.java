package pl.stagecrew.shared.event.account;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.stagecrew.shared.event.AbstractEvent;
import pl.stagecrew.shared.model.account.BasicAccount;

@Getter
@Setter
@NoArgsConstructor
public class AccountEvent extends AbstractEvent {

    private BasicAccount account;

    private AccountEventStatus status;
}
