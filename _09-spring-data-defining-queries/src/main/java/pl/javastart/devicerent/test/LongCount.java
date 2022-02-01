package pl.javastart.devicerent.test;

import java.util.Optional;

public class LongCount {

    private static final Optional<Long> deviceId = Optional.of(4L);
    private static final long scannerLong = 2;

    public static void main(String[] args) {
        long longNumber = addLong(deviceId, scannerLong);
        System.out.println("Long wynosi: " + longNumber);
    }

    private static long addLong(Optional<Long> deviceId, long scannerLong) {
        Long aLong = deviceId.stream()
                .filter(device -> device.equals(scannerLong))
                .findFirst().get();
        return aLong;
    }

}
