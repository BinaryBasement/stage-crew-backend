package pl.stagecrew.authservice.messaging;


import pl.stagecrew.authservice.model.Account;

public interface AccountPublisher {

    void publishRollbackAccountEvent(Account account);
}
