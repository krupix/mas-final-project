package pl.krupix.mas.finalproject.model.domain;

import org.hibernate.annotations.Cascade;
import pl.krupix.mas.finalproject.model.dto.AdressDataDTO;
import pl.krupix.mas.finalproject.model.dto.ContactDataDTO;
import pl.krupix.mas.finalproject.model.dto.WarehouseDTO;

import javax.persistence.*;

/**
 * Created by krupix on 17.06.2016.
 */
@Entity
@Table(name = "WAREHOUSES")
public class Warehouse extends Company {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DISCOUNT")
    private int discount;

    public WarehouseDTO getDTO() {
        AdressDataDTO adressDataDTO = adressData == null ? null : adressData.getDTO();
        ContactDataDTO contactDataDTO = contactData == null ? null : contactData.getDTO();
        return new WarehouseDTO(adressDataDTO, contactDataDTO, name, NIP, discount);
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
