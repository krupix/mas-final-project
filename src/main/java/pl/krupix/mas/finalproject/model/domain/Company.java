package pl.krupix.mas.finalproject.model.domain;

import javax.persistence.*;

/**
 * Created by krupix on 17.06.2016.
 */
@MappedSuperclass
public abstract class Company {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ADRESS_DATA")
    protected AdressData adressData;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="CONTACT_DATA")
    protected ContactData contactData;

    @Column(name = "NIP")
    protected String NIP;

    public AdressData getAdressData() {
        return adressData;
    }

    public void setAdressData(AdressData adressData) {
        this.adressData = adressData;
    }

    public ContactData getContactData() {
        return contactData;
    }

    public void setContactData(ContactData contactData) {
        this.contactData = contactData;
    }

    public String getNIP() {
        return NIP;
    }

    public void setNIP(String NIP) {
        this.NIP = NIP;
    }
}
