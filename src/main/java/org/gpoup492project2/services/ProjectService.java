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

public class ProjectService {

    // Репозиторий для работы с проектами
    private ProjectRepository projectRepository;

    // Конструктор, который получает репозиторий для работы
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    // Метод для создания проекта
    public boolean createProject(Project project) {
        // Логика проверки на дубликат проекта по ID
        if (projectRepository.getProjectById(project.getId()).existsProjectById()) {
            return false; // Проект с таким ID уже существует
        }
        projectRepository.addProject(project); // Добавление проекта в репозиторий
        return true;
    }

        // Метод для поиска проекта по id

}
