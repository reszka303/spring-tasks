package pl.javastart.devicerent.app;

enum Options {
    EXIT(0, "Koniec"),
    ADD_DEVICE(1, "Dodaj urządzenie"),
    ADD_DEVICE_CATEGORY(2, "Dodaj kategorię urządzenia"),
    ADD_CUSTOMER(3, "Dodaj klienta"),
    RENT(4, "Wynajmij urządzenie"),
    REMOVE_DEVICE(5, "Usuń urządzenie"),
    REMOVE_DEVICE_CATEGORY(6, "Usuń kategorię urządzenia"),
    REMOVE_CUSTOMER(7, "Usuń klienta"),
    SEARCH_DEVICES(8, "Szukaj urządzenia po nazwie"),
    END_RENT(9, "Zakończ najem"),
    PRINT_CUSTOMERS(10, "Wyświetl klientów")
    ;

    private int number;
    private String name;

    Options(int number, String name) {
        this.number = number;
        this.name = name;
    }

    @Override
    public String toString() {
        return number + " - " + name;
    }

    static Options numberToCategory(int number) {
        if(number < 0 || number > values().length)
            throw new InvalidOptionException();
        return values()[number];
    }

}
