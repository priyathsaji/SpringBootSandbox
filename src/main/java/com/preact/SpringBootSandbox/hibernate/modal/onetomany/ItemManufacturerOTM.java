package com.preact.SpringBootSandbox.hibernate.modal.onetomany;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="ITEM_MANUFACTURER_OTM")
public class ItemManufacturerOTM {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String manufacturerName;

    @OneToMany(
            mappedBy = "itemManufacturer" // if not there will create a join table, if there will create a id column in the other table
    )
    List<ItemOTM> items;

    public ItemManufacturerOTM() {
    }

    public ItemManufacturerOTM(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public List<ItemOTM> getItems() {
        return items;
    }

    public void setItems(List<ItemOTM> items) {
        this.items = items;
    }
}
