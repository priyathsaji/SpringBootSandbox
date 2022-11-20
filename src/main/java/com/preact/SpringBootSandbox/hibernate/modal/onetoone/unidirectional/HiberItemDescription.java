package com.preact.SpringBootSandbox.hibernate.modal.onetoone.unidirectional;


import javax.persistence.*;

@Entity
@Table(name="HIBER_ITEM_DESCRIPTION")
public class HiberItemDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String description;

    public HiberItemDescription() {
    }

    public HiberItemDescription(String description) {
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
}
