package repositories;

import domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findAllByName(String name);

    List<Student> findAllByPhoneNo(String phoneNo);

    @Query("SELECT s from Student s where s.address.city= :city" )
    List<Student> findAllStudentsWithAddressCity(String city);
}
