package pl.javastart.dictionary.test;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RetrieveIntException {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        getInt();
        boolean number = false;
//        System.out.println(number);
//        System.out.println(!number);
//        System.out.println();
    }

    private static int getInt() {
        boolean numberOk = false;
        System.out.printf("Przed wywołaniem pętli while numberOk to: %b\n", numberOk);
        int number = 0;
        while (!numberOk) {
            try {
                System.out.println("Podaj cyfrę");
                number = input.nextInt();
                numberOk = true;
                System.out.printf("W środku try catch'a numberOk to: %b\n", numberOk);
                System.out.printf("Podałeś: %s\n", number);
            } catch (InputMismatchException e) {
                System.err.println("Błąd, tylko cyfra");
            } finally {
                input.nextLine();
            }
            System.out.printf("Po wywołaniu pętli while numberOk to: %b\n", numberOk);
        }
        return number;
    }

}
