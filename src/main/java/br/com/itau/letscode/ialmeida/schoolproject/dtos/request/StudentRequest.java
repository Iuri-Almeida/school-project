package br.com.itau.letscode.ialmeida.schoolproject.dtos.request;

import br.com.itau.letscode.ialmeida.schoolproject.entities.Address;
import br.com.itau.letscode.ialmeida.schoolproject.entities.Course;
import br.com.itau.letscode.ialmeida.schoolproject.entities.Grade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequest {

    private String name;
    private Integer age;
    private Long cpf;
    private Boolean activated;
    private Address address;
    private List<Grade> grades;
    private List<Course> courses;

}
