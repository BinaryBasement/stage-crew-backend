package pl.stagecrew.accountservice.service;

import pl.stagecrew.accountservice.exception.AccountNotFoundException;
import pl.stagecrew.accountservice.model.Account;

import java.util.List;
import java.util.UUID;

public interface AccountService {

    Account createAccount(Account account, String password);

    Account getAccountById(UUID id) throws AccountNotFoundException;

    List<Account> getAllAccounts();
}
