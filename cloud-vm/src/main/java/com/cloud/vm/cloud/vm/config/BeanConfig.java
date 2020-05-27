package com.cloud.vm.cloud.vm.config;

import com.cloud.vm.cloud.vm.pve.base.PveClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("pve")
public class BeanConfig {

    private String host;
    private int port;

    public PveClient pveClient() {
        return new PveClient(host, port);
    }
}
