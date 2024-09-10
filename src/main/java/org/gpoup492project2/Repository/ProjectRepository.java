package org.gpoup492project2.Repository;

import org.gpoup492project2.entity.Project;

import java.util.HashMap;
import java.util.Map;

class ProjectRepository {
    private Map<String, Project> projectMap = new HashMap<>();

    public void addProject(Project project) {
        projectMap.put(project.getId(), project);
    }

    public Project getProjectById(String id) {
        return projectMap.get(id);
    }

    public void updateProject(Project updateProject) {
        projectMap.put(updateProject.getId(), updateProject);
    }

    public void deleteProject(String id) {
        projectMap.remove(id);
    }

    public Map<String, Project> getAllProjects() {
        return projectMap;
    }
}
