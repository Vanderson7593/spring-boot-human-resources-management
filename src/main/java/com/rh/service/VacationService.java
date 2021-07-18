package com.rh.service;

import java.util.List;

import com.rh.entity.Employee;
import com.rh.entity.Vacation;

public interface VacationService {
    List<Vacation> getAllVacations();

    List<Vacation> getEmployeeVacations(Employee employee);

    void saveVacation(Vacation vacation, Employee employee);

    Vacation getVacationById(long id);

    void deleteVacationById(long id);
}
