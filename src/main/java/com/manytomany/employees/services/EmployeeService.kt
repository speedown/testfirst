package com.manytomany.employees.services

import com.manytomany.employees.model.Employee
import com.manytomany.employees.repository.EmployeeRepository
import com.manytomany.project.model.Project
import com.manytomany.project.repository.ProjectRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class EmployeeService {

    @Autowired
    private lateinit var employeeRepository: EmployeeRepository

    @Autowired
    private lateinit var projectRepository: ProjectRepository


    fun saveEmployee (employee: Employee)  {
        employeeRepository.save(employee)
    }

    fun getEmployeeById(id : Long) : Employee {
        return employeeRepository.findById(id).get()
    }

    fun getEmployees() : List<Employee> {
        return employeeRepository.findAll()
    }

    fun deleteEmployeeById(id : Long) {
        employeeRepository.deleteById(id)
    }

    fun assignProjectToEmployee(empId : Long, proId : Long) {

        lateinit var projects :  Set<Project>
        val employee : Employee = employeeRepository.findById(empId).get()
        val project : Project = projectRepository.findById(proId).get()

        projects = employee.assignProjects
        projects.add(project)
        employee.assignProjects = projects
        employeeRepository.save(employee)

    }
}
