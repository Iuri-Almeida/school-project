package br.com.itau.letscode.ialmeida.schoolproject.services;

import br.com.itau.letscode.ialmeida.schoolproject.dtos.request.TeacherRequest;
import br.com.itau.letscode.ialmeida.schoolproject.dtos.response.TeacherResponse;
import br.com.itau.letscode.ialmeida.schoolproject.entities.Teacher;
import br.com.itau.letscode.ialmeida.schoolproject.exceptions.ResourceNotFoundException;
import br.com.itau.letscode.ialmeida.schoolproject.repositories.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public List<TeacherResponse> findAll() {
        List<Teacher> teachers = teacherRepository.findAll();
        List<TeacherResponse> teacherResponses = new ArrayList<>();

        for (Teacher teacher : teachers) {
            teacherResponses.add(teacher.toResponse());
        }

        return teacherResponses;
    }

    public Teacher findById(UUID id) {
        return teacherRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Teacher with id = " + id + " not found."));
    }

    public Teacher findByCpf(Long cpf) {
        return teacherRepository.findByCpf(cpf).orElseThrow(() -> new ResourceNotFoundException("Teacher with cpf = " + cpf + " not found."));
    }

    public TeacherResponse insert(TeacherRequest teacherRequest) {
        return teacherRepository.save(new Teacher(teacherRequest)).toResponse();
    }

    public TeacherResponse update(TeacherRequest teacherRequest) {
        Teacher teacher = this.findByCpf(teacherRequest.getCpf());
        this.updateData(teacher, teacherRequest);
        return teacherRepository.save(teacher).toResponse();
    }

    private void updateData(Teacher teacher, TeacherRequest teacherRequest) {
        if (teacherRequest.getName() != null) {
            teacher.setName(teacherRequest.getName());
        }

        if (teacherRequest.getCpf() != null) {
            teacher.setCpf(teacherRequest.getCpf());
        }
    }

    public void deleteById(UUID id) {
        teacherRepository.deleteById(id);
    }

    public void deleteByCpf(Long cpf) {
        Teacher teacher = this.findByCpf(cpf);
        this.deleteById(teacher.getId());
    }

}
