package com.manytomany.project.controller

import com.manytomany.project.model.Project
import com.manytomany.project.repository.ProjectRepository
import com.manytomany.project.services.ProjectService
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
@RequestMapping("api/v1")
class ProjectController {

    @Autowired
    private lateinit var projectService: ProjectService

    @PostMapping("/saveProject")
    fun saveProject(@RequestBody project: Project){
        projectService.saveProject(project)
    }

    @GetMapping("/projects")
    fun getAllProject() : List<Project>{
        return projectService.getAllProject()
    }

    @GetMapping("/projects/{projectId}")
    fun getAllProjectById(@PathVariable projectId : Long) : Project{
        return projectService.getAllProjectById(projectId)
    }

    @DeleteMapping("/deletePro/{projectId}")
    fun deleteProjectById(@PathVariable projectId: Long) {
        projectService.deleteProjectById(projectId)
    }

    @PutMapping("/{proId}/employee/{empId}")
    fun assignEmployeeToProject(@PathVariable proId : Long, @PathVariable empId : Long) {
        projectService.assignEmployeeToProject(proId,empId)
    }
}