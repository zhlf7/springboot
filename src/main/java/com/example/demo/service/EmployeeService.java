package com.example.demo.service;

import com.example.demo.bean.Employee;
import com.example.demo.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    public Employee getEmpandDepById(Integer id){
        Employee employee=employeeMapper.getEmpandDepById(id);
        return employee;
    }
    @Cacheable(value = {"employee"})
    public Employee getEmpById(Integer id){
        Employee employee=employeeMapper.getEmpById(id);
        return employee;
    }

    public boolean updateEmp(Employee employee){

        boolean flag=false;
        try{
            employeeMapper.updateEmp(employee);
            flag=true;
        }catch(Exception e){
            System.out.println("修改失败!");
            e.printStackTrace();
        }
        return flag;
    }

    public boolean insertEmpList(List<Employee> employeeList){
        boolean flag=false;
        try {
            employeeMapper.insertEmpList(employeeList);
            flag=true;
        }catch (Exception e){
            System.out.println("新增失败");
        }
        System.out.println(employeeList);
        return flag;
    }

    public boolean delEmpById(Employee employee){
        boolean flag=false;
        try {
            employeeMapper.delEmpById(employee);
            flag=true;
        }catch (Exception e){
            System.out.println("删除失败");
        }
        return flag;
    }
}
