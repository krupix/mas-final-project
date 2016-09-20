package pl.krupix.mas.finalproject.model.domain;

import pl.krupix.mas.finalproject.model.dto.AdressDataDTO;

import javax.persistence.*;

/**
 * Created by krupix on 17.06.2016.
 */
@Entity
@Table(name = "ADRESS_DATA")
public class AdressData {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "POST_CODE")
    private String postCode;

    @Column(name = "CITY")
    private String city;

    @Column(name = "HOUSE_NUMVDER")
    private Integer houseNumber;

    @Column(name = "LOCALE_NUMBER")
    private Integer localeNumber;

    @Column(name = "STREET")
    private String street;

    public AdressDataDTO getDTO() {
        return new AdressDataDTO(postCode, city, houseNumber, localeNumber, street);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public Integer getLocaleNumber() {
        return localeNumber;
    }

    public void setLocaleNumber(Integer localeNumber) {
        this.localeNumber = localeNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
