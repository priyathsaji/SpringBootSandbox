package com.preact.SpringBootSandbox.hibernate.modal.inheritance.singletable;


import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table( name = "EMPLOYEES_ST")
public class EmployeeST {

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
