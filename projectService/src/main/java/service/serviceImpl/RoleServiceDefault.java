package service.serviceImpl;

import lombok.RequiredArgsConstructor;
import model.Role;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import repository.RoleRepository;
import security.exceptions.CustomException;
import service.RoleService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceDefault implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public boolean existsByCode(String code) {
        return roleRepository.existsByCode(code);
    }

    @Override
    public Role findByCode(String code) {
        final Role role = roleRepository.findByCode(code);
        if (role == null) {
            final String msg = String.format("%s [%s] was not found", Role.class.getName(),  code);
            throw new CustomException(msg, HttpStatus.UNPROCESSABLE_ENTITY);
        }
        return role;
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public void save(Role role) {
        if (!roleRepository.existsByCode(role.getCode())) {
            roleRepository.save(role);
        } else {
            final String msg = String.format("%s [%s] is already exist", Role.class.getName(),  role.getCode());
            throw new CustomException(msg, HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}
