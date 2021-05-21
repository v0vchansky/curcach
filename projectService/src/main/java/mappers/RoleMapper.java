package mappers;

import dto.RoleDTO;
import model.Role;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    Role toEntity(RoleDTO dto);

    RoleDTO toDTO(Role role);

    List<RoleDTO> listToDTO(List<Role> roles);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Role mergeWith(RoleDTO roleDTO, @MappingTarget Role role);
}
