package com.purtzman.gestionFinance.controllerTest;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.purtzman.gestionFinance.controller.AccountController;
import com.purtzman.gestionFinance.repository.AccountRepository;
import com.purtzman.gestionFinance.service.AccountService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AccountController.class) // test only for
public class AccountControllerTest {

   @Autowired
   private MockMvc mockMvc;

   @MockBean
   private AccountService accountService;

   @MockBean
   private AccountRepository accountRepository;

   @Test
   public void testGetAccount() throws Exception {
      mockMvc.perform(get("/api/accounts/1")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
   }

}
