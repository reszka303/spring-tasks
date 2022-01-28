package pl.javastart.devicerent.components.customer;

import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;

@Service
public class CustomerController {

    private final Scanner scanner;
    private final CustomerRepository customerRepository;

    public CustomerController(Scanner scanner, CustomerRepository customerRepository) {
        this.scanner = scanner;
        this.customerRepository = customerRepository;
    }

    public void createCustomer() {
        Customer customer = enterCustomer();
        customerRepository.save(customer);
        System.out.println("Dodano klienta");
        System.out.println(customer);
    }

    private Customer enterCustomer() {
        Customer customer = new Customer();
        System.out.println("Podaj imię:");
        customer.setFirstName(scanner.nextLine());
        System.out.println("Podaj nazwisko:");
        customer.setLastName(scanner.nextLine());
        System.out.println("Podaj pesel");
        customer.setPesel(scanner.nextLine());
        System.out.println("Podaj numer dowodu");
        customer.setIdNumber(scanner.nextLine());
        return customer;
    }

    public void removeCustomer() {
        System.out.println("Podaj id klienta, którego chcesz usunąć");
        long customerId = scanner.nextLong();
        Optional<Customer> customer = customerRepository.findById(customerId);
        customer.ifPresentOrElse(customerRepository::delete, () -> System.out.println("Brak klienta o wskazanym id"));
    }
}
