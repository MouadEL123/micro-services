package net.elazzioui.customerservice;

import net.elazzioui.customerservice.config.ConfigGlobal;
import net.elazzioui.customerservice.entities.Customer;
import net.elazzioui.customerservice.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.stream.Stream;

@SpringBootApplication
@EnableConfigurationProperties({ConfigGlobal.class})
public class CustomerServiceApplication implements CommandLineRunner {
    @Autowired
    private CustomerRepository customerRepository;

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Stream.of("mouad" , "adil" , "karima").forEach(name -> {
            Customer customer = Customer.builder()
                    .firstName(name)
                    .lastName(name)
                    .email(name+"@gmail.com")
                    .build();
            customerRepository.save(customer);
        });
    }
}
