package net.elazzioui.customerservice.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "customer.params")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ConfigGlobal {
    private int x1;
    private int x2;
}
