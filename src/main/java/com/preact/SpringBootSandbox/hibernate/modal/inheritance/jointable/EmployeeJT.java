package com.preact.SpringBootSandbox.hibernate.modal.inheritance.jointable;


import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table( name = "EMPLOYEES_JT")
public class EmployeeJT {

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
