package mk.ukim.finki.lab_1_201037;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class Lab1201037Application {

    public static void main(String[] args) {
        SpringApplication.run(Lab1201037Application.class, args);
    }

}
