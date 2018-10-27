package org.toy.til.configure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("org.toy.til")
@SpringBootApplication
public class AutographqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutographqlApplication.class, args);
    }
}
