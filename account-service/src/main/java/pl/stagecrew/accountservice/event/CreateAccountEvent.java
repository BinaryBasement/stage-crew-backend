package pl.stagecrew.accountservice.event;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateAccountEvent extends AbstractEvent {

    private String username;

    private String password;

    private String email;

    private CreateAccountStatus createAccountStatus;
}
