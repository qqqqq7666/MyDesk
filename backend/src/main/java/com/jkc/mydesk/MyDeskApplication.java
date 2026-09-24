package com.jkc.mydesk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MyDeskApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyDeskApplication.class, args);
    }

}
