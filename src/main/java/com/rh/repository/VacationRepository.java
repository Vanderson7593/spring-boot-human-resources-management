package com.rh.repository;

import com.rh.entity.Employee;
import com.rh.entity.Vacation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacationRepository extends JpaRepository<Vacation, Long> {

  List<Vacation> findAllByEmployee(Employee employee);

}
