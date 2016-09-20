package pl.krupix.mas.finalproject.model.dto;

import pl.krupix.mas.finalproject.model.exception.NoSuchWarehouseException;
import pl.krupix.mas.finalproject.model.exception.PartAlreadyExistsException;

import java.util.List;

/**
 * Created by krupix on 17.06.2016.
 */
public class PartDTO {

    private WarehouseDTO warehouse;

    private String description;
    private float netPrice;
    private String manufacturer;
    private List<String> includedElements;

    private PartDTO(WarehouseDTO warehouse, String manufacturer) {
        this.manufacturer = manufacturer;
        this.warehouse = warehouse;
    }

    public static PartDTO createPart(WarehouseDTO warehouse, String manufacturer) throws NoSuchWarehouseException, PartAlreadyExistsException {
        if (warehouse == null) {
            throw new NoSuchWarehouseException("Warehouse not exist!") ;
        }

        PartDTO part = new PartDTO(warehouse, manufacturer);
        warehouse.addPart(part);

        return part;
    }

    public String[] toRow() {
        System.out.println("Return " + manufacturer + " " + description + " " + netPrice);
        String[] t = new String[3];
        t[0] = manufacturer;
        t[1] = netPrice+"";
        t[2] = description;
        return t;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(float netPrice) {
        this.netPrice = netPrice;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public List<String> getIncludedElements() {
        return includedElements;
    }

    public void setIncludedElements(List<String> includedElements) {
        this.includedElements = includedElements;
    }
}