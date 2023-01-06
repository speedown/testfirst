package com.manytomany.employees.repository

import com.manytomany.employees.model.Employee
import org.springframework.data.jpa.repository.JpaRepository


interface EmployeeRepository : JpaRepository<Employee,Long>{

    /*fun findAllByEmpId(empId: Long?): List<Employee>*/
}