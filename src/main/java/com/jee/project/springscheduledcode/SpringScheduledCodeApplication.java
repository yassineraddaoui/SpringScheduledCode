package com.jee.project.springscheduledcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@SpringBootApplication

public class SpringScheduledCodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringScheduledCodeApplication.class, args);
    }

    @Scheduled(initialDelay = 1000L,
            fixedDelayString = "${job.delay}"
            //cron= "0 0 18 0 0 MON-FRI"
    )
    void someJob() {
        System.out.println("Now is " + LocalDateTime.now());
    }
}

@Configuration
@EnableScheduling
@ConditionalOnProperty(name = "scheduling.enabled", matchIfMissing = true)
class SchedulingConfig {

}