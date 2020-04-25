package org.when.verification.exception;

/**
 * @author: when
 * @create: 2020-04-25  11:28
 **/
public class AccountExistsException extends RuntimeException {
    public AccountExistsException(String phone) {
        super(ExEnum.ACCOUNT_EXISTS + ": " + phone);
    }
}
