package org.when.verification.service;

import org.when.verification.entity.Account;
import org.when.verification.exception.AccountExistsException;
import org.when.verification.exception.AccountNotFoundException;
import org.when.verification.repository.AccountRepository;

import java.util.Optional;

/**
 * @author: when
 * @create: 2020-04-24  15:52
 **/
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Optional<Account> findByPhone(String phone) {
        Account account = accountRepository.findByPhone(phone);
        return Optional.ofNullable(account);
    }

    @Override
    public void accountExists(String phone) {
        findByPhone(phone).orElseThrow(() -> new AccountNotFoundException(phone));
    }

    @Override
    public void accountNotFound(String phone) {
        Optional<Account> optional = findByPhone(phone);
        if (optional.isPresent()) {
            throw new AccountExistsException(phone);
        }
    }
}
