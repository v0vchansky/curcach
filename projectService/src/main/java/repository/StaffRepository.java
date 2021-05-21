package repository;

import model.Staff;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StaffRepository extends CrudRepository<Staff, String> {

    boolean existsById(String id);

    List<Staff> findAll();

    @Transactional
    void deleteById(String id);
}
