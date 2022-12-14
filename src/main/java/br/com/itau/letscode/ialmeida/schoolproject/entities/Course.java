package br.com.itau.letscode.ialmeida.schoolproject.entities;

import br.com.itau.letscode.ialmeida.schoolproject.dtos.request.CourseRequest;
import br.com.itau.letscode.ialmeida.schoolproject.dtos.response.CourseResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "tb_course")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Audited
@AuditTable(value = "course_aud")
public class Course {

    @Id
    @GeneratedValue
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;

    @Column(nullable = false)
    private String name;
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @ManyToOne(cascade = CascadeType.ALL)
    private Teacher teacher;

    public Course(CourseRequest courseRequest) {
        this.name = courseRequest.getName();
        this.teacher = courseRequest.getTeacher();
    }

    public CourseResponse toResponse() {
        return new CourseResponse(this.name);
    }

}
