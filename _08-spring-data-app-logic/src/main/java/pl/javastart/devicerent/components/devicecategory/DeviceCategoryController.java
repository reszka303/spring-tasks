package pl.javastart.devicerent.components.devicecategory;

import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;

@Service
public class DeviceCategoryController {

    private final Scanner scanner;
    private final DeviceCategoryRepository deviceCategoryRepository;

    public DeviceCategoryController(Scanner scanner, DeviceCategoryRepository deviceCategoryRepository) {
        this.scanner = scanner;
        this.deviceCategoryRepository = deviceCategoryRepository;
    }

    public void createCategory() {
        DeviceCategory deviceCategory = enterDeviceCategory();
        deviceCategoryRepository.save(deviceCategory);
        System.out.println("Dodano kategorię");
        System.out.println(deviceCategory);
    }

    private DeviceCategory enterDeviceCategory() {
        DeviceCategory deviceCategory = new DeviceCategory();
        System.out.println("Podaj nazwę kategorii urządzenia:");
        deviceCategory.setName(scanner.nextLine());
        System.out.println("Podaj opis kategorii:");
        deviceCategory.setDescription(scanner.nextLine());
        return deviceCategory;
    }

    public void removeDeviceCategory() {
        System.out.println("Podaj id kategorii urządzenia, które chcesz usunąć");
        long categoryId = scanner.nextLong();
        Optional<DeviceCategory> deviceCategory = deviceCategoryRepository.findById(categoryId);
        deviceCategory.ifPresentOrElse(deviceCategoryRepository::delete, () -> System.out.println("Brak kategorii o wskazanym ID"));
    }

}
