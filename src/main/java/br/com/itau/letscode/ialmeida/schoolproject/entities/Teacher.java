package br.com.itau.letscode.ialmeida.schoolproject.entities;

import br.com.itau.letscode.ialmeida.schoolproject.dtos.request.TeacherRequest;
import br.com.itau.letscode.ialmeida.schoolproject.dtos.response.TeacherResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "tb_teacher")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private Long cpf;

    public Teacher(TeacherRequest teacherRequest) {
        this.name = teacherRequest.getName();
        this.cpf = teacherRequest.getCpf();
    }

    public TeacherResponse toResponse() {
        return new TeacherResponse(this.id, this.name, this.cpf);
    }

}
