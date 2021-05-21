package mappers;

import dto.UserDTO;
import model.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserDTO dto);

    UserDTO toDTO(User user);

    List<UserDTO> listToDTO(List<User> users);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User mergeWith(UserDTO userDTO, @MappingTarget User user);
}
