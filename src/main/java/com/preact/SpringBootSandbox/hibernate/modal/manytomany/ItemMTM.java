package com.preact.SpringBootSandbox.hibernate.modal.manytomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="ITEM_MTM")
public class ItemMTM {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String itemName;

    @ManyToMany
    @JoinTable( // customising the join table
            name = "basket_item_join_table",
            joinColumns = @JoinColumn(name = "basket_mtm_id"),
            inverseJoinColumns = @JoinColumn(name="item_mtm_id")
    )
    List<ItemBasketMTM> baskets = new ArrayList<>();

    public ItemMTM() {
    }

    public ItemMTM(String itemName) {
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

    public List<ItemBasketMTM> getBaskets() {
        return baskets;
    }

    public void setBaskets(List<ItemBasketMTM> baskets) {
        this.baskets = baskets;
    }

    @Override
    public String toString() {
        return "ItemMTM{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                '}';
    }
}
