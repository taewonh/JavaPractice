package com.taewon.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaPracticeApplication {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("hid");
        });
        thread.start();
        thread.run();

        SpringApplication.run(JavaPracticeApplication.class, args);
    }

}
