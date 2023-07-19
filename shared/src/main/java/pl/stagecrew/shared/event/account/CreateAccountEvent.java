package pl.stagecrew.shared.event.account;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.stagecrew.shared.event.AbstractEvent;

@Getter
@Setter
@NoArgsConstructor
public class CreateAccountEvent extends AbstractEvent {

    private String username;

    private String password;

    private String email;
}
