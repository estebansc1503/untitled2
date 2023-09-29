package com.sbszc.employeemanager.presenter;

import com.sbszc.employeemanager.presenter.dto.EmployeeDto;

public interface IEmployeePresenter {
    boolean save(EmployeeDto employeeDto);

    EmployeeDto findById(long id);

    boolean deleteById(long id);


}
