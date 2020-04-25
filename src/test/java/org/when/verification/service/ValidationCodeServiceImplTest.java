package org.when.verification.service;

import org.junit.Before;
import org.junit.Test;
import org.when.verification.constant.Constant;
import org.when.verification.domain.CodeGenerator;
import org.when.verification.repository.ValidationCodeRepository;

import static org.mockito.Mockito.*;

public class ValidationCodeServiceImplTest {
    private static final String TEST_CODE = "1234";
    private static final String TEST_PHONE = "01234567890";
    private ValidationCodeServiceImpl validationCodeService;
    private CodeGenerator generator;
    private SmsService smsService;
    private AccountService accountService;
    private ValidationCodeRepository codeRepository;

    @Before
    public void setUp() {
        generator = mock(CodeGenerator.class);
        smsService = mock(SmsService.class);
        accountService = mock(AccountService.class);
        codeRepository = mock(ValidationCodeRepository.class);
        validationCodeService = new ValidationCodeServiceImpl(generator, smsService, accountService, codeRepository);

        when(generator.generate(Constant.CODE_LENGTH)).thenReturn(TEST_CODE);
    }

    @Test
    public void testSendRegistrationCode() {
        validationCodeService.sendRegistrationCode(TEST_PHONE);

        verify(accountService, times(1)).accountExists(TEST_PHONE);
        verify(smsService, times(1)).sendMessage(TEST_PHONE, TEST_CODE);
    }

    @Test
    public void testSendLoginCode() {
        validationCodeService.sendLoginCode(TEST_PHONE);

        verify(accountService, times(1)).accountNotFound(TEST_PHONE);
        verify(smsService, times(1)).sendMessage(TEST_PHONE, TEST_CODE);
    }
}