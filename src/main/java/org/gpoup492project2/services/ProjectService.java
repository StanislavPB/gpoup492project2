package org.gpoup492project2.services;

import aMainProject.entity.Project;
import aMainProject.repositories.ProjectRepository;

public class ProjectService {
    private ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public void createProject(String projectName){
        Project project = new Project(projectName);
        projectRepository.addProject(project);
        System.out.println("Проект " + projectName + " создан.");
    }

    public Project findProject(String projectName){
        return projectRepository.findProject(projectName);
    }
}
