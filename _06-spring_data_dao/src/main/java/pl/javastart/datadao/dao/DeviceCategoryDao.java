package pl.javastart.datadao.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.javastart.datadao.model.DeviceCategory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class DeviceCategoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public DeviceCategory save(DeviceCategory deviceCategory) {
        entityManager.persist(deviceCategory);
        return deviceCategory;
    }

    public DeviceCategory read(Long id) {
        return entityManager.find(DeviceCategory.class, id);
    }

    @Transactional
    public DeviceCategory update(DeviceCategory deviceCategory) {
        return entityManager.merge(deviceCategory);
    }

    @Transactional
    public void delete(DeviceCategory deviceCategory) {
        DeviceCategory attachedDeviceCategory = read(deviceCategory.getId());
        entityManager.remove(attachedDeviceCategory);
    }

}
