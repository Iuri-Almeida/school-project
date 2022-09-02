package br.com.itau.letscode.ialmeida.schoolproject.repositories;

import br.com.itau.letscode.ialmeida.schoolproject.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {
}
