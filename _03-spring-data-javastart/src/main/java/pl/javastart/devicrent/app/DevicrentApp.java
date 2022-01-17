package pl.javastart.devicrent.app;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DevicrentApp {
    public static void main(String[] args) {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("devicrentPU");
        emFactory.close();
    }

}
