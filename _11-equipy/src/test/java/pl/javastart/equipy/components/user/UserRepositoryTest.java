package pl.javastart.equipy.components.user;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;
    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void shouldFindAllByLastNameIgnoreCase() {
        // given
        User kowalski = testEntityManager.persist(new User("Kowalski"));
        User zalewski = testEntityManager.persist(new User("Zalewski"));
        User korczynska = testEntityManager.persist(new User("Korczyńska"));
        User sokolik = testEntityManager.persist(new User("Sokolik"));

        // when
        List<User> kowalskiList = userRepository.findAllByLastNameIgnoreCase("kowalski");
        List<User> zalewskiList = userRepository.findAllByLastNameIgnoreCase("zaleWSKI");
        List<User> korczynskaList = userRepository.findAllByLastNameIgnoreCase("KORcZyŃSkA");
        List<User> sokolikList = userRepository.findAllByLastNameIgnoreCase("SOKOLIK");

        // then
        assertThat(kowalskiList).contains(kowalski);
        assertThat(zalewskiList).contains(zalewski);
        assertThat(korczynskaList).contains(korczynska);
        assertThat(sokolikList).contains(sokolik);
    }

    @Test
    public void shouldFindAllByLastNameContainingIgnoreCase() {
        // given
        User kowalski = testEntityManager.persist(new User("Kowalski"));
        User zalewski = testEntityManager.persist(new User("Zalewski"));
        User korczynska = testEntityManager.persist(new User("Korczyńska"));
        User sokolik = testEntityManager.persist(new User("Sokolik"));

        // when
        List<User> kow = userRepository.findAllByLastNameContainingIgnoreCase("kow");
        List<User> ale = userRepository.findAllByLastNameContainingIgnoreCase("ale");
        List<User> rcz = userRepository.findAllByLastNameContainingIgnoreCase("rcz");
        List<User> oko = userRepository.findAllByLastNameContainingIgnoreCase("oko");

        // then
        assertThat(kow).contains(kowalski);
        assertThat(ale).contains(zalewski);
        assertThat(rcz).contains(korczynska);
        assertThat(oko).contains(sokolik);
    }

}
