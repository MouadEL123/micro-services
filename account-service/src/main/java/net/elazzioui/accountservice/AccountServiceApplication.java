package net.elazzioui.accountservice;

import net.elazzioui.accountservice.clients.CustomerRestClient;
import net.elazzioui.accountservice.entities.Account;
import net.elazzioui.accountservice.enums.AccountType;
import net.elazzioui.accountservice.repositories.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication implements CommandLineRunner {

    private AccountRepository accountRepository;
    private CustomerRestClient customerRestClient;

    public AccountServiceApplication(AccountRepository accountRepository
            , CustomerRestClient customerRestClient){
        this.accountRepository = accountRepository;
        this.customerRestClient = customerRestClient;
    }

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(customerRestClient.getCustomers());
        customerRestClient.getCustomers().forEach(customer -> {
            Account account = Account.builder()
                    .id(UUID.randomUUID().toString())
                    .balance(Math.random() * 800000)
                    .createdAt(LocalDate.now())
                    .type(Math.random() > 0.5 ? AccountType.CURRENT_ACCOUNT : AccountType.SAVING_ACCOUNT)
                    .customerId(customer.getId())
                    .customer(customer)
                    .build();
            accountRepository.save(account);
        });
    }
}
