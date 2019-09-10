package com.example.demo.bean;

import java.io.Serializable;

public class Employee implements Serializable {
    private Integer eId;
    private String name;
    private Integer gender;
    private Integer dId;
    private  Department department;

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee() {
    }

    public Employee(Integer eId, String name, Integer gender, Integer dId, Department department) {
        this.eId = eId;
        this.name = name;
        this.gender = gender;
        this.dId = dId;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eId=" + eId +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", dId=" + dId +
                ", department=" + department +
                '}';
    }
}
