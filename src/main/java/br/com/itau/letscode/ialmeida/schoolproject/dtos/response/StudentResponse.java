package br.com.itau.letscode.ialmeida.schoolproject.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse {

    private UUID id;
    private String name;
    private Integer age;
    private Long cpf;

}
