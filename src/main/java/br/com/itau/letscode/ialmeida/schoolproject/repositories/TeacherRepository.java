package br.com.itau.letscode.ialmeida.schoolproject.repositories;

import br.com.itau.letscode.ialmeida.schoolproject.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, UUID> {
}
