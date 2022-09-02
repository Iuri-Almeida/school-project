package br.com.itau.letscode.ialmeida.schoolproject.exceptions.handler;

import br.com.itau.letscode.ialmeida.schoolproject.exceptions.StandardError;
import br.com.itau.letscode.ialmeida.schoolproject.exceptions.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class SchoolExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(StudentNotFoundException e, HttpServletRequest request) {
        String error = "Student not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

}
