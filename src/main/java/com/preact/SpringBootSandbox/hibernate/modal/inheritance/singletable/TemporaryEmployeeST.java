package com.preact.SpringBootSandbox.hibernate.modal.inheritance.singletable;

import javax.persistence.Entity;

@Entity
public class TemporaryEmployeeST extends EmployeeST{

    String hourlyWage;

    public String getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(String hourlyWage) {
        this.hourlyWage = hourlyWage;
    }
}
