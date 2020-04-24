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
    private ValidationCodeRepository codeRepository;

    @Before
    public void setUp() {
        generator = mock(CodeGenerator.class);
        smsService = mock(SmsService.class);
        codeRepository = mock(ValidationCodeRepository.class);
        validationCodeService = new ValidationCodeServiceImpl(generator, smsService, codeRepository);
    }

    @Test
    public void testSendCode() {
        when(generator.generate(Constant.CODE_LENGTH)).thenReturn(TEST_CODE);

        validationCodeService.sendValidationCode(TEST_PHONE);

        verify(smsService).sendMessage(TEST_PHONE, TEST_CODE);
    }
}