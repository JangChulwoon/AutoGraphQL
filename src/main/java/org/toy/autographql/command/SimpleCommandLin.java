package org.toy.autographql.command;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SimpleCommandLin implements CommandLineRunner {
    @Override
    public void run(String... args) {
        System.out.println("hello world");
    }
}
