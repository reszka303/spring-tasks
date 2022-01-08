package pl.javastart.dictionary;

public class DataWriteException extends RuntimeException {

    public DataWriteException(String message) {
        System.err.println(message);
    }
}
