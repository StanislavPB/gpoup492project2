package org.gpoup492project2.services;

import org.gpoup492project2.Repository.ProjectRepository;
import org.gpoup492project2.entity.Project;

public class ProjectService {
    private ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
        // Создание проекта
    public void createProject(String projectName){
        Project project = new Project(projectName);
        projectRepository.addProject(project);
        System.out.println("Проект " + projectName + " создан.");
    }
        // Поиск проекта
    public Project findProject(String projectName){
        return projectRepository.findProject(projectName);
    }
}
