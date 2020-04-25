package org.when.verification.exception;

/**
 * @author: when
 * @create: 2020-04-25  11:05
 **/
public class BizException extends RuntimeException {
    public BizException(String message) {
        super(message);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }
}
