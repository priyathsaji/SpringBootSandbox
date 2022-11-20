package com.preact.SpringBootSandbox.hibernate.modal.bidirectional;


import javax.persistence.*;

@Entity
@Table(name="HIBER_ITEM_DESCRIPTION_BI")
public class HiberItemDescriptionBi {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String description;

    @OneToOne(
            fetch = FetchType.LAZY,
            mappedBy = "hiberItemDescriptionBi" // if mapped by is not present it will add a column for the id of HiberItem id
                                                // which is duplication of the data (not recommended )
                                                // this is added in the mapped element not the owner of the relationship
    )
    HiberItemBi hiberItemBi;

    public HiberItemDescriptionBi() {
    }

    public HiberItemDescriptionBi(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "HiberItemDescription{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }


    public HiberItemBi getHiberItemBi() {
        return hiberItemBi;
    }

    public void setHiberItemBi(HiberItemBi hiberItemBi) {
        this.hiberItemBi = hiberItemBi;
    }
}
