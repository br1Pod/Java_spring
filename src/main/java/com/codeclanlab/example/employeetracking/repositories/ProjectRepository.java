package com.codeclanlab.example.employeetracking.repositories;

import com.codeclanlab.example.employeetracking.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository <Project, Long>{
}
