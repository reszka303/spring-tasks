package pl.javastart.devicerent.components.devicecategory;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeviceCategoryRepository extends JpaRepository<DeviceCategory, Long> {

    Optional<DeviceCategory> findByNameIgnoreCase(String name);
}
