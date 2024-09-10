/*
Автор Vladimir Romaikin
Cohort49-2
Класс Project представляет проект в системе управления проектами.
Он содержит информацию о проекте и связанные с ним задачи.

Поля:
- id: уникальный идентификатор проекта.
- title: название проекта.
- description: описание проекта.
- created: дата создания проекта.
- deadline: дата завершения проекта.
- priority: приоритет проекта (например, высокий, средний, низкий).
- status: текущий статус проекта (например, в работе, завершен).
- executor: ответственный пользователь, связанный с проектом.
- tasks: список задач, связанных с проектом.

Основные методы:
- addTask(Task task): добавляет задачу в список задач проекта.
- removeTask(String taskId): удаляет задачу из проекта по её идентификатору.
- editTask(String taskId, Task newTask): редактирует задачу в проекте с указанным идентификатором.

Также класс включает геттеры и сеттеры для доступа и изменения полей,
и методы toString(), equals(), и hashCode().
*/

package org.gpoup492project2.entity;

import java.util.List;
import java.time.LocalDate;
import java.util.Objects;

public class Project {

    // Переменные (Поля)
    private String id;              // Уникальный идентификатор проекта
    private String title;           // Название проекта
    private String description;     // Описание проекта
    private LocalDate created;      // Дата создания проекта
    private LocalDate deadline;     // Дата завершения проекта
    private String priority;        // Приоритет проекта
    private String status;          // Статус проекта
    private User executor;          // Ответственный пользователь
    private List<Task> tasks;       // Список задач

    // Конструктор
    public Project(String id, String title, String description, LocalDate created, LocalDate deadline, String priority, String status, User executor, List<Task> tasks) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.created = created;
        this.deadline = deadline;
        this.priority = priority;
        this.status = status;
        this.executor = executor;
        this.tasks = tasks;
    }

    // Метод добавляет задачу в проект.
    public void addTask(Task task) {
        tasks.add(task);
    }

    // Метод удаляет задачу по её идентификатору.
    public boolean removeTask(String taskId) {
        return tasks.removeIf(task -> task.getId().equals(taskId));
    }

    // Метод редактирует задачу с указанным идентификатором.
    public boolean editTask(String taskId, Task newTask) {
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            if (task.getId().equals(taskId)) {
                tasks.set(i, newTask);
                return true;
            }
        }
        return false;
    }

    // Геттеры и сеттеры

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
        return tasks;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
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

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    // Переопределение метода toString()
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
                ", executor=" + executor +
                ", tasks=" + tasks +
                '}';
    }

    // Переопределение метода equals()
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
                Objects.equals(executor, project.executor);
    }

    // Переопределение метода hashCode()
    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, created, deadline, priority, status, executor);
    }
}
