package pl.javastart.devicerent.app;

import org.springframework.stereotype.Controller;
import pl.javastart.devicerent.components.customer.CustomerController;
import pl.javastart.devicerent.components.device.DeviceController;
import pl.javastart.devicerent.components.devicecategory.DeviceCategoryController;
import pl.javastart.devicerent.components.rent.RentController;

import java.util.Arrays;
import java.util.Scanner;

@Controller
public class ApplicationController {

    private final Scanner scanner;
    private final DeviceController deviceController;
    private final DeviceCategoryController deviceCategoryController;
    private final CustomerController customerController;
    private final RentController rentController;

    public ApplicationController(Scanner scanner,
                                 DeviceController deviceController,
                                 DeviceCategoryController deviceCategoryController,
                                 CustomerController customerController,
                                 RentController rentController) {
        this.scanner = scanner;
        this.deviceController = deviceController;
        this.deviceCategoryController = deviceCategoryController;
        this.customerController = customerController;
        this.rentController = rentController;
    }

    public void run() {
        mainLoop();
    }

    private void mainLoop() {
        Options option;
        do {
            printOptions();
            option = readOption();
            executeOption(option);
        } while (option != Options.EXIT);
    }

    private void executeOption(Options option) {
        switch (option) {
            case EXIT -> closeApp();
            case ADD_DEVICE -> deviceController.createDevice();
            case ADD_DEVICE_CATEGORY -> deviceCategoryController.createCategory();
            case ADD_CUSTOMER -> customerController.createCustomer();
            case RENT -> rentController.rentDeviceToCustomer();
            case REMOVE_DEVICE -> deviceController.removeDevice();
            case REMOVE_DEVICE_CATEGORY -> deviceCategoryController.removeDeviceCategory();
            case REMOVE_CUSTOMER -> customerController.removeCustomer();
            case SERACH_DEVICES -> deviceController.searchDevice();
        }
    }

    private void closeApp() {
        scanner.close();
        System.out.println("Bye, bye");
    }

    private Options readOption() {
        boolean correctOptionSelected = false;
        Options option = null;
        while(!correctOptionSelected) {
            System.out.println("Podaj ID opcji:");
            int optionId = scanner.nextInt();
            scanner.nextLine();
            try {
                option = Options.numberToCategory(optionId);
                correctOptionSelected = true;
            } catch(InvalidOptionException e) {
                System.err.println(e.getMessage());
            }
        }
        return option;
    }

    private void printOptions() {
        System.out.println("Opcje:");
        Arrays.stream(Options.values()).forEach(System.out::println);
    }

}
