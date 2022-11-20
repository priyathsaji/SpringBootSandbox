package com.preact.SpringBootSandbox.hibernate.modal.inheritance.jointable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="TEMPORARY_EMPLOYEE_JT")
public class TemporaryEmployeeJT extends EmployeeJT {

    String hourlyWage;

    public String getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(String hourlyWage) {
        this.hourlyWage = hourlyWage;
    }
}
