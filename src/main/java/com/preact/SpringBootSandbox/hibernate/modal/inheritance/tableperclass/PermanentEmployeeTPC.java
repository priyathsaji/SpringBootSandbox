package com.preact.SpringBootSandbox.hibernate.modal.inheritance.tableperclass;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table( name = "PERMANENT_EMPLOYEE_TPC")
public class PermanentEmployeeTPC extends EmployeeTPC {

    String wage;

    public String getWage() {
        return wage;
    }

    public void setWage(String wage) {
        this.wage = wage;
    }
}
