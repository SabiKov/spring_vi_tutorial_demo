package com360Training.employee.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "employees.addresses")
@Data
public class AddressesConfig {

    private String url;
}
