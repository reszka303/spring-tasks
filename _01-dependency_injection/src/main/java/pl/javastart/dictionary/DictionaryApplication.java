package pl.javastart.dictionary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class DictionaryApplication {

//    public static void main(String[] args) {
//        SpringApplication.run(DictionaryApplication.class, args);
//    }

    public static void main(String[] args) {
        LinguaController linguaController = new LinguaController();
        linguaController.mainLoop();
    }

}