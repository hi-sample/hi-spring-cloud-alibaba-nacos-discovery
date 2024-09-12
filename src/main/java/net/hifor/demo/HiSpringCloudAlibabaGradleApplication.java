package net.hifor.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HiSpringCloudAlibabaGradleApplication {

    public static void main(String[] args) {
        SpringApplication.run(HiSpringCloudAlibabaGradleApplication.class, args);
    }

}
