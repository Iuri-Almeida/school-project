package br.com.itau.letscode.ialmeida.schoolproject.controllers;

import br.com.itau.letscode.ialmeida.schoolproject.dtos.request.TeacherRequest;
import br.com.itau.letscode.ialmeida.schoolproject.dtos.response.TeacherResponse;
import br.com.itau.letscode.ialmeida.schoolproject.services.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/teacher")
@AllArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping
    public ResponseEntity<List<TeacherResponse>> findAll() {
        return ResponseEntity.ok().body(teacherService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TeacherResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(teacherService.findById(id).toResponse());
    }

    @PostMapping
    public ResponseEntity<TeacherResponse> insert(@RequestBody TeacherRequest teacherRequest) {
        return ResponseEntity.ok().body(teacherService.insert(teacherRequest));
    }

    @PutMapping
    public ResponseEntity<TeacherResponse> update(@RequestBody TeacherRequest teacherRequest) {
        return ResponseEntity.ok().body(teacherService.update(teacherRequest));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        teacherService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{cpf}")
    public ResponseEntity<Void> deleteByCpf(@PathVariable Long cpf) {
        teacherService.deleteByCpf(cpf);
        return ResponseEntity.noContent().build();
    }

}
