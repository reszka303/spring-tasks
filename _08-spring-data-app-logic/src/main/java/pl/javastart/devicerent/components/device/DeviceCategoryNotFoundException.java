package pl.javastart.devicerent.components.device;

public class DeviceCategoryNotFoundException extends RuntimeException {
    public DeviceCategoryNotFoundException(String message) {
        super(message);
    }
}
