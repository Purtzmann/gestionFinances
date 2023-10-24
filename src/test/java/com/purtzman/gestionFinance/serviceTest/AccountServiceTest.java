package com.purtzman.gestionFinance.serviceTest;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.purtzman.gestionFinance.model.Account;
import com.purtzman.gestionFinance.repository.AccountRepository;
import com.purtzman.gestionFinance.service.AccountService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest //test for the whole context
public class AccountServiceTest {

    @InjectMocks
    private AccountService accountService;

    @Mock
    private AccountRepository accountRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAccountById() {
        Account account = new Account();
        account.setId(1L);
        account.setName("Test Account");

        when(accountRepository.findById(1L)).thenReturn(Optional.of(account));

        Account found = accountService.getAccountById(1L).orElse(null);
        assertEquals(1L, found.getId());
        assertEquals("Test Account", found.getName());
    }

}
