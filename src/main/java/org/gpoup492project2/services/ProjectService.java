  /*
  Автор Denys Parkhomenko
  Сооавтор Vladimir Romaikin
  Cohort49-2

  Класс ProjectService предоставляет сервисный слой для управления проектами в приложении.
  Он взаимодействует с репозиторием ProjectRepository для выполнения операций по созданию, чтению, обновлению и удалению проектов,
  а также для управления задачами в проектах.

  Основные функции класса:
  - Создание нового проекта, если проект с таким идентификатором еще не существует.
  - Поиск проекта по его идентификатору.
  - Получение списка всех существующих проектов.
  - Обновление данных существующего проекта, если проект с указанным идентификатором существует.
  - Удаление проекта по его идентификатору, если проект с таким идентификатором существует.
  - Добавление задачи к проекту.
  - Получение всех задач проекта по его идентификатору.

  Класс использует инъекцию зависимости для репозитория, что позволяет легко менять реализацию репозитория при необходимости.
  */

package org.gpoup492project2.services;

import org.gpoup492project2.Repository.ProjectRepository;
import org.gpoup492project2.entity.Project;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle.refList;
import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle.title;

  public class ProjectService {

    // Репозиторий для работы с проектами
    private ProjectRepository projectRepository;

    // Конструктор, который получает репозиторий для работы
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    // Метод для создания проекта
    public void createProject(Project project){
      if (projectRepository.existsProjectById(project.getId())){
        System.out.println("Проэкт с ID " + project.getId() + " уже существует");
        return;
      }
      projectRepository.addProject(project);
      System.out.println("Проект " + project.getTitle() + " создан.");
    }

    // Метод для получения проекта по ID
    public Project getProjectById(String idProject){
      return projectRepository.getProjectById(idProject);
    }

    // Метод для обновления проекта
    public void updateProject(Project project){
      if (!projectRepository.existsProjectById(project.getId())){
        System.out.println("Проект с ID " + project.getId() + " не найден");
        return;
      }
      projectRepository.updateProject(project);
      System.out.println("Проект " + project.getTitle() + " обновлён");
    }

    // Метод для удаления проекта
    public void deleteProject(String idProject){
      if (!projectRepository.existsProjectById(idProject)){
        System.out.println("Проект с ID " + idProject + " не найден.");
        return;
      }
      projectRepository.deleteProject(idProject);
      System.out.println("Проект с ID " + idProject + " удалён.");
    }

    // Метод для получения всех проектов
    public Map<String, Project> getAllProjects(){
      return projectRepository.getAllProjects();
    }

    // Метод для поиска проекта по названию
    public List<Project> findProjectByName(String name){
      return projectRepository.getAllProjects().values().stream()
              .filter(project -> project.getTitle().equalsIgnoreCase(name))
              .collect(Collectors.toList());
    }






    // Метод для поиска проекта по id

}
