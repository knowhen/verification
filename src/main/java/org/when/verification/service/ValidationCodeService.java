package org.when.verification.service;

public interface ValidationCodeService {

    void sendRegistrationCode(String phone);

    void sendLoginCode(String phone);

    void sendChangePasswordCode(String phone);

    void validateCode();
}
