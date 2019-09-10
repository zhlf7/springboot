package com.example.demo.service;

import com.example.demo.bean.Employee;
import com.example.demo.dao.EmployeeMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public Employee getEmpandDepById(Integer id){
        Employee employee=employeeMapper.getEmpandDepById(id);
        return employee;
    }
    @Cacheable(value = {"employee"})
    public Employee getEmpById(Integer id){
        Employee employee=employeeMapper.getEmpById(id);
        /*发送一个消息*/
        rabbitTemplate.convertAndSend("exchang.direct","test.news",employee);
        return employee;
    }
    @CachePut(value ="employee",key = "#employee.eId")
    public Employee updateEmp(Employee employee){
        try{
            employeeMapper.updateEmp(employee);
        }catch(Exception e){
            System.out.println("修改失败!");
            e.printStackTrace();
        }
        return employee;
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
    @CacheEvict(value = "employee",key = "#employee.eId" )
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
    @RabbitListener(queues = "test.news")
    public void receive(Employee employee){
        System.out.println("收到消息："+employee);

    }

}
