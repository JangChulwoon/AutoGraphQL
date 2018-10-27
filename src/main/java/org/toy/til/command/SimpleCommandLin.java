package org.toy.til.command;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class SimpleCommandLin implements CommandLineRunner {
    @Override
    public void run(String... args) {
        List a = Arrays.asList(2, 4, 5);
        System.out.println(a);

        getList(a);
        System.out.println(a);
    }

    private void getList(List a) {
        a = Arrays.asList(0);

    }
}
