package org.longmoneyoffshore.dlrtmweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@SpringBootApplication
@ImportResource("classpath:spring.xml")
public class DLRTMWebPlatform {

    public static void main(String[] args) {

        //TODO: SpringBoot applications don't use ApplicationContext???
        /*ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");        */

        SpringApplication.run(DLRTMWebPlatform.class, args);

    }
}
