package pl.javastart.equipy.components.user;

public class UserMapper {

    static UserDto toDto(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setPesel(user.getPesel());
        return dto;
    }

    static User toEntity(UserDto userDto) {
        User entity = new User();
        entity.setId(entity.getId());
        entity.setFirstName(userDto.getFirstName());
        entity.setLastName(userDto.getLastName());
        entity.setPesel(userDto.getPesel());
        return entity;
    }

}
