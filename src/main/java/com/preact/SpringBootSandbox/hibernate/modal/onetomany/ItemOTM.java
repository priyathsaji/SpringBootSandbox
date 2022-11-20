package com.preact.SpringBootSandbox.hibernate.modal.onetomany;


import javax.persistence.*;

@Entity
@Table(name="ITEM_OTM")
public class ItemOTM {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;


    String itemName;

    @ManyToOne
    ItemManufacturerOTM itemManufacturer;


    public ItemOTM() {
    }

    public ItemOTM(String itemName) {
        this.itemName = itemName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public ItemManufacturerOTM getItemManufacturer() {
        return itemManufacturer;
    }

    public void setItemManufacturer(ItemManufacturerOTM itemManufacturer) {
        this.itemManufacturer = itemManufacturer;
    }
}
