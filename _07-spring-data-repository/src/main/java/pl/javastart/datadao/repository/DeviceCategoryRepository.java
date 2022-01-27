package pl.javastart.datadao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.javastart.datadao.model.DeviceCategory;

public interface DeviceCategoryRepository extends JpaRepository<DeviceCategory, Long> {
}
