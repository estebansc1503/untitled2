package com.sbszc.employeemanager;

import com.sbszc.employeemanager.model.EmployeeManager;
import com.sbszc.employeemanager.presenter.EmployeePresenter;
import com.sbszc.employeemanager.presenter.dto.EmployeeDto;
import com.sbszc.employeemanager.view.EmployeeFrame;

public class Main {
    public static void main(String[] args) {
        EmployeeFrame employeeFrame = new EmployeeFrame(new EmployeePresenter(new EmployeeManager(), new EmployeeDto.Mapper()));
//        MiPantalla miPantalla = new MiPantalla();
    }
}
