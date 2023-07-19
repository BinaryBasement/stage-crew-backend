package pl.stagecrew.accountservice.messaging;

import pl.stagecrew.accountservice.model.Account;

public interface AccountPublisher {

    void sendCreateAccountEvent(Account account, String password);
}
