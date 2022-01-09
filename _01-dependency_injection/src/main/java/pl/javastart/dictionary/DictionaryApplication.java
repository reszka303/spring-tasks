package pl.javastart.dictionary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class DictionaryApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx =
                SpringApplication.run(DictionaryApplication.class, args);

        DictionaryController controller = ctx.getBean(DictionaryController.class);
        controller.run();
    }

    @Bean
    Scanner input() {
        return new Scanner(System.in);
    }

}

//    public static void main(String[] args) {
//        DictionaryController dictionaryController = new DictionaryController();
//        dictionaryController.run();
//    }