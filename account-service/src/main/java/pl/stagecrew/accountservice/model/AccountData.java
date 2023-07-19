package pl.stagecrew.accountservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.stagecrew.shared.model.AbstractModel;

@Getter
@Setter
@NoArgsConstructor
public class AccountData extends AbstractModel {

        private String name;

        private String surname;
}
