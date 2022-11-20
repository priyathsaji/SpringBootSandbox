package com.preact.SpringBootSandbox.hibernate.modal.inheritance.tableperclass;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="TEMPORARY_EMPLOYEE_TPC")
public class TemporaryEmployeeTPC extends EmployeeTPC {

    String hourlyWage;

    public String getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(String hourlyWage) {
        this.hourlyWage = hourlyWage;
    }
}
