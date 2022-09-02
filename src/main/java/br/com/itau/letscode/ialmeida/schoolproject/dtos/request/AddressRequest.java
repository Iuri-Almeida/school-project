package br.com.itau.letscode.ialmeida.schoolproject.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequest {

    private String street;
    private Long number;
    private String cep;
    private String complement;
    private String city;
    private String state;

}
