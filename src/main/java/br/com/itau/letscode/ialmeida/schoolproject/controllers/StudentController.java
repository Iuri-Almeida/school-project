package br.com.itau.letscode.ialmeida.schoolproject.controllers;

import br.com.itau.letscode.ialmeida.schoolproject.dtos.request.StudentRequest;
import br.com.itau.letscode.ialmeida.schoolproject.dtos.response.StudentResponse;
import br.com.itau.letscode.ialmeida.schoolproject.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/student")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentResponse>> findAll() {
        return ResponseEntity.ok().body(studentService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<StudentResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(studentService.findById(id).toResponse());
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody StudentRequest studentRequest) {
        StudentResponse studentResponse = studentService.insert(studentRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(studentResponse.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public ResponseEntity<StudentResponse> update(@RequestBody StudentRequest studentRequest) {
        return ResponseEntity.ok().body(studentService.update(studentRequest));
    }

    @PatchMapping(value = "/{id}/activate")
    public ResponseEntity<Void> activate(@PathVariable UUID id) {
        studentService.activate(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        studentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/cpf/{cpf}")
    public ResponseEntity<Void> delete(@PathVariable Long cpf) {
        studentService.deleteByCpf(cpf);
        return ResponseEntity.noContent().build();
    }

}
