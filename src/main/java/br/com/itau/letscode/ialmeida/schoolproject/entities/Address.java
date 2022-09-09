package br.com.itau.letscode.ialmeida.schoolproject.entities;

import br.com.itau.letscode.ialmeida.schoolproject.dtos.request.AddressRequest;
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
@Table(name = "tb_address")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Audited
@AuditTable(value = "address_aud")
public class Address {

    @Id
    @GeneratedValue
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;
    private String street;
    private Long number;
    private String cep;
    private String complement;
    private String city;
    private String state;

    public Address(AddressRequest addressRequest) {
        this.street = addressRequest.getStreet();
        this.number = addressRequest.getNumber();
        this.cep = addressRequest.getCep();
        this.complement = addressRequest.getComplement();
        this.city = addressRequest.getCity();
        this.state = addressRequest.getState();
    }

}
