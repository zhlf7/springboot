package com.example.demo.controller;

import com.example.demo.bean.Department;
import com.example.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/dep")
@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/getDep",method = RequestMethod.GET)
    public Department getDepById(@RequestParam(value = "id",required = true) Integer id){
        Department depById = departmentService.getDepById(id);
        return depById;
    }
}
