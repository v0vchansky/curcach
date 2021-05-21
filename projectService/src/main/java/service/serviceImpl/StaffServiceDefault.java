package service.serviceImpl;

import lombok.RequiredArgsConstructor;
import model.Staff;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import repository.StaffRepository;
import security.exceptions.CustomException;
import service.StaffService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StaffServiceDefault implements StaffService {

    private final StaffRepository staffRepository;

    @Override
    public boolean existsById(String id) {
        return staffRepository.existsById(id);
    }

    @Override
    public Staff findById(String id) {
        final Staff staff = staffRepository.findById(id).get();
        if (staff == null) {
            final String msg = String.format("%s [%s] was not found", Staff.class.getName(),  id);
            throw new CustomException(msg, HttpStatus.UNPROCESSABLE_ENTITY);
        }
        return staff;
    }

    @Override
    public List<Staff> findAll() {
        return staffRepository.findAll();
    }

    @Override
    public void deleteById(String id) {
        if (!staffRepository.existsById(id)) {
            final String msg = String.format("%s [%s] was not found", Staff.class.getName(),  id);
            throw new CustomException(msg, HttpStatus.UNPROCESSABLE_ENTITY);
        }
        staffRepository.deleteById(id);
    }

    @Override
    public void save(Staff staff) {
        staffRepository.save(staff);
    }
}
