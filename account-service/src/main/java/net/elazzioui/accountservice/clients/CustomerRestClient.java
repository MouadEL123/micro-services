package net.elazzioui.accountservice.clients;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import net.elazzioui.accountservice.models.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="CUSTOMER-SERVICE")
public interface CustomerRestClient {

    @GetMapping("/customers")
    @CircuitBreaker(name="CustomerService" , fallbackMethod = "getDefaultCustomers")
    List<Customer> getCustomers();

    @GetMapping("/customers/{id}")
    @CircuitBreaker(name="CustomerService" , fallbackMethod = "getDefaultCustomer")
    Customer getCustomer(@PathVariable Long id);

    default List<Customer> getDefaultCustomers(Exception exception){
        return List.of();
    }

    default Customer getDefaultCustomer(Long id , Exception exception){
        return Customer.builder()
                .id(id)
                .firstName("not available")
                .lastName("not available")
                .email("not available")
                .build();
    }

}
