package com.manytomany.project.services

import com.manytomany.employees.model.Employee
import com.manytomany.employees.repository.EmployeeRepository
import com.manytomany.project.model.Project
import com.manytomany.project.repository.ProjectRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProjectService {

    @Autowired
    private lateinit var projectRepository: ProjectRepository

    @Autowired
    private lateinit var employeeRepository: EmployeeRepository

    fun saveProject(project: Project) {
        projectRepository.save(project)
    }

    fun getAllProject() : List<Project> {
        return projectRepository.findAll()
    }

    fun getAllProjectById(projectId : Long) : Project{
        return projectRepository.findById(projectId).get()
    }

    fun deleteProjectById(projectId : Long) {
        projectRepository.deleteById(projectId)
    }

    fun assignEmployeeToProject(proId : Long, empId : Long) {
        lateinit var employees : Set<Employee>
        val employee = employeeRepository.findById(proId).get()
        val project = projectRepository.findById(empId).get()

        employees = project.employeeSet
        project.employeeSet = employees
        projectRepository.save(project)
    }
}