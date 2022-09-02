package br.com.itau.letscode.ialmeida.schoolproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SchoolProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchoolProjectApplication.class, args);
    }

}
