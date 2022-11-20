package com.preact.SpringBootSandbox.hibernate.modal.inheritance.singletable;

import javax.persistence.Entity;

@Entity
public class PermanentEmployeeST extends EmployeeST {

    String wage;

    public String getWage() {
        return wage;
    }

    public void setWage(String wage) {
        this.wage = wage;
    }
}
