package org.when.verification.service;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.when.verification.entity.Account;
import org.when.verification.exception.AccountNotFoundException;
import org.when.verification.repository.AccountRepository;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AccountServiceImplTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();
    private static final String TEST_PHONE = "01234567890";
    private Account account;
    private AccountServiceImpl accountService;
    private AccountRepository repository;

    @Before
    public void setUp() {
        account = new Account();
        account.setPhone(TEST_PHONE);
        repository = mock(AccountRepository.class);
        accountService = new AccountServiceImpl(repository);
    }

    @Test
    public void testFindByPhone() {
        when(repository.findByPhone(TEST_PHONE)).thenReturn(account);
        Optional<Account> optional = accountService.findByPhone(TEST_PHONE);
        assertTrue(optional.isPresent());
    }

    @Test
    public void testFindByPhone_null() {
        when(repository.findByPhone(TEST_PHONE)).thenReturn(null);
        Optional<Account> optional = accountService.findByPhone(TEST_PHONE);
        assertEquals(Optional.empty(), optional);
    }

    @Test
    public void ifAbsentThenThrowAccountNotFoundException() {
        exception.expect(AccountNotFoundException.class);
        when(repository.findByPhone(TEST_PHONE)).thenReturn(null);
        accountService.checkExistence(TEST_PHONE);
    }
}