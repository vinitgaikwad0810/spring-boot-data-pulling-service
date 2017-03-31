package com.example;


import com.example.services.StoringService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Properties;


/***
 * java -cp FundingCircleQuizService.jar  com.example.FundingCircleQuizServiceApplication
 */
@SpringBootApplication
@ComponentScan("com.example")
public class FundingCircleQuizServiceApplication {


    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication(FundingCircleQuizServiceApplication.class);

        springApplication.run(args);

        ApplicationContextProvider.getContext().getBean(StoringService.class).clear();

        ApplicationContextProvider.getContext().getBean(StoringService.class).pullAndStoreData("UNRATE");

        ApplicationContextProvider.getContext().getBean(StoringService.class).pullAndStoreData("GDPC1");
        ApplicationContextProvider.getContext().getBean(StoringService.class).pullAndStoreData("UMCSENT");

    }
}
