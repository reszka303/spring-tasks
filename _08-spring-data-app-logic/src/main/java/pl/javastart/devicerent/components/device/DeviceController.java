package pl.javastart.devicerent.components.device;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.javastart.devicerent.components.devicecategory.DeviceCategory;
import pl.javastart.devicerent.components.devicecategory.DeviceCategoryRepository;

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
//            System.out.println(device);
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
        System.out.println("Kategoria(id) urządzenia:");
        long categoryId = scanner.nextLong();
        Optional<DeviceCategory> category = deviceCategoryRepository.findById(categoryId);
        scanner.nextLine();
        category.ifPresentOrElse(device::setDeviceCategory,
                () -> {
                    throw new DeviceCategoryNotFoundException("Kategoria o podanym ID nie istnieje");
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

}
