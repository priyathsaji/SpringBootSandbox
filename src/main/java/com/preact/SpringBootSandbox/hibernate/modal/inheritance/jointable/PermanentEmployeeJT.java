package com.preact.SpringBootSandbox.hibernate.modal.inheritance.jointable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="PERMANENT_EMPLOYEE_JT")
public class PermanentEmployeeJT extends EmployeeJT {

    String wage;

    public String getWage() {
        return wage;
    }

    public void setWage(String wage) {
        this.wage = wage;
    }
}
