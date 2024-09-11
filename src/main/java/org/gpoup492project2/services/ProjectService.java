package org.gpoup492project2.services;

import org.gpoup492project2.Repository.ProjectRepository;
import org.gpoup492project2.entity.Project;
import org.gpoup492project2.entity.Task;
import org.gpoup492project2.dto.ProjectDto;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProjectService {

  // Репозиторий для работы с проектами
  private ProjectRepository projectRepository;

  // Конструктор, который получает репозиторий для работы
  public ProjectService(ProjectRepository projectRepository) {
    this.projectRepository = projectRepository;
  }

  // Метод для создания проекта из DTO
  public String createProject(ProjectDto projectDto) {
    // Валидируем входные данные
    if (!validateProjectDto(projectDto)) {
      return "Некорректные данные для создания проекта.";
    }

    // Проверяем, существует ли проект с таким ID
    if (projectRepository.existsProjectById(projectDto.getTitle())) {
      return "Проект с названием " + projectDto.getTitle() + " уже существует.";
    }

    // Преобразуем DTO в объект Project
    Project project = projectDto.toProject();
    projectRepository.addProject(project);
    return "Проект " + project.getTitle() + " создан.";
  }

  // Метод для получения проекта по ID
  public Optional<Project> getProjectById(String idProject) {
    Project project = projectRepository.getProjectById(idProject);
    return Optional.ofNullable(project);
  }

  // Метод для обновления проекта
  public String updateProject(ProjectDto projectDto) {
    // Валидируем входные данные
    if (!validateProjectDto(projectDto)) {
      return "Некорректные данные для обновления проекта.";
    }

    // Проверяем, существует ли проект с таким ID
    if (!projectRepository.existsProjectById(projectDto.getTitle())) {
      return "Проект с названием " + projectDto.getTitle() + " не найден.";
    }

    // Преобразуем DTO в объект Project
    Project project = projectDto.toProject();
    projectRepository.updateProject(project);
    return "Проект " + project.getTitle() + " обновлён.";
  }

  // Метод для удаления проекта
  public String deleteProject(String idProject) {
    if (!projectRepository.existsProjectById(idProject)) {
      return "Проект с ID " + idProject + " не найден.";
    }
    projectRepository.deleteProject(idProject);
    return "Проект с ID " + idProject + " удалён.";
  }

  // Метод для получения всех проектов
  public Map<String, Project> getAllProjects() {
    return projectRepository.getAllProjects();
  }

  // Метод для поиска проекта по названию
  public Optional<Project> findProjectByName(String name) {
    List<Project> projects = projectRepository.getAllProjects().values().stream()
            .filter(project -> project.getTitle().equalsIgnoreCase(name))
            .collect(Collectors.toList());
    if (projects.isEmpty()) {
      return Optional.empty();
    }
    return Optional.of(projects.get(0));
  }

  // Метод для добавления задачи к проекту
  public String addTaskToProject(String projectId, Task task) {
    Project project = projectRepository.getProjectById(projectId);
    if (project == null) {
      return "Проект с ID " + projectId + " не найден.";
    }
    project.getTasks().add(task);
    projectRepository.updateProject(project);
    return "Задача " + task.getTitle() + " добавлена к проекту " + project.getTitle() + ".";
  }

  // Метод для удаления задачи из проекта
  public String removeTaskFromProject(String projectId, String taskId) {
    Project project = projectRepository.getProjectById(projectId);
    if (project == null) {
      return "Проект с ID " + projectId + " не найден.";
    }
    Task taskToRemove = project.getTasks().stream()
            .filter(task -> task.getId().equals(taskId))
            .findFirst()
            .orElse(null);
    if (taskToRemove == null) {
      return "Задача с ID " + taskId + " не найдена в проекте " + project.getTitle() + ".";
    }
    project.getTasks().remove(taskToRemove);
    projectRepository.updateProject(project);
    return "Задача с ID " + taskId + " удалена из проекта " + project.getTitle() + ".";
  }

  // Метод для валидации данных проекта
  private boolean validateProjectDto(ProjectDto projectDto) {
    return projectDto.getTitle() != null && !projectDto.getTitle().isEmpty() &&
            projectDto.getDescription() != null &&
            projectDto.getCreated() != null &&
            projectDto.getDeadline() != null &&
            projectDto.getPriority() != null &&
            projectDto.getStatus() != null &&
            projectDto.getExecutor() != null;
  }
}

