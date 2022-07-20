package simple.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * Startup class of the application
 */
@SpringBootApplication
public class Application {
    /**
     * main of the application
     * @param args String[]
     */
    public static void main(String[] args) {
        System.out.println("Springboot starting ");
        SpringApplication.run(Application.class, args);
    }
}
