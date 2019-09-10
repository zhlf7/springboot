package com.example.demo.service;

import com.example.demo.bean.Department;
import com.example.demo.dao.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;
    @Cacheable(value = {"department"})
    public Department getDepById(Integer id){
        Department  department=departmentMapper.getDepById(id);
        return  department;
    }
}
