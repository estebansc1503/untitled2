package com.sbszc.employeemanager.model;

public class Accountant extends Employee {

    private int commission;

    public Accountant(long id, String name, int salary, int commission) {
        super(id, name, salary);
        this.commission = commission;
    }

    @Override
    int getWage() {
        return getSalary() + commission;
    }

    public int getCommission() {
        return commission;
    }

    public void setCommission(int commission) {
        this.commission = commission;
    }
}
