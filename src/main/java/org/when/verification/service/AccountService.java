package org.when.verification.service;

import org.when.verification.entity.Account;

import java.util.Optional;

public interface AccountService {
    Optional<Account> findByPhone(String phone);
    void checkExistence(String phone);
}
