package com.abdullah.spring.boot.practice.controller;

import com.abdullah.spring.boot.practice.entity.Department;
import com.abdullah.spring.boot.practice.service.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {


    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList() {
        return departmentService.fetchDepartmentList();
    }

    @GetMapping ("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id")  Long departmentId){
        return departmentService.fetchDepartmentByID(departmentId);
    }

    @DeleteMapping ("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
            departmentService.deleteDepartmentById(departmentId);

    return "Department deleted Successfully!!";

    }

    @PutMapping ("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,
                                       @RequestBody Department department) {
        return departmentService.updateDepartment(departmentId, department);
    }

        @GetMapping("/departments/name/{name}")
        public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
            return departmentService.fetchDepartmentByName(departmentName);


        }





}
