package com.preact.SpringBootSandbox.hibernate.modal.inheritance.mappedsupperclass;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table( name = "PERMANENT_EMPLOYEE_MSC")
public class PermanentEmployeeMSC extends EmployeeMSC {

    String wage;

    public String getWage() {
        return wage;
    }

    public void setWage(String wage) {
        this.wage = wage;
    }
}
