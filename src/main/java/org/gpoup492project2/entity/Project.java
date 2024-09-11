package org.gpoup492project2.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
  Автор Vladimir Romaikin
  Cohort49-2

  Класс Project представляет проект в системе управления проектами.
  Этот класс хранит информацию о проекте, его характеристиках, а также предоставляет методы для управления задачами в проекте.

  Основные поля:

  - id: Уникальный идентификатор проекта (будет присвоен после добавления в репозиторий).
  - title: Название проекта.
  - description: Описание проекта.
  - created: Дата создания проекта.
  - deadline: Дата завершения проекта.
  - priority: Приоритет проекта (использует константы из вложенного класса Priority).
  - status: Статус проекта (использует константы из вложенного класса Status).
  - executor: Ответственный пользователь за выполнение проекта.
  - tasks: Список задач, связанных с проектом (начально пустой).

  Основные методы:

  - addTask(Task task): Добавляет задачу в проект.
  - removeTask(Task task): Удаляет задачу из проекта.
  - Геттеры и сеттеры для доступа и обновления полей проекта.
  - toString(): Возвращает строковое представление объекта Project.
    Включает информацию о всех полях проекта, а также количество задач.
  - equals(Object o): Сравнивает текущий объект Project с другим объектом.
    Возвращает true, если объекты равны, false в противном случае.
  - hashCode(): Вычисляет хэш-код для объекта Project.
    Используется для корректного функционирования хэш-таблиц и других коллекций.
 */
public class Project {

    // Вложенный класс для хранения констант приоритетов
    public static class Priority {
        public static final String HIGH = "Приоритет высокий";
        public static final String MEDIUM = "Средний приоритет";
        public static final String LOW = "Приоритет низкий";
    }

    // Вложенный класс для хранения констант статусов
    public static class Status {
        public static final String NOT_STARTED = "Не начат";
        public static final String IN_PROGRESS = "В работе";
        public static final String COMPLETED = "Завершен";
    }

    // Поля класса Project
    private String id;                // Уникальный идентификатор проекта (будет присвоен после добавления в репозиторий)
    private String title;             // Название проекта
    private String description;       // Описание проекта
    private LocalDate created;        // Дата создания проекта
    private LocalDate deadline;       // Дата завершения проекта
    private String priority;          // Приоритет проекта (использует константы из класса Priority)
    private String status;            // Статус проекта (использует константы из класса Status)
    private User executor;            // Ответственный пользователь
    private List<Task> tasks;         // Список задач (начально пустой)

    // Конструктор класса Project
    public Project(String id, String title, String description, LocalDate created, LocalDate deadline, String priority, String status, User executor) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.created = created;
        this.deadline = deadline;
        this.priority = priority;
        this.status = status;
        this.executor = executor;
        this.tasks = new ArrayList<>(); // Инициализация списка задач
    }

    // Геттеры для доступа к полям проекта
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getCreated() {
        return created;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public String getPriority() {
        return priority;
    }

    public String getStatus() {
        return status;
    }

    public User getExecutor() {
        return executor;
    }

    public List<Task> getTasks() {
        return new ArrayList<>(tasks); // Возвращаем копию списка задач
    }

    // Сеттеры для обновления данных проекта
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setExecutor(User executor) {
        this.executor = executor;
    }

    // Метод toString для удобного вывода информации о проекте
    @Override
    public String toString() {
        return "Project{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", created=" + created +
                ", deadline=" + deadline +
                ", priority='" + priority + '\'' +
                ", status='" + status + '\'' +
                ", executor=" + executor.getName() + " " + executor.getSurname() +
                ", tasks=" + tasks.size() + " tasks" +
                '}';
    }

    // Метод equals для сравнения двух объектов Project
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(id, project.id) &&
                Objects.equals(title, project.title) &&
                Objects.equals(description, project.description) &&
                Objects.equals(created, project.created) &&
                Objects.equals(deadline, project.deadline) &&
                Objects.equals(priority, project.priority) &&
                Objects.equals(status, project.status) &&
                Objects.equals(executor, project.executor) &&
                Objects.equals(tasks, project.tasks);
    }

    // Метод hashCode для вычисления уникального хэш-кода объекта Project
    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, created, deadline, priority, status, executor, tasks);
    }
}

