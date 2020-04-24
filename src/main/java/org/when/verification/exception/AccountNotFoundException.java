package org.when.verification.exception;

/**
 * @author: when
 * @create: 2020-04-24  15:53
 **/
public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(String phone) {
        super("Could not find account for " + phone);
    }
}
