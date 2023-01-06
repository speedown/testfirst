package com.manytomany.employees.controller

import com.manytomany.employees.model.Employee
import com.manytomany.employees.services.EmployeeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1")
class EmployeeController {

    @Autowired
    private lateinit var employeeService: EmployeeService

    @PostMapping("/saveEmployee")
    fun saveEmployee(@RequestBody employee: Employee) {
        employeeService.saveEmployee(employee)
    }

    @GetMapping("/employees/{empId}")
    fun getEmployeeById(@PathVariable empId : Long) : Employee{
        return employeeService.getEmployeeById(empId)
    }

    @GetMapping("/employees")
    fun getAllEmployee() : List<Employee>{
        return employeeService.getEmployees()
    }

    @DeleteMapping("/deleteEmp/{empId}")
    fun deleteEmployeeById(@PathVariable empId: Long) {
        employeeService.deleteEmployeeById(empId)
    }

    @PutMapping("/{empId}/projectTo/{proId}")
    fun assignProjectToEmployee(@PathVariable empId: Long, @PathVariable proId : Long) {
        employeeService.assignProjectToEmployee(empId,proId)
    }




}