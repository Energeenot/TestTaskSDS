package Energeenot.TestTaskSDS.repositories;

import Energeenot.TestTaskSDS.models.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
}
