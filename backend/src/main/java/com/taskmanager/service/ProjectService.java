package com.taskmanager.service;

import com.taskmanager.model.Project;
import com.taskmanager.repository.ProjectRepository;
import com.taskmanager.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    // Logic: Retrieve all projects from the database
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    // Logic: Create a new project
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    // Logic: Find a project by ID or throw our custom exception
    public Project getProjectById(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found with id: " + id));
    }

    // Logic: Delete a project
    public void deleteProject(Long id) {
        Project project = getProjectById(id);
        projectRepository.delete(project);
    }
}
