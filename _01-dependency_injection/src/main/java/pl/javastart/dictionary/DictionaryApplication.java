package pl.javastart.dictionary;

//@SpringBootApplication
public class DictionaryApplication {

//    public static void main(String[] args) {
//        SpringApplication.run(DictionaryApplication.class, args);
//    }

    public static void main(String[] args) {
        DictionaryController dictionaryController = new DictionaryController();
        dictionaryController.run();
    }

}