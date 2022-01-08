package pl.javastart.dictionary;

public class DataReadException extends RuntimeException {

    public DataReadException(String message) {
        System.err.println(message);
    }
}
