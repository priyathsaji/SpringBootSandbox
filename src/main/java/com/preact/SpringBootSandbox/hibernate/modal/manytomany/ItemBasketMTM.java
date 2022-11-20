package com.preact.SpringBootSandbox.hibernate.modal.manytomany;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="ITEM_BASKET_MTM")
public class ItemBasketMTM {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String basketName;


    @ManyToMany(
            mappedBy = "baskets" // if not specified will create a mapping table for both the entities (not recommended)
                                // does not matter where we specify the mapped by since join table is created in both cases

    )
    List<ItemMTM> items = new ArrayList<>();

    public ItemBasketMTM() {
    }

    public ItemBasketMTM(String basketName) {
        this.basketName = basketName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBasketName() {
        return basketName;
    }

    public void setBasketName(String basketName) {
        this.basketName = basketName;
    }

    public List<ItemMTM> getItems() {
        return items;
    }

    public void setItems(List<ItemMTM> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "ItemBasketMTM{" +
                "id=" + id +
                ", basketName='" + basketName + '\'' +
                '}';
    }
}

