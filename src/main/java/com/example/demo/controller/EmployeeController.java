package com.example.demo.controller;

import com.example.demo.bean.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//restful风格接口
@RestController
@RequestMapping("/emp")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @RequestMapping(value = "/getEmpAndEmp",method = RequestMethod.GET)
    public Employee getEmpAndDepById(@RequestParam(value = "id",required = true) Integer id){
        Employee employee=employeeService.getEmpandDepById(id);
        return employee;
    }

    @RequestMapping(value = "/getEmp",method = RequestMethod.GET)
    public Employee getEmpById(@RequestParam(value = "id",required = true) Integer id){
        Employee employee=employeeService.getEmpById(id);
        return employee;
    }

    @RequestMapping(value = "/updataEmp",method = RequestMethod.PUT)
    public Employee  updateEmp(@RequestBody Employee employee){
        System.out.println(employee);
        return employeeService.updateEmp(employee);
    }

    @RequestMapping(value = "/insertEmps",method = RequestMethod.POST)
    public boolean insertEmpList(@RequestBody List<Employee> employeeList){
        System.out.println(employeeList);
        return employeeService.insertEmpList(employeeList);
    }

    @RequestMapping(value = "/delEmp",method = RequestMethod.DELETE)
    public boolean delEmpById(@RequestBody Employee employee){
        return  employeeService.delEmpById(employee);
    }
}
