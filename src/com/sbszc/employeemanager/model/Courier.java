package com.sbszc.employeemanager.model;

public class Courier extends Employee {

    public Courier(long id, String name, int salary) {
        super(id, name, salary);
    }

    @Override
    int getWage() {
        return getSalary();
    }
}
