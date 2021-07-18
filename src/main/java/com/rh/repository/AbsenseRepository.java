package com.rh.repository;

import com.rh.entity.Absense;
import com.rh.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AbsenseRepository extends JpaRepository<Absense, Long> {

  List<Absense> findAllByEmployee(Employee employee);

}
