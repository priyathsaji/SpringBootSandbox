package com.preact.SpringBootSandbox.hibernate.modal.onetoone.bidirectional;


import javax.persistence.*;

@Entity
@Table(name = "HIBER_ITEM_BI")
public class HiberItemBi {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String name;



    //creates a mapping column in this table
    @OneToOne(
            fetch = FetchType.LAZY // the description is not fetched unless it is required
    )
    HiberItemDescriptionBi hiberItemDescriptionBi;

    public HiberItemBi() {
    }

    public HiberItemBi(String name) {
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


    public HiberItemDescriptionBi getHiberItemDescriptionBi() {
        return hiberItemDescriptionBi;
    }

    public void setHiberItemDescriptionBi(HiberItemDescriptionBi hiberItemDescriptionBi) {
        this.hiberItemDescriptionBi = hiberItemDescriptionBi;
    }

    @Override
    public String toString() {
        return "HiberItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
