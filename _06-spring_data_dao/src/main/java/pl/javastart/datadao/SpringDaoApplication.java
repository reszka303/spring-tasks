package pl.javastart.datadao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.javastart.datadao.dao.DeviceDao;
import pl.javastart.datadao.model.Customer;
import pl.javastart.datadao.model.Device;
import pl.javastart.datadao.model.DeviceCategory;

@SpringBootApplication
public class SpringDaoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx =
                SpringApplication.run(SpringDaoApplication.class, args);

        DeviceDao deviceDao = ctx.getBean(DeviceDao.class);

        Device device = new Device();
        device.setName("Wiertarka udarowa");
        device.setDescription("Wiertarka udarowa o dużej mocy 3000W z zestawem wierteł w komplecie");
        device.setPrice(80);
        device.setQuantity(5);

        DeviceCategory deviceCategory = new DeviceCategory();
        deviceCategory.setName("Elektronarzędzia");
        deviceCategory.setDescription("Wiertarki, szlifierki, młoty udarowe i inne elektronarzędzia");

        Customer customer = new Customer();
        customer.setFirstName("Jan");
        customer.setLastName("Kowalski");
        customer.setPesel("90908765123");
        customer.setIdNumber("ABC678123");

        device.setDeviceCategory(deviceCategory);
        device.addCustomers(customer);

        deviceDao.save(device);
    }

}
