package br.com.itau.letscode.ialmeida.schoolproject.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GradeRequest {

    private String content;
    private Double grade;

}
