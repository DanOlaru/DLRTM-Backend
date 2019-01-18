import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class DLRTMWebPlatform {

    public static void main(String[] args) {
        //SpringApplication.run(DLRTMWebPlatform.class, args);


        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        //JdbcDaoImpl dao = (JdbcDaoImpl) context.getBean("jdbcDaoImpl");
        //JdbcDaoImpl dao = context.getBean("jdbcDaoImpl", JdbcDaoImpl.class);


        //Circle circle = dao.getCircle(4);
        //Circle circle = dao.getCircleXml(3);
        //System.out.println(circle.getName());


      /*  System.out.println("Entries #: " + dao.getCircleCount());
        System.out.println("Circle returned. Getting name: " + dao.getCircleForId(3).getName());


        List<Circle> myCircles = dao.getAllCircles();

        for (int i=0;i<myCircles.size();i++) {
            System.out.println("circle # " + (i+1) + " " + myCircles.get(i).getId() + " has hame: " + myCircles.get(i).getName());
        }*/

        System.out.println("================================================================================================================");


        /*dao.insertCircle(new Circle(14, "Egzelents"));
        dao.insertCircle(new Circle(31, "Repetitions"));
        */

        //dao.createTriangleTable();
        //dao.insertCircle(new Circle (77, "Kevin Spacey"));


    }
}
