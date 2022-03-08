package pl.javastart.equipy.components.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByLastNameIgnoreCase(String lastName);

    List<User> findAllByLastNameContainingIgnoreCase(String lastName);
}
