package org.when.verification.entity;

import java.time.LocalDateTime;

/**
 * @author: when
 * @create: 2020-04-24  16:33
 **/
public class ValidationCode {
    private String phone;
    private String validationCode;
    private LocalDateTime expirationTime;

    public ValidationCode() {
    }

    public ValidationCode(String phone, String validationCode) {
        this.phone = phone;
        this.validationCode = validationCode;
        this.expirationTime = LocalDateTime.now();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getValidationCode() {
        return validationCode;
    }

    public void setValidationCode(String validationCode) {
        this.validationCode = validationCode;
    }

    public LocalDateTime getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(LocalDateTime expirationTime) {
        this.expirationTime = expirationTime;
    }
}
