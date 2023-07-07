package pl.stagecrew.accountservice.exception;

import java.util.UUID;

public class AccountNotFoundException extends Exception {

    private static final String MESSAGE = "Account with ID: %s not found";

    public AccountNotFoundException(UUID id) {
        super(String.format(MESSAGE, id));
    }
}
