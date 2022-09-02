package br.com.itau.letscode.ialmeida.schoolproject.dtos.request;

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
    private AddressRequest address;

}
