package Energeenot.TestTaskSDS.controllers;

import Energeenot.TestTaskSDS.models.Student;
import Energeenot.TestTaskSDS.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Student editStudent(@PathVariable String id, @RequestBody Student updatedStudent) {
        return studentService.editStudent(id, updatedStudent);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/add")
    public Student addStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable String id) {
        studentService.deleteStudent(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(HttpStatus.NO_CONTENT);
    }
}
