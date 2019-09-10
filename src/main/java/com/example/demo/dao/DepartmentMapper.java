package com.example.demo.dao;

import com.example.demo.bean.Department;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentMapper {
    public Department getDepById(Integer id);
}
