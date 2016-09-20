package pl.krupix.mas.finalproject.model.dto;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import pl.krupix.mas.finalproject.model.exception.PartAlreadyExistsException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Vector;

/**
 * Created by krupix on 17.06.2016.
 */
public class WarehouseDTO extends CompanyDTO {

    private static Logger log = Logger.getLogger(WarehouseDTO.class);

    private static Vector<WarehouseDTO> extension = new Vector<WarehouseDTO>();
    private static HashSet<PartDTO> allParts = new HashSet<PartDTO>();

    private Vector<PartDTO> parts = new Vector<PartDTO>();

    private String name;
    private int discount;

    public WarehouseDTO(AdressDataDTO adressData, ContactDataDTO contactData, String companyName, String NIP, String name, int discount) {
        super(adressData, contactData, companyName, NIP);
        this.name = name;
        this.discount = discount;
        add(this);
        log.debug("created Warehouse => adressData = [" + adressData + "], contactData = [" + contactData + "], companyName = [" + companyName + "], NIP = [" + NIP + "], name = [" + name + "], discount = [" + discount + "]");
    }

    public WarehouseDTO(AdressDataDTO adressData, ContactDataDTO contactData, String companyName, String NIP, int discount) {
        super(adressData, contactData, companyName, NIP);
        this.discount = discount;
        add(this);
        log.debug("created Warehouse => adressData = [" + adressData + "], contactData = [" + contactData + "], companyName = [" + companyName + "], NIP = [" + NIP + "], discount = [" + discount + "]");
    }

    public void addPart(PartDTO part) throws PartAlreadyExistsException {
        log.info("part: " + part.toRow());
        if (!parts.contains(part)) {
            if (allParts.contains(part)) {
                throw new PartAlreadyExistsException("part " + part.getDescription() + " already exist in warehouses");
            }
            log.info("add part: " + part.getManufacturer());
            allParts.add(part);
            parts.add(part);
        }
    }

    private static void add(WarehouseDTO warehouse) {
        extension.add(warehouse);
    }

    public static void remove(WarehouseDTO warehouse) {
        extension.remove(warehouse);
    }

    public static void showAll() {
        log.info("show extentions: ");
        for (WarehouseDTO warehouse : extension) {
            log.debug("has extension of Warehouse " + extension);
        }
    }

    public static WarehouseDTO findByName(String name) {
        for (WarehouseDTO warehouse : extension) {
            if (warehouse.getName().equals(name)) {
                return warehouse;
            }
        }
        return null;
    }

    public void showAllParts() {
        for (PartDTO part : parts) {
            log.info("Warehouse has " + part.getDescription());
        }
    }

    public List<PartDTO> getAllParts() {
        log.info("Vector size:  " + parts.size());
       return new ArrayList<>(parts);
    }


    public String toString() {
        return "[ name = " + name + ", companyName = " + name + ", discount = " + discount  + " ]";
    }

}
