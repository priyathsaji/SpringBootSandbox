package com.preact.SpringBootSandbox.hibernate.modal.inheritance.tableperclass;


import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class EmployeeTPC {

    @Id
    @GeneratedValue
    Long id;

    String name;


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
}
