package pl.javastart.datadao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.javastart.datadao.model.Device;

public interface DeviceRepository extends JpaRepository<Device, Long> {
}
