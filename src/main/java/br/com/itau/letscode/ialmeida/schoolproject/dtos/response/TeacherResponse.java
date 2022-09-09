package br.com.itau.letscode.ialmeida.schoolproject.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherResponse {

    private UUID id;
    private String name;
    private Long cpf;

}
