package pl.krupix.mas.finalproject.model.dto;

import pl.krupix.mas.finalproject.model.domain.AdressData;
import pl.krupix.mas.finalproject.model.domain.ContactData;

/**
 * Created by krupix on 17.06.2016.
 */
public class CompanyDTO {

    private AdressDataDTO adressData;

    private ContactDataDTO contactData;

    private String name;

    private String NIP;

    public CompanyDTO(AdressDataDTO adressData, ContactDataDTO contactData, String name, String NIP) {
        this.adressData = adressData;
        this.contactData = contactData;
        this.name = name;
        this.NIP = NIP;
    }

    public AdressDataDTO getAdressData() {
        return adressData;
    }

    public void setAdressData(AdressDataDTO adressData) {
        this.adressData = adressData;
    }

    public ContactDataDTO getContactData() {
        return contactData;
    }

    public void setContactData(ContactDataDTO contactData) {
        this.contactData = contactData;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNIP() {
        return NIP;
    }

    public void setNIP(String NIP) {
        this.NIP = NIP;
    }
}
