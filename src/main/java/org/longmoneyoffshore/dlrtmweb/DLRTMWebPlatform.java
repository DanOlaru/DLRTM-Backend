package org.longmoneyoffshore.dlrtmweb;

import org.longmoneyoffshore.dlrtmweb.Dao.ProductDaoImpl;
import org.longmoneyoffshore.dlrtmweb.Entities.models.entity.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@ImportResource("classpath:spring.xml")
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class DLRTMWebPlatform {

    public static void main(String[] args) {

        System.out.println("=========================================DANNY-O=======================================================================");

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        FakeDataSets fakeData = new FakeDataSets();

        ProductDaoImpl dao = context.getBean("productDaoImpl", ProductDaoImpl.class);
        System.out.println("Inputting data into database");
        dao.dropTable();
        dao.createTable();
        dao.insertProductList(fakeData.productsExtended);
        System.out.println("NUMBER OF ITEMS IN DB " + dao.getProductCount());
        System.out.println("SHOW THE DATABASE CONTENTS:");
        dao.getAllProducts().forEach(p -> System.out.println(p.getProductUniqueID().trim() + " " + p.getProductName().trim()));

        SpringApplication.run(DLRTMWebPlatform.class, args);

        /*ApplicationContext applicationContext = SpringApplication.run(DLRTMWebPlatform.class, args);

        for (String name : applicationContext.getBeanDefinitionNames()) {
            System.out.println(name);
        }*/

        /*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String itemId = "-1";
        while (true) {

            try {
                System.out.print("INPUT THE ID OF THE PRODUCT TO PULL UP FROM DB: ");
                itemId = br.readLine();

                itemId.trim();

                if (itemId.equals("-1")) break;


            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Pull up single DB item:" + itemId);

            System.out.println("ITEM IN DB WITH ID " + dao.getProductName(itemId));

            //System.out.println(dao.getProductById(itemId).toString());

        }*/


        /*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {

            int proId = -1;

            try {
                System.out.print("INPUT THE ID OF THE PRODUCT TO SAVE TO DB: ");
                proId = Integer.valueOf(br.readLine());

                if (proId == -1) break;


            } catch (IOException e) {
                e.printStackTrace();
            }

            dao.insertProduct(products.get(proId));

            System.out.println("DB AFTER INSERT:");
            allProductsInTable = dao.getAllProducts();
            allProductsInTable.forEach(p -> System.out.println(p.toString() + "\n"));

        }*/


       /* System.out.println("DELETE OPTIONS:");
        dao.getAllProducts().forEach(p-> System.out.println(p.toString() + "\n"));

        while (true) {

            String productIdS = "-1";

            try {
                System.out.print("INPUT THE ID OF THE PRODUCT TO DELETE FROM DB: ");
                productIdS = br.readLine();

                productIdS.trim();

                if (productIdS.equals("-1")) break;


            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("DELETING:" + dao.getProductById(productIdS));
            dao.deleteProductById(productIdS);

            //Show the actual contents of the DB
            System.out.println("DB AFTER DELETE:");
            allProductsInTable = dao.getAllProducts();
            allProductsInTable.forEach(p -> System.out.println(p.toString() + "\n"));

        }*/
    }
}
