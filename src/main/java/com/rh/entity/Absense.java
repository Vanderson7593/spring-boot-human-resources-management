package com.rh.entity;

import javax.persistence.*;

import org.hibernate.annotations.DynamicUpdate;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamicUpdate
public class Absense {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  public long getId() {
    return this.id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @ManyToOne
  private Employee employee;

  public Employee getEmployee() {
    return this.employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

  @Column
  private String date;

  public String getDate() {
    return this.date;
  }

  public void setDate(String date) {
    this.date = date;
  }

}
