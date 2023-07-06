package pl.stagecrew.accountservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.stagecrew.accountservice.dto.AccountDto;
import pl.stagecrew.accountservice.dto.CreateAccountDto;

import java.util.List;
import java.util.UUID;

@RequestMapping("/accounts")
public interface AccountController {

    @PostMapping("/register")
    ResponseEntity<AccountDto> createAccount(@RequestBody CreateAccountDto accountDto);

    @GetMapping("/{id}")
    ResponseEntity<AccountDto> getAccountById(@PathVariable UUID id);

    @GetMapping
    ResponseEntity<List<AccountDto>> getAllAccounts();
}
