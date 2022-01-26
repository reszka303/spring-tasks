package pl.javastart.datadao.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.javastart.datadao.model.Device;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class DeviceDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Device save(Device device) {
        entityManager.persist(device);
        return device;
    }

    public Device read(Long id) {
        return entityManager.find(Device.class, id);
    }

    @Transactional
    public Device update(Device device) {
        return entityManager.merge(device);
    }

    @Transactional
    public void delete(Device device) {
        Device attachedDevice = read(device.getId());
        entityManager.remove(attachedDevice);
    }

}
