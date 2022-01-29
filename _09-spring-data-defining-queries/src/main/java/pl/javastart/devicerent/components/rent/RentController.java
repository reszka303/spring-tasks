package pl.javastart.devicerent.components.rent;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.javastart.devicerent.components.customer.Customer;
import pl.javastart.devicerent.components.customer.CustomerRepository;
import pl.javastart.devicerent.components.device.Device;
import pl.javastart.devicerent.components.device.DeviceRepository;

import java.util.Optional;
import java.util.Scanner;

@Service
public class RentController {

    private final Scanner scanner;
    private DeviceRepository deviceRepository;
    private CustomerRepository customerRepository;

    public RentController(Scanner scanner, DeviceRepository deviceRepository,
                          CustomerRepository customerRepository) {
        this.scanner = scanner;
        this.deviceRepository = deviceRepository;
        this.customerRepository = customerRepository;
    }

    @Transactional
    public void rentDeviceToCustomer() {
        try {
            rent();
        } catch (RentException e) {
            System.err.println(e.getMessage());
        }
    }

    private void rent() {
        System.out.println("Podaj pesel klienta");
        String pesel = scanner.nextLine();
        System.out.println("Podaj ID urządzenia");
        long deviceID = scanner.nextLong();
        Optional<Customer> customer = customerRepository.findByPesel(pesel);
        Optional<Device> device = deviceRepository.findById(deviceID);
        if (customer.isPresent()) {
            device.ifPresentOrElse(dev -> {
                if (dev.getQuantity() > dev.getCustomers().size()) {
                    dev.addCustomers(customer.get());
                    System.out.println("Wypożyczono urządzenie");
                } else {
                    throw new RentException("Brak wolnych urządzeń o wskazanym ID");
                }
            }, () -> {
                throw new RentException("Brak urządzenia o wskazanym ID");
            });
        } else {
            throw new RentException("Brak klienta o wskazanym peselu");
        }
    }

}
