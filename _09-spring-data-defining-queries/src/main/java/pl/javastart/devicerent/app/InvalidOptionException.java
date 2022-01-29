package pl.javastart.devicerent.app;

public class InvalidOptionException extends RuntimeException{
    InvalidOptionException() {
        super("Opcja nie istnieje");
    }
}
