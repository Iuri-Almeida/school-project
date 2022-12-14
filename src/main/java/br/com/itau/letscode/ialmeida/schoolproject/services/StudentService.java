package br.com.itau.letscode.ialmeida.schoolproject.services;

import br.com.itau.letscode.ialmeida.schoolproject.dtos.request.StudentRequest;
import br.com.itau.letscode.ialmeida.schoolproject.dtos.response.StudentResponse;
import br.com.itau.letscode.ialmeida.schoolproject.entities.Address;
import br.com.itau.letscode.ialmeida.schoolproject.entities.Student;
import br.com.itau.letscode.ialmeida.schoolproject.exceptions.ResourceNotFoundException;
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

    public Student findById(UUID id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student with id = " + id + " not found."));
    }

    private Student findByCpf(Long cpf) {
        return studentRepository.findByCpf(cpf)
                .orElseThrow(() -> new ResourceNotFoundException("Student with cpf = " + cpf + " not found."));
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

        if (studentRequest.getAddress() != null) {
            student.setAddress(new Address(studentRequest.getAddress()));
        }

    }

    public void activate(UUID id) {
        Student student = this.findById(id);
        student.setActivated(true);
    }

    public void deleteById(UUID id) {
        studentRepository.deleteById(id);
    }

    public void deleteByCpf(Long cpf) {
        Student student = this.findByCpf(cpf);
        studentRepository.deleteById(student.getId());
    }

}
