package com.sbszc.employeemanager.presenter.dto;

import com.sbszc.employeemanager.model.Courier;

public class CourierDto extends EmployeeDto {

    public CourierDto(long id, String name, int salary) {
        super(id, name, salary);
    }

    @Override
    int getWage() {
        return getSalary();
    }

    static class Mapper{
        CourierDto map(Courier courier) {
            return new CourierDto(
                    courier.getId(),
                    courier.getName(),
                    courier.getSalary()
            );
        }
    }
}
