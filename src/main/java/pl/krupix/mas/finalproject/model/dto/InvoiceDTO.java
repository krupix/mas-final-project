package pl.krupix.mas.finalproject.model.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by krupix on 17.06.2016.
 */
public class InvoiceDTO implements Serializable {

    private static int UNIQ_ID = 0;

    private int id;
    private float netPrice;
    private Date createDate;
    private String title;

    private PartsOrderDTO partsOrder;

    public InvoiceDTO() {
        UNIQ_ID++;
        this.id = UNIQ_ID;
    }

    public InvoiceDTO(String title, float netPrice) {
        UNIQ_ID++;
        this.id = UNIQ_ID;
        this.title = title;
        this.netPrice = netPrice;
        createDate = new Date();
    }

    public PartsOrderDTO getPartsOrder() {
        return partsOrder;
    }

    public void setPartsOrder(PartsOrderDTO partsOrder) {
        this.partsOrder = partsOrder;
    }

    public float getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(float netPrice) {
        this.netPrice = netPrice;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String toString() {
        return "got: id = " + id + ", title = " + title;
    }
}
