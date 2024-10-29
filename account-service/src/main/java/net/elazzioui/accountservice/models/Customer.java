package net.elazzioui.accountservice.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Service;

@Builder
@Getter
@Setter
@ToString
public class Customer {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
