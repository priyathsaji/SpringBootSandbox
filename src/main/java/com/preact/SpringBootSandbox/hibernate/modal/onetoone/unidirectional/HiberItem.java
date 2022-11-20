package com.preact.SpringBootSandbox.hibernate.modal.onetoone.unidirectional;


import javax.persistence.*;

@Entity
@Table(name = "HIBER_ITEM")
public class HiberItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String name;



    //creates a mapping column in this table
    @OneToOne(
            fetch = FetchType.LAZY // the description is not fetched unless it is required
    )
    HiberItemDescription hiberItemDescription;

    public HiberItem() {
    }

    public HiberItem(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public HiberItemDescription getHiberItemDescription() {
        return hiberItemDescription;
    }

    public void setHiberItemDescription(HiberItemDescription hiberItemDescription) {
        this.hiberItemDescription = hiberItemDescription;
    }

    @Override
    public String toString() {
        return "HiberItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
