package customers.repository;

import customers.domain.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, Long> {

    List<Student> findAllByName(String name);

    Student findStudentByPhoneNo(String phoneNo);

    List<Student> findAllByAddress_City(String city);
}
