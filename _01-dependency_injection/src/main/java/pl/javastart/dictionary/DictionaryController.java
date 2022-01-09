package pl.javastart.dictionary;

import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.*;

@Controller
public class DictionaryController {

//    private EntryRepository entryRepository = new EntryRepository();
//    private FileService fileService = new FileService();
//    private Scanner input = new Scanner(System.in);

    private final EntryRepository entryRepository;
    private final FileService fileService;
    private final Scanner input;

    public DictionaryController(EntryRepository entryRepository, FileService fileService, Scanner input) {
        this.entryRepository = entryRepository;
        this.fileService = fileService;
        this.input = input;
    }

    void run() {
        mainLoop();
    }

    private void mainLoop() {
        Option option;
        do {
            System.out.println("Witaj w aplikacji LinguApp");
            option = chooseOption();
            executeOption(option);
        } while (option != Option.EXIT);
    }

    private void executeOption(Option option) {
        switch (option) {
            case EXIT -> close();
            case ADD_PHRASE -> addEntry();
            case TEST -> test();
        }
    }

    private void close() {
        try {
            fileService.writeEntries(entryRepository.getEntries());
            System.out.println("Zapisano stan aplikacji");
        } catch (IOException e) {
            throw new DataWriteException("Błąd zapisu danych do pliku");
        }
        System.out.println("Bye Bye!");
    }

    private void addEntry() {
        System.out.println("Podaj oryginalną frazę");
        String original = input.nextLine();
        System.out.println("Podaj tłumaczenie");
        String translation = input.nextLine();
        Entry entry = new Entry(original, translation);
        entryRepository.add(entry);
    }

    private void test() {
        int score = 0;
        if (entryRepository.isEmpty()) {
            System.out.println("Dodaj przynajmniej jedną frazę do bazy.");
            return;
        }
        List<Entry> entries = entryRepository.getEntries();
        Collections.shuffle(entries);
        for (Entry entry : entries) {
            System.out.println("Podaj tłumaczenie dla: " + entry.getOriginal());
            String translation = input.nextLine();
            if (translation.equalsIgnoreCase(entry.getTranslation())) {
                System.out.println("Odpowiedź poprawna");
                score++;
            } else {
                System.out.println("Odpowiedź nie poprawna");
            }
        }
        System.out.printf("Twój wynik to: %d/%d\n\n", score, entries.size());
    }

    private Option chooseOption() {
        int optionNumber;
        Optional<Option> option;
        do {
            System.out.println("Wybierz opcję:");
            printOptions();
            optionNumber = getOption();
            option = Option.fromInt(optionNumber);
        } while (option.isEmpty());
        return option.get();
    }

    private int getOption() {
        boolean numberOk = false;
        int number = 0;
        while (!numberOk) {
            try {
                number = getInt();
                numberOk = true;
            } catch (InputMismatchException e) {
                System.err.println("Nie możesz podać liter lub innych znaków, tylko cyfry");
            }
        }
        return number;
    }

    private int getInt() {
        try {
            return input.nextInt();
        } finally {
            input.nextLine();
        }
    }

    private void printOptions() {
       Option[] options = Option.values();
        for (Option option : options) {
            System.out.println(option);
        }
    }

    private enum Option {

        EXIT(0, "Koniec programu"),
        ADD_PHRASE(1, "Dodaj frazę"),
        TEST(2, "Test");

        private final int number;
        private final String description;

        Option(int number, String description) {
            this.number = number;
            this.description = description;
        }

        private static Optional<Option> fromInt(int number) {
            Option[] options = Option.values();
            if (number >= 0 && number < options.length) {
                return Optional.of(Option.values()[number]);
            } else {
                return Optional.empty();
            }
        }

        @Override
        public String toString() {
            return number + " - " + description;
        }

    }

}
