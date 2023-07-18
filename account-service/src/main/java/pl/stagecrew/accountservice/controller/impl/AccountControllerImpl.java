package pl.stagecrew.accountservice.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pl.stagecrew.accountservice.controller.AccountController;
import pl.stagecrew.accountservice.dto.AccountDto;
import pl.stagecrew.accountservice.dto.CreateAccountDto;
import pl.stagecrew.accountservice.exception.AccountNotFoundException;
import pl.stagecrew.accountservice.mapper.AccountMapper;
import pl.stagecrew.accountservice.service.AccountService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AccountControllerImpl extends AbstractController implements AccountController {

    private final AccountMapper accountMapper;
    private final AccountService accountService;

    @Override
    public ResponseEntity<AccountDto> createAccount(CreateAccountDto accountDto) {
        AccountDto account = accountMapper.mapToAccountDto(accountService
                .createAccount(accountMapper.mapToAccount(accountDto), accountDto.getPassword()));
        return ResponseEntity.status(HttpStatus.CREATED).body(account);
    }

    @Override
    public ResponseEntity<AccountDto> getAccountById(UUID id) {
        try {
            AccountDto account = accountMapper.mapToAccountDto(accountService.getAccountById(id));
            return ResponseEntity.ok(account);
        } catch (AccountNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @Override
    public ResponseEntity<List<AccountDto>> getAllAccounts() {
        List<AccountDto> accounts = accountMapper.mapToAccountDtoList(accountService.getAllAccounts());
        return ResponseEntity.ok(accounts);
    }
}
