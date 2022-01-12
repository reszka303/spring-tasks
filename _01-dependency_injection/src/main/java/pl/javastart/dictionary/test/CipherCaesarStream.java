package pl.javastart.dictionary.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


//https://www.baeldung.com/java-string-to-stream

public class CipherCaesarStream {

    private static final int SHIFT = 3;

    public static void main(String[] args) {

        String text = "Znak to jest to";

        IntStream intStream = toIntStream(text);
        int[] ints = intStream.toArray();
        System.out.println("IntStream[]:");
        System.out.println(Arrays.toString(ints));

        Stream<Character> chars = fromCharsToString(text);
        System.out.println("chars():");
        chars.forEach(System.out::print);
        System.out.println();

        Stream<Character> codePoint = codePointToString(text);
        System.out.println("codePoint():");
        codePoint.forEach(System.out::print);
        System.out.println();

        IntStream shift = shift(text, SHIFT);
        System.out.println("Przesunięcie:");
        System.out.println(Arrays.toString(shift.toArray()));

        Stream<Character> stringAfterShift = afterShiftChars(text);
        System.out.println("Character po przesunięciu chars() ale bez referencji do metody, zwracane -> Stream<Character>:");
        stringAfterShift.forEach(System.out::print);
        System.out.println();

        Stream<Character> stringAfterShiftCodePointWithReferenceToMethod =
                afterShiftCodePointWithReferenceToMethod(text);
        System.out.println("Character po przesunięciu codePoint i referencja do metody wraz ze stałą SHIFT, zwracane -> Stream<Character>");
        stringAfterShiftCodePointWithReferenceToMethod.forEach(System.out::print);
        System.out.println();

        List<String> stringList = afterShiftStrings(text);
        System.out.println("Strings po przesunięciu chars() ale bez referencji do metody, zwracane -> List<String>:");
        System.out.println(stringList);

        String encrypt = afterShiftStringsWithReferenceToMethod(text);
        System.out.println("String encrypt po zakodowaniu: " + encrypt);

        String decrypt = afterShiftBackNoReferenceToMethod(encrypt);
        System.out.println("String decrypt po zdekodowaniu: " + decrypt);


    }

    private static IntStream toIntStream(String text) {
        return text.chars();
    }

    private static Stream<Character> fromCharsToString(String text) {
        return text.chars()
                .mapToObj(c -> (char)c);
    }

    private static Stream<Character> codePointToString(String text) {
        return text.codePoints()
                .mapToObj(c -> (char)c);
    }

    private static IntStream shift(String text, int shift) {
        return text.chars()
                .map(unicode -> unicode + shift);
    }

    private static Stream<Character> afterShiftChars(String text) {
        return text.chars()
                .map(unicode -> unicode + 3)
                .mapToObj(c -> (char)c);
    }

    private static Stream<Character> afterShiftCodePointWithReferenceToMethod(String text) {
        return text.codePoints()
                .map(CipherCaesarStream::shift)
                .mapToObj(c -> (char)c);
    }

    private static List<String> afterShiftStrings(String text) {
        return text.chars()
                .map(unicode -> unicode + SHIFT)
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.toList());
    }

    private static String afterShiftStringsWithReferenceToMethod(String text) {
        return text.chars()
                .map(CipherCaesarStream::shift)
                .mapToObj(str -> String.valueOf((char) str))
                .collect(Collectors.joining(""));
    }

    private static String afterShiftBackNoReferenceToMethod(String cipher) {
        return cipher.chars()
                .map(unicode -> unicode - SHIFT)
                .mapToObj(str -> String.valueOf((char)str))
                .collect(Collectors.joining(""));
    }


    private static int shift(int unicode) {
        return unicode + SHIFT;
    }
}
