package br.com.itau.letscode.ialmeida.schoolproject.dtos.request;

import br.com.itau.letscode.ialmeida.schoolproject.entities.Address;
import br.com.itau.letscode.ialmeida.schoolproject.entities.Course;
import br.com.itau.letscode.ialmeida.schoolproject.entities.Grade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequest {

    private String name;
    private Integer age;
    private Long cpf;
    private Address address;

}
