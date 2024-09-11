package org.gpoup492project2.Repository;

import org.gpoup492project2.entity.Project;

import java.util.HashMap;
import java.util.Map;

public class ProjectRepository {
    private Map<String, Project> projectMap = new HashMap<>();

    public void addProject(Project project) {
        projectMap.put(project.getId(), project);
    }

    // Метод для получения проекта по идентификатору
    public Project getProjectById(String id) {
        return projectMap.get(id);
    }
    // Метод для обновления проекта
    public void updateProject(Project updateProject) {
        projectMap.put(updateProject.getId(), updateProject);
    }

    // Метод для удаления проекта
    public void deleteProject(String id) {
        projectMap.remove(id);
    }

    // Метод для получения всех проектов
    public Map<String, Project> getAllProjects() {
        return projectMap;
    }

    // Метод поиска по ID
    public boolean existsProjectById(String id) {
        return projectMap.containsKey(id);
    }
    // Метод поиска по названию
    public boolean existsProjectByName(String name) {
        for (Project project : projectMap.values()) {
            if (project.getTitle().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
