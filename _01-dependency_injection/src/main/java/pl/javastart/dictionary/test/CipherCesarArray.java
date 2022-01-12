package pl.javastart.dictionary.test;

import java.util.Arrays;

//https://stackoverflow.com/questions/15117316/convert-decimal-to-unicode-char

public class CipherCesarArray {

    private static final int SHIFT = 3;

    public static void main(String[] args) {

        String text = "Znak";

        System.out.println(text);

        int[] ints = convertToInt(text);
        System.out.println("ints: " + Arrays.toString(ints));

        int[] intsWithShift = convertToIntWithShift(text, SHIFT);
        System.out.println("ints with shift: " + Arrays.toString(intsWithShift));

        String[] strings = convertToString(ints);
        System.out.println("strings: " + Arrays.toString(strings));

        String[] stringsWithShift = convertToString(intsWithShift);
        System.out.println("strings with Shift: " + Arrays.toString(stringsWithShift));

        int l = 108;
        System.out.println("l w unikodzie: " + l);
        String s = Character.toString((char)l);
        System.out.println("l w stringu: " + s);
    }

    private static int[] convertToInt(String text) {
        char[] chars = text.toCharArray();
        int charsCapacity = chars.length;
        int[] ints = new int[charsCapacity];
        for (int i = 0; i < chars.length; i++) {
            ints[i] = chars[i];
        }
        return ints;
    }

    private static int[] convertToIntWithShift(String text, int shift) {
        char[] chars = text.toCharArray();
        int charsCapacity = chars.length;
        int[] ints = new int[charsCapacity];
        for (int i = 0; i < chars.length; i++) {
            ints[i] = chars[i] + shift;
        }
        return ints;
    }

    private static String[] convertToString(int[] ints) {
        int intsCapacity = ints.length;
        String[] strings = new String[intsCapacity];
        for (int i = 0; i < ints.length; i++) {
            strings[i] = Character.toString((char)ints[i]);
        }
        return strings;
    }
}
