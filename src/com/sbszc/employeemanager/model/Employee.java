package com.sbszc.employeemanager.model;

public abstract class Employee {
    private long id;
    private String name;
    private int salary;

    public Employee(long id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    abstract int getWage();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
