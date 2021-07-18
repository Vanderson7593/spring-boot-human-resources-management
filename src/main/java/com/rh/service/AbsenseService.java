package com.rh.service;

import java.util.List;

import com.rh.entity.Employee;
import com.rh.entity.Absense;

public interface AbsenseService {
    List<Absense> getAllAbsenses();

    List<Absense> getEmployeeAbsenses(Employee employee);

    void saveAbsense(Absense absense, Employee employee);

    Absense getAbsenseById(long id);

    void deleteAbsenseById(long id);
}
