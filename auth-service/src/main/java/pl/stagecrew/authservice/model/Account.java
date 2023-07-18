package pl.stagecrew.authservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Account extends AbstractModel {

    private String username;

    private String password;

    private String email;

}
