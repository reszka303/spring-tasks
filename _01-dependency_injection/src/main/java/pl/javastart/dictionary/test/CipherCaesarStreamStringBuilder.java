package pl.javastart.dictionary.test;

public class CipherCaesarStreamStringBuilder {

    private static final int SHIFT = 3;

    public static void main(String[] args) {

        String text = "Znak to jest to";
        String encrypt = encrypt(text);
        System.out.printf("Tekst: '%s', po zakodowaniu: '%s'\n", text, encrypt);
        String decrypt = decrypt(encrypt);
        System.out.printf("Zakodowany tekst '%s', po odkodowaniu '%s'\n", encrypt, decrypt);
    }

    private static String encrypt(String text) {
        return text.chars()
                .map(unicode -> unicode + SHIFT)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    private static String decrypt(String cipher) {
        return cipher.chars()
                .map(unicode -> unicode - SHIFT)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

}
