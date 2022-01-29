package pl.javastart.devicerent.components.device;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.javastart.devicerent.components.devicecategory.DeviceCategory;
import pl.javastart.devicerent.components.devicecategory.DeviceCategoryRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class DeviceController {

    private final Scanner scanner;
    private final DeviceRepository deviceRepository;
    private final DeviceCategoryRepository deviceCategoryRepository;

    public DeviceController(Scanner scanner, DeviceRepository deviceRepository,
                            DeviceCategoryRepository deviceCategoryRepository) {
        this.scanner = scanner;
        this.deviceRepository = deviceRepository;
        this.deviceCategoryRepository = deviceCategoryRepository;
    }

    @Transactional
    public void createDevice() {
        try {
            Device device = enterDevice();
            deviceRepository.save(device);
            System.out.println("Dodano urządzenie");
            System.out.println(device);
        } catch (DeviceCategoryNotFoundException e) {
            System.err.println("Urządzenia nie dodano");
            System.err.println(e.getMessage());
        }
    }

    private Device enterDevice() {
        Device device = new Device();
        System.out.println("Nazwa urządzenia:");
        device.setName(scanner.nextLine());
        System.out.println("Opis urządzenia:");
        device.setDescription(scanner.nextLine());
        System.out.println("Cena urządzenia:");
        device.setPrice(scanner.nextDouble());
        System.out.println("Ilość(szt) urządzenia:");
        device.setQuantity(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Kategoria urządzenia:");
        String categoryName = scanner.nextLine();
        Optional<DeviceCategory> category = deviceCategoryRepository.findByNameIgnoreCase(categoryName);
        category.ifPresentOrElse(device::setDeviceCategory,
                () -> {
                    throw new DeviceCategoryNotFoundException("Kategoria o takiej nazwie nie istnieje");
                }
        );
        return device;
    }

    public void removeDevice() {
        System.out.println("Podaj id urządzenia, które chcesz usunąć");
        long deviceId = scanner.nextLong();
        Optional<Device> device = deviceRepository.findById(deviceId);
        device.ifPresentOrElse(deviceRepository::delete, () -> System.out.println("Brak urządzenia o wskazanym ID"));
    }

    public void searchDevice() {
        System.out.println("Podaj fragment nazwy:");
        String name = scanner.nextLine();
        List<Device> devices = deviceRepository.findAllByNameContainingIgnoreCase(name);
        if (devices.isEmpty()) {
            System.out.println("Brak urządzeń o wskazanej nazwie");
        } else {
            System.out.println("Znalezione urządzenia");
            devices.forEach(System.out::println);
        }
    }

}
