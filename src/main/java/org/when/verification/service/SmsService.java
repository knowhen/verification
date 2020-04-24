package org.when.verification.service;

/**
 * @author: when
 * @create: 2020-04-24  11:42
 **/
public interface SmsService {
    void sendMessage(String phone, String code);
}
