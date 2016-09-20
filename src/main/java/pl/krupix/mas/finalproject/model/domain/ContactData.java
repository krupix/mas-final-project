package pl.krupix.mas.finalproject.model.domain;

import pl.krupix.mas.finalproject.model.dto.ContactDataDTO;

import javax.persistence.*;

/**
 * Created by krupix on 17.06.2016.
 */
@Entity
@Table(name = "CONTACT_DATA")
public class ContactData {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    public ContactDataDTO getDTO() {
        return new ContactDataDTO(email, phoneNumber, phoneNumber);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
