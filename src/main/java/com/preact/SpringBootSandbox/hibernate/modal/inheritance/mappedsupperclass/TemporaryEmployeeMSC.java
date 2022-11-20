package com.preact.SpringBootSandbox.hibernate.modal.inheritance.mappedsupperclass;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="TEMPORARY_EMPLOYEE_MSC")
public class TemporaryEmployeeMSC extends EmployeeMSC {

    String hourlyWage;

    public String getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(String hourlyWage) {
        this.hourlyWage = hourlyWage;
    }
}
