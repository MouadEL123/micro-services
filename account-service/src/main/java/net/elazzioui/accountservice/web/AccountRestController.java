package net.elazzioui.accountservice.web;

import net.elazzioui.accountservice.clients.CustomerRestClient;
import net.elazzioui.accountservice.entities.Account;
import net.elazzioui.accountservice.repositories.AccountRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountRestController {
    private AccountRepository accountRepository;
    private CustomerRestClient customerRestClient;
    public AccountRestController(AccountRepository accountRepository,
                                 CustomerRestClient customerRestClient
    ){
        this.accountRepository = accountRepository;
        this.customerRestClient = customerRestClient;
    }

    @GetMapping("/accounts")
    public List<Account> getAccounts(){
       List<Account> accountList = this.accountRepository.findAll();
       accountList.forEach(account -> {
           account.setCustomer(customerRestClient.getCustomer(account.getCustomerId()));
       });
        return accountList;
    }

    @GetMapping("/accounts/{id}")
    public Account getAccount(@PathVariable String id){
        Account account = this.accountRepository.findById(id).get();
        account.setCustomer(customerRestClient.getCustomer(account.getCustomerId()));
        return account ;
    }
}
