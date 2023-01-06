package com.manytomany.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.manytomany.employees.model.Employee;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "PROJECT")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long proId;

    private String proName;


    @JsonIgnore
    @ManyToMany(mappedBy = "assignProjects")
    private Set<Employee> employeeSet = new HashSet<>();

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }
}
