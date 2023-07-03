package pl.stagecrew.accountservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Account extends AbstractModel {

    private String username;

    private String email;

    private String name;

    private String surname;
}
