package Energeenot.TestTaskSDS.services;

import Energeenot.TestTaskSDS.models.Student;
import Energeenot.TestTaskSDS.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student editStudent(String id, Student updatedStudent) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));

        System.out.println("Updated Student: " + updatedStudent);
        Optional.ofNullable(updatedStudent.getSurname()).ifPresent(student::setSurname);
        Optional.ofNullable(updatedStudent.getName()).ifPresent(student::setName);
        Optional.ofNullable(updatedStudent.getPatronymic()).ifPresent(student::setPatronymic);
        Optional.ofNullable(updatedStudent.getGroup()).ifPresent(student::setGroup);
        Optional.ofNullable(updatedStudent.getAverageMark()).ifPresent(student::setAverageMark);
        return studentRepository.save(student);
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(String id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));
        studentRepository.delete(student);
    }
}
