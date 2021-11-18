package serhii.orlov.spring.service.mapper;

import org.springframework.stereotype.Component;
import serhii.orlov.spring.dto.response.UserResponseDto;
import serhii.orlov.spring.model.User;

@Component
public class UserMapper implements ResponseDtoMapper<UserResponseDto, User> {
    @Override
    public UserResponseDto mapToDto(User user) {
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setId(user.getId());
        responseDto.setEmail(user.getEmail());
        responseDto.setRoles(user.getRoles());
        return responseDto;
    }
}
