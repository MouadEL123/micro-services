package net.elazzioui.customerservice.web;

import net.elazzioui.customerservice.config.ConfigGlobal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RefreshScope
public class ConfigRestController {
    @Value("${global.params.p1}")
    private int p1;
    @Value("${global.params.p2}")
    private int p2;
    @Value("${customer.params.x1}")
    private int x1;
    @Value("${customer.params.x2}")
    private int x2;
    @Autowired
    ConfigGlobal configGlobal;
    // aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
    @GetMapping("/config")
    public Map<String , Integer> getConfig(){
        return Map.of("x1",configGlobal.getX1(),"x2", configGlobal.getX1(),"p1",p1,"p2",p2);
    }
}
