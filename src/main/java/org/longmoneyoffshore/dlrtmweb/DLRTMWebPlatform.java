package org.longmoneyoffshore.dlrtmweb;

import org.longmoneyoffshore.dlrtmweb.Dao.ProductDaoImpl;
import org.longmoneyoffshore.dlrtmweb.Entities.models.entity.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@SpringBootApplication
public class DLRTMWebPlatform {

    public static void main(String[] args) {

        //TODO: is this necessary?
        //SpringApplication.run(DLRTMWebPlatform.class, args);

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        ProductDaoImpl dao = context.getBean("productDaoImpl", ProductDaoImpl.class);

        /*dao.insertProduct(new Product("0001",
                "Blender", "Phillips",
                "Netherlands", "food blender",
                20, 10.67,
                0,0,10,0,
                "Free Bread Knife","USD",
                100,0,0,0,
                "Unit","Pending recalls"));*/


        /*dao.insertProduct(new Product("0002", "Mixer", "Sony", "Japan",
                "food mixer", 47.8, 20.25,2,-1,20,10,
                "10% off blades","USD",180,0,0,0,
                "Unit","best in class"));*/

        /*dao.updateProduct(new Product("0001",
                "Blender", "Phillips",
                "Netherlands", "food blender",
                20, 10.67,
                0,0,10,0,
                "Free Bread Knife","USD",
                110,0,0,0,
                "Unit","Pending recalls"));*/

        dao.deleteProductById("0001");



        //Insert a list directly
        List<Product> products =  new ArrayList<>(Arrays.asList(
                new Product("0001", "Blender", "Phillips", "Netherlands",
                        "food blender", 20, 10.67,0,0,10,0,
                        "Free Bread Knife","USD", 100,0,0,0,
                        "Unit","Pending recalls"),

                new Product("0002", "Mixer", "Sony", "Japan",
                        "food mixer", 47.8, 20.25,2,-1,20,10,
                        "10% off blades","USD",180,0,0,0,
                        "Unit","best in class"),

                new Product("0003", "Grinder", "Sanyo", "South Korea",
                        "coffee grinder",33, 34.43,3,-3,0,14,
                        "free CD player","USD",60,0,0,20,
                        "Unit","new model"),

                new Product("0004", "Coffee Maker", "JVC", "Germany",
                        "coffee maker",22, 16.15,11,20,3,20,
                        "5 year warranty","USD",10,0,0,70,
                        "Unit","buyer's favorite"))

        );
        dao.insertProductList(products);



        List<Product> allProductsInTable = dao.getAllProducts();
        allProductsInTable.forEach(p -> System.out.println(p.toString() + "\n"));


        //Product product = dao.getProduct(4);
        //Product product = dao.getProductXml(3);
        //System.out.println(product.getName());


      /*  System.out.println("Entries #: " + dao.getProductCount());
        System.out.println("Product returned. Getting name: " + dao.getProductForId(3).getName());


        List<Product> myProducts = dao.getAllProducts();

        for (int i=0;i<myProducts.size();i++) {
            System.out.println("product # " + (i+1) + " " + myProducts.get(i).getId() + " has hame: " + myProducts.get(i).getName());
        }*/

        System.out.println("================================================================================================================");


        /*dao.insertProduct(new Product(14, "Egzelents"));
        dao.insertProduct(new Product(31, "Repetitions"));
        */

        //dao.createTriangleTable();
        //dao.insertProduct(new Product (77, "Kevin Spacey"));

    }
}
