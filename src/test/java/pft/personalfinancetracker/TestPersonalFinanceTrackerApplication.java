package pft.personalfinancetracker;

import org.springframework.boot.SpringApplication;

public class TestPersonalFinanceTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.from(PersonalFinanceTrackerApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
