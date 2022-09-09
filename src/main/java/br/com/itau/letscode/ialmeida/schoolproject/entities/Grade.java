package br.com.itau.letscode.ialmeida.schoolproject.entities;

import br.com.itau.letscode.ialmeida.schoolproject.dtos.request.GradeRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "tb_grade")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Audited
@AuditTable(value = "grade_aud")
public class Grade {

    @Id
    @GeneratedValue
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;
    private String content;
    private Double grade;

    public Grade(GradeRequest gradeRequest) {
        this.content = gradeRequest.getContent();
        this.grade = gradeRequest.getGrade();
    }

}
