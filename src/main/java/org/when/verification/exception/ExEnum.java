package org.when.verification.exception;

/**
 * @author: when
 * @create: 2020-04-24  16:57
 **/
public enum ExEnum {
    ACCOUNT_NOT_FOUND("账户不存在"),
    ACCOUNT_EXISTS("账号已注册"),
    SEND_CODE_FAILED("验证码发送失败，请重试");
    private String message;

    ExEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
