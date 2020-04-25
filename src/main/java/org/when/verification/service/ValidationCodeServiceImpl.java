package org.when.verification.service;

import org.when.verification.constant.Constant;
import org.when.verification.domain.CodeGenerator;
import org.when.verification.entity.ValidationCode;
import org.when.verification.exception.BizException;
import org.when.verification.exception.ExEnum;
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
                                     AccountService accountService,
                                     ValidationCodeRepository codeRepository) {
        this.codeGenerator = codeGenerator;
        this.smsService = smsService;
        this.accountService = accountService;
        this.codeRepository = codeRepository;
    }

    @Override
    public void sendRegistrationCode(String phone) {
        // validate pattern of phone
        // validate rate of sending code
        // check existence of account
        accountService.accountExists(phone);
        sendValidationCode(phone);
    }

    @Override
    public void sendLoginCode(String phone) {
        // validate pattern of phone
        // validate rate of sending code
        // check existence of account
        accountService.accountNotFound(phone);
        sendValidationCode(phone);
    }

    @Override
    public void sendChangePasswordCode(String phone) {
        accountService.accountNotFound(phone);
        sendValidationCode(phone);
    }

    protected void sendValidationCode(String phone) {
        String code = codeGenerator.generate(Constant.CODE_LENGTH);
        sendMessage(phone, code);
        persistentCode(phone, code);
    }

    protected void sendMessage(String phone, String code) {
        try {
            smsService.sendMessage(phone, code);
        } catch (SmsException e) {
            throw new BizException(ExEnum.SEND_CODE_FAILED.getMessage(), e);
        }
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
