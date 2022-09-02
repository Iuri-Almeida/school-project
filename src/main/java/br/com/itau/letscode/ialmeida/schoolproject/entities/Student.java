package br.com.itau.letscode.ialmeida.schoolproject.entities;

import br.com.itau.letscode.ialmeida.schoolproject.dtos.request.StudentRequest;
import br.com.itau.letscode.ialmeida.schoolproject.dtos.response.CourseResponse;
import br.com.itau.letscode.ialmeida.schoolproject.dtos.response.StudentResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_student")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;

    private String name;
    private Integer age;

    @Column(unique = true)
    private Long cpf;

    private Boolean activated;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Grade> grades;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Course> courses;

    public Student(StudentRequest studentRequest) {
        this.name = studentRequest.getName();
        this.age = studentRequest.getAge();
        this.cpf = studentRequest.getCpf();
        this.activated = true;
        this.address = studentRequest.getAddress();
        this.grades = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public StudentResponse toResponse() {
        return new StudentResponse(this.id, this.name, this.age, this.cpf);
    }

}
