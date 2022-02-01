package pl.javastart.devicerent.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EndRent {

    private static final Scanner scanner = new Scanner(System.in);

    private static void main(String[] args) {
        System.out.println("Kończenie najmu");
        System.out.println("Podaj pesel klienta");
        String pesel = scanner.nextLine();
        System.out.println("Podaj ID urządzenia");
        long deviceId = scanner.nextLong();
        Optional<Customer> customer = findByPesel(pesel, getCustomers());
        Optional<Device> device = findById(deviceId, getDevices());
        if (customer.isPresent() && device.isPresent()) {

        }
    }

    private static Optional<Customer> findByPesel(String pesel, List <Customer> list)  {
        List<Customer> collect = list.stream()
                .filter(l -> l.getPesel().equals(pesel))
                .collect(Collectors.toList());
        return Optional.ofNullable(collect.get(1));
    }

    private static Optional<Device> findById(long id, List<Device> list) {
        List<Device> collect = list.stream()
                .filter(l -> l.getId() == id)
                .collect(Collectors.toList());
        return Optional.ofNullable(collect.get(1));
    }

    private static List<DeviceHasCustomer> getDeviceHasCustomer() {
        List<DeviceHasCustomer> deviceHasCustomers = new ArrayList<>();
        deviceHasCustomers.add(new DeviceHasCustomer(new Device(1), new Customer("1")));
        deviceHasCustomers.add(new DeviceHasCustomer(new Device(2), new Customer("2")));
        deviceHasCustomers.add(new DeviceHasCustomer(new Device(4), new Customer("3")));
        deviceHasCustomers.add(new DeviceHasCustomer(new Device(3), new Customer("4")));
        return deviceHasCustomers;
    }

    private static List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();
        customers.add((new Customer("1")));
        customers.add((new Customer("2")));
        customers.add((new Customer("3")));
        customers.add((new Customer("4")));
        return customers;
    }

//    private static List<Optional<Customer>> getCustomers() {
//        List<Optional<Customer>> customers = new ArrayList<>();
//        customers.add(Optional.of(new Customer("1")));
//        customers.add(Optional.of(new Customer("2")));
//        customers.add(Optional.of(new Customer("3")));
//        customers.add(Optional.of(new Customer("4")));
//        return customers;
//    }

    private static List<Device> getDevices() {
        List<Device> devices = new ArrayList<>();
        devices.add(new Device(1));
        devices.add(new Device(2));
        devices.add(new Device(3));
        devices.add(new Device(4));
        return devices;
    }

    private static class DeviceHasCustomer {
       private Device device;
       private Customer customer;

        public DeviceHasCustomer(Device device, Customer customer) {
            this.device = device;
            this.customer = customer;
        }

        public Device getDevice() {
            return device;
        }

        public void setDevice(Device device) {
            this.device = device;
        }

        public Customer getCustomer() {
            return customer;
        }

        public void setCustomer(Customer customer) {
            this.customer = customer;
        }
    }

    private static class Customer {
        private String pesel;

        public Customer(String pesel) {
            this.pesel = pesel;
        }

        public String getPesel() {
            return pesel;
        }

        public void setPesel(String pesel) {
            this.pesel = pesel;
        }
    }

    private static class Device {
        private long id;

        public Device(long id) {
            this.id = id;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }
    }

}
