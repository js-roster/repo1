package org.optaplanner.examples.nurserostering;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class NurseApp {
    public static void main(String[] args) {
        SpringApplication.run(NurseApp.class);
    }
}
