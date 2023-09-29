package com.sbszc.employeemanager.model;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {
    List<Employee> employees;

    public EmployeeManager() {
        employees = new ArrayList<>();
    }

    public Employee findById(long id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public boolean save(Employee employee) {
        if (!employeeExists(employee)) {
            employees.add(employee);
            return true;
        }
        return false;
    }

    public boolean deleteById(long id) {
        for (Employee auxEmployee : employees) {
            if (auxEmployee.getId() == id) {
                employees.remove(auxEmployee);
                return true;
            }
        }
        return false;
    }

    private boolean employeeExists(Employee employee) {
        for (Employee auxEmployee : employees) {
            if (auxEmployee.getId() == employee.getId()) {
                return true;
            }
        }
        return false;
    }
}
