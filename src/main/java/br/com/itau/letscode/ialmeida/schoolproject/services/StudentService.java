package br.com.itau.letscode.ialmeida.schoolproject.services;

import br.com.itau.letscode.ialmeida.schoolproject.dtos.request.StudentRequest;
import br.com.itau.letscode.ialmeida.schoolproject.dtos.response.StudentResponse;
import br.com.itau.letscode.ialmeida.schoolproject.entities.Student;
import br.com.itau.letscode.ialmeida.schoolproject.exceptions.StudentNotFoundException;
import br.com.itau.letscode.ialmeida.schoolproject.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<StudentResponse> findAll() {
        List<Student> students = studentRepository.findAll();
        List<StudentResponse> studentResponses = new ArrayList<>();

        for (Student student : students) {
            studentResponses.add(student.toResponse());
        }

        return studentResponses;
    }

    public StudentResponse findById(UUID id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with id = " + id + " not found."));
        return student.toResponse();
    }

    private Student findByCpf(Long cpf) {
        return studentRepository.findByCpf(cpf)
                .orElseThrow(() -> new StudentNotFoundException("Student with cpf = " + cpf + " not found."));
    }

    public StudentResponse insert(StudentRequest studentRequest) {
        return studentRepository.save(new Student(studentRequest)).toResponse();
    }

    public StudentResponse update(StudentRequest studentRequest) {
        Student student = this.findByCpf(studentRequest.getCpf());
        this.updateData(student, studentRequest);
        return studentRepository.save(student).toResponse();
    }

    private void updateData(Student student, StudentRequest studentRequest) {
        if (studentRequest.getName() != null) {
            student.setName(studentRequest.getName());
        }

        if (studentRequest.getAge() != null) {
            student.setAge(studentRequest.getAge());
        }

        if (studentRequest.getCpf() != null) {
            student.setCpf(studentRequest.getCpf());
        }

        if (studentRequest.getActivated() != null) {
            student.setActivated(studentRequest.getActivated());
        }

        if (studentRequest.getAddress() != null) {
            student.setAddress(studentRequest.getAddress());
        }

        if (studentRequest.getGrades() != null) {
            student.setGrades(studentRequest.getGrades());
        }

        if (studentRequest.getCourses() != null) {
            student.setCourses(studentRequest.getCourses());
        }
    }

    public void deleteById(UUID id) {
        studentRepository.deleteById(id);
    }

}
