package pl.javastart.devicerent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import pl.javastart.devicerent.app.ApplicationController;

import java.util.Scanner;

@SpringBootApplication
public class DeviceRentApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx =
                SpringApplication.run(DeviceRentApplication.class, args);

        ApplicationController controller = ctx.getBean(ApplicationController.class);
        controller.run();
    }

    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }

}
