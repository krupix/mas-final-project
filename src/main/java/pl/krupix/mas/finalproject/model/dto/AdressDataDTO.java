package pl.krupix.mas.finalproject.model.dto;

/**
 * Created by krupix on 17.06.2016.
 */
public class AdressDataDTO {

    private String postCode;

    private String city;

    private int houseNumber;

    private int flatNumber;

    private String street;

    public AdressDataDTO() {}

    public AdressDataDTO(String postCode, String city, int houseNumber, int flatNumber, String street) {
        this.postCode = postCode;
        this.city = city;
        this.houseNumber = houseNumber;
        this.flatNumber = flatNumber;
        this.street = street;
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

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public int getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(int flatNumber) {
        this.flatNumber = flatNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
