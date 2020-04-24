package org.when.verification.exception;

/**
 * @author: when
 * @create: 2020-04-24  16:57
 **/
public enum ExEnum {
    ACCOUNT_NOT_FOUND("账户不存在");
    public String message;

    ExEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
