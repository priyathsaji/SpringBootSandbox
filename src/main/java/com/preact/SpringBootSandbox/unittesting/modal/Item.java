package com.preact.SpringBootSandbox.unittesting.modal;


import javax.persistence.*;

@Entity
@Table(name = "UnitTestItem")
public class Item {

    String name;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    int price;

    public Item() {
    }

    public Item(String name, Long id, int price) {
        this.name = name;
        this.id = id;
        this.price = price;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", price=" + price +
                '}';
    }
}
