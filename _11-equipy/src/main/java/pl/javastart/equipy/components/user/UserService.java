package pl.javastart.equipy.components.user;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    List<UserDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toDto)
                .collect(Collectors.toList());
    }

    List<UserDto> findByLastName(String lastName) {
//        return userRepository.findAllByLastNameIgnoreCase(lastName)
//                .stream()
//                .map(UserMapper::toDto)
//                .collect(Collectors.toList());

        return userRepository.findAllByLastNameContainingIgnoreCase(lastName)
                .stream()
                .map(UserMapper::toDto)
                .collect(Collectors.toList());
    }

}
