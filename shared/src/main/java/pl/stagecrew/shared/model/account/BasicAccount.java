package pl.stagecrew.shared.model.account;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.stagecrew.shared.model.AbstractModel;

@Getter
@Setter
@NoArgsConstructor
public class BasicAccount extends AbstractModel {

    private String username;

    private String password;

    private String email;

}
