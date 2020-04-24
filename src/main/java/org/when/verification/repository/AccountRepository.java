package org.when.verification.repository;

import org.when.verification.entity.Account;

public interface AccountRepository {
    Account findByPhone(String phone);
}
