package pl.javastart.datadao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.javastart.datadao.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
