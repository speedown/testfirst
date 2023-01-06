package com.manytomany.project.repository

import com.manytomany.project.model.Project
import org.springframework.data.jpa.repository.JpaRepository

interface ProjectRepository : JpaRepository<Project,Long> {

    /*fun findAllProjectById(id : Long) : List<Project>*/
}