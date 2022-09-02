package br.com.itau.letscode.ialmeida.schoolproject.dtos.request;

import br.com.itau.letscode.ialmeida.schoolproject.entities.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseRequest {

    private String name;
    private Teacher teacher;

}
