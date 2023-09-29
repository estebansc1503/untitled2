package com.sbszc.employeemanager.presenter.dto;

public class AccountantDto extends EmployeeDto {

    private int commission;

    public AccountantDto(long id, String name, int salary, int commission) {
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
