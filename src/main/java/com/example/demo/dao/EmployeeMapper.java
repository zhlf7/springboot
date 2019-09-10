package com.example.demo.dao;

import com.example.demo.bean.Employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeMapper {

    public Employee getEmpandDepById(Integer id);

    public Employee getEmpById(Integer id);

    public void updateEmp(Employee employee);

    public void insertEmpList(@Param("employeeList") List<Employee> employeeList);

    public void delEmpById(Employee employee);
}
