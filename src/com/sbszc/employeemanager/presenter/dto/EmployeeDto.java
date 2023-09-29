package com.sbszc.employeemanager.presenter.dto;

import com.sbszc.employeemanager.model.Accountant;
import com.sbszc.employeemanager.model.Courier;
import com.sbszc.employeemanager.model.Employee;

public abstract class EmployeeDto {
    private long id;
    private String name;
    private int salary;

    public EmployeeDto(long id, String name, int salary) {
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

    public static class Mapper{
        public EmployeeDto map(Employee employee) {
            if (employee instanceof Accountant accountant) {
                return new AccountantDto(
                        accountant.getId(),
                        accountant.getName(),
                        accountant.getSalary(),
                        accountant.getCommission()
                );
            }
            return new CourierDto(
                    employee.getId(),
                    employee.getName(),
                    employee.getSalary()
            );
        }

        public Employee map(EmployeeDto employeeDto) {
            if (employeeDto instanceof AccountantDto accountantDto) {
                return new Accountant(
                        accountantDto.getId(),
                        accountantDto.getName(),
                        accountantDto.getSalary(),
                        accountantDto.getCommission()
                );
            }
            return new Courier(
                    employeeDto.getId(),
                    employeeDto.getName(),
                    employeeDto.getSalary()
            );
        }
    }
}
