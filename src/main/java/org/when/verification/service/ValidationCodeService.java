package org.when.verification.service;

public interface ValidationCodeService {

    void sendValidationCode(String phone);

    void validateCode();
}
