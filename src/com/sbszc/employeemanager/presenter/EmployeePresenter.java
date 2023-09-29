package com.sbszc.employeemanager.presenter;

import com.sbszc.employeemanager.model.Employee;
import com.sbszc.employeemanager.model.EmployeeManager;
import com.sbszc.employeemanager.presenter.dto.EmployeeDto;

public class EmployeePresenter implements IEmployeePresenter {

    EmployeeManager employeeManager;
    EmployeeDto.Mapper mapper;

    public EmployeePresenter(EmployeeManager employeeManager, EmployeeDto.Mapper mapper) {
        this.employeeManager = employeeManager;
        this.mapper = mapper;
    }

    @Override
    public boolean save(EmployeeDto employeeDto) {
        Employee employee = mapper.map(employeeDto);
        return employeeManager.save(employee);
    }

    @Override
    public EmployeeDto findById(long id) {
        Employee employee = employeeManager.findById(id);
        return mapper.map(employee);
    }

    @Override
    public boolean deleteById(long id) {
        return employeeManager.deleteById(id);
    }
}
