package pl.stagecrew.accountservice.messaging;

import pl.stagecrew.accountservice.model.Account;

public interface CreateAccountPublisher {

    void sendCreateAccountMessage(Account account, String password);
}
