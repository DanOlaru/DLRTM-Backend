package org.longmoneyoffshore.jdbcdemo;

import org.longmoneyoffshore.jdbcdemo.dao.JdbcDaoImpl;
import org.longmoneyoffshore.jdbcdemo.model.Circle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class JdbcDemo {

    public static void main(String[] args) throws SQLException {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        JdbcDaoImpl dao = ctx.getBean("jdbcDaoImpl", JdbcDaoImpl.class);


        //Circle circle = dao.getCircle(4);
        //System.out.println(circle.getName());

        //System.out.println("Entries #: " + dao.getCircleCount());
        System.out.println("Circle returned. Getting name: " + dao.getCircleForId(4).getName());

        dao.insertCircle(new Circle(14, "Egzelents"));
        dao.insertCircle(new Circle(31, "Repetitions"));

        //JdbcDaoImpl dao = (JdbcDaoImpl) context.getBean("jdbcDaoImpl");


        //Circle circle = dao.getCircle(4);
        //Circle circle = dao.getCircleXml(3);
        //System.out.println(circle.getName());


      /*

        List<Circle> myCircles = dao.getAllCircles();

        for (int i=0;i<myCircles.size();i++) {
            System.out.println("circle # " + (i+1) + " " + myCircles.get(i).getId() + " has hame: " + myCircles.get(i).getName());
        }*/

        System.out.println("================================================================================================================");


        //dao.createTriangleTable();
        //dao.insertCircle(new Circle (77, "Kevin Spacey"));
        //dao.insertCircle(new Circle (69, "Your Mamma"));
    }
}
