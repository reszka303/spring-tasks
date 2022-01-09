package pl.javastart.dictionary.test;

import java.util.*;

public class QuickDictionary {

    private static String fileName = "data.csv";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Entry> entries = createSet();
        entries.forEach(System.out::println);

        Collections.shuffle(entries);

        System.out.println();
        System.out.println("Po losowaniu:");
        entries.forEach(System.out::println);
        makeTest(input, entries);

    }

    private static void makeTest(Scanner input, List<Entry> entries) {
        int score = 0;
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
        System.out.println("Twój wynik to: " + score + " na " + entries.size());
    }

    private static List<Entry> createSet() {
        List<Entry> entries = new ArrayList<>();
        entries.add(new Entry("pies", "dog"));
        entries.add(new Entry("kot", "cat"));
        entries.add(new Entry("samochód", "car"));
        entries.add(new Entry("okno", "window"));
        entries.add(new Entry("czekolada", "chocolate"));
        entries.add(new Entry("język", "language"));
        return entries;
    }

    private static class Entry {

        private String original;
        private String translation;

        public Entry(String original, String translation) {
            this.original = original;
            this.translation = translation;
        }

        public String getOriginal() {
            return original;
        }

        public void setOriginal(String original) {
            this.original = original;
        }

        public String getTranslation() {
            return translation;
        }

        public void setTranslation(String translation) {
            this.translation = translation;
        }

        @Override
        public String toString() {
            return original + " : " + translation;
        }
    }

}
