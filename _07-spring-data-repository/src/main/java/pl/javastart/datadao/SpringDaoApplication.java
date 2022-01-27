package pl.javastart.datadao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.javastart.datadao.model.Customer;
import pl.javastart.datadao.model.Device;
import pl.javastart.datadao.model.DeviceCategory;
import pl.javastart.datadao.repository.DeviceCategoryRepository;
import pl.javastart.datadao.repository.DeviceRepository;

@SpringBootApplication
public class SpringDaoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx =
                SpringApplication.run(SpringDaoApplication.class, args);

        DeviceRepository deviceDao = ctx.getBean(DeviceRepository.class);
        DeviceCategoryRepository deviceCategoryDao = ctx.getBean(DeviceCategoryRepository.class);

        Device wiertarkaUdarowa = new Device();
        wiertarkaUdarowa.setName("Wiertarka udarowa");
        wiertarkaUdarowa.setDescription("Wiertarka udarowa o dużej mocy 3000W z zestawem wierteł w komplecie");
        wiertarkaUdarowa.setPrice(238.50);
        wiertarkaUdarowa.setQuantity(5);

        Device imadłoWielofunkcyjne = new Device();
        imadłoWielofunkcyjne.setName("Imadło wielofunkcyjne");
        imadłoWielofunkcyjne.setDescription("Imadło wielofunkcyjne obrotowe 4 Yato YT-6505");
        imadłoWielofunkcyjne.setPrice(279);
        imadłoWielofunkcyjne.setQuantity(2);

        Device pilarkaLancuchowa = new Device();
        pilarkaLancuchowa.setName("Pilarka łańcuchowa");
        pilarkaLancuchowa.setDescription("Pilarka łańcuchowa Graphite 58G950");
        pilarkaLancuchowa.setPrice(356);
        pilarkaLancuchowa.setQuantity(4);


        DeviceCategory elektronarzędzia = new DeviceCategory();
        elektronarzędzia.setName("Elektronarzędzia");
        elektronarzędzia.setDescription("Wiertarki, szlifierki, młoty udarowe i inne elektronarzędzia");

        DeviceCategory narzędzia = new DeviceCategory();
        narzędzia.setName("Narzędzia");
        narzędzia.setDescription("Narzędzia ręczne, narzędzia pomiarowe, narzędzia motoryzacyjne");

        DeviceCategory domIOgrod  = new DeviceCategory();
        domIOgrod.setName("Narzędzia mechaniczne");
        domIOgrod.setDescription("Narzędzia mechaniczne, narzędzia ręczne, elektryka, oświetlenie");

        Customer janKowalski = new Customer();
        janKowalski.setFirstName("Jan");
        janKowalski.setLastName("Kowalski");
        janKowalski.setPesel("90908765123");
        janKowalski.setIdNumber("ABC678123");

        Customer piotrAdamski = new Customer();
        piotrAdamski.setFirstName("Piotr");
        piotrAdamski.setLastName("Adamski");
        piotrAdamski.setPesel("12345678911");
        piotrAdamski.setIdNumber("ABC123456");

        Customer arkadiuszNowak = new Customer();
        piotrAdamski.setFirstName("Arkadiusz");
        piotrAdamski.setLastName("Nowak");
        piotrAdamski.setPesel("32345688911");
        piotrAdamski.setIdNumber("ABD123656");


        wiertarkaUdarowa.setDeviceCategory(elektronarzędzia);
        imadłoWielofunkcyjne.setDeviceCategory(narzędzia);
        pilarkaLancuchowa.setDeviceCategory(domIOgrod);


        wiertarkaUdarowa.addCustomers(janKowalski);
        imadłoWielofunkcyjne.addCustomers(piotrAdamski);
//        pilarkaLancuchowa.addCustomers(arkadiuszNowak);

        deviceDao.save(wiertarkaUdarowa);
        deviceDao.save(imadłoWielofunkcyjne);
//        deviceDao.save(pilarkaLancuchowa);

    }

}
