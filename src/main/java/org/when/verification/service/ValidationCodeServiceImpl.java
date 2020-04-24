package org.when.verification.service;

import org.when.verification.constant.Constant;
import org.when.verification.domain.CodeGenerator;
import org.when.verification.entity.ValidationCode;
import org.when.verification.exception.PersistenceException;
import org.when.verification.exception.SmsException;
import org.when.verification.repository.ValidationCodeRepository;

/**
 * @author: when
 * @create: 2020-04-24  09:28
 **/
public class ValidationCodeServiceImpl implements ValidationCodeService {
    private CodeGenerator codeGenerator;
    private SmsService smsService;
    private AccountService accountService;
    private ValidationCodeRepository codeRepository;


    public ValidationCodeServiceImpl(CodeGenerator codeGenerator,
                                     SmsService smsService,
                                     ValidationCodeRepository codeRepository) {
        this.codeGenerator = codeGenerator;
        this.smsService = smsService;
        this.codeRepository = codeRepository;
    }

    @Override
    public void sendValidationCode(String phone) {
        checkExistence(phone);
        String code = codeGenerator.generate(Constant.CODE_LENGTH);
        sendValidationCode(phone, code);
    }


    protected void checkExistence(String phone) {
        accountService.checkExistence(phone);
    }

    protected void sendValidationCode(String phone, String code) {
        try {
            smsService.sendMessage(phone, code);
        } catch (SmsException e) {
            return;
        }
        persistentCode(phone, code);
    }

    protected void persistentCode(String phone, String code) {
        ValidationCode validationCode = new ValidationCode(phone, code);
        try {
            codeRepository.save(validationCode);
        } catch (Exception e) {
            throw new PersistenceException();
        }
    }

    @Override
    public void validateCode() {

    }
}
