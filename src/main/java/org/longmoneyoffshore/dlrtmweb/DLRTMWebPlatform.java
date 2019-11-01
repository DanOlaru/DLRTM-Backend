package org.longmoneyoffshore.dlrtmweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:spring.xml")
public class DLRTMWebPlatform {

    public static void main(String[] args) {

        SpringApplication.run(DLRTMWebPlatform.class, args);

    }
}
