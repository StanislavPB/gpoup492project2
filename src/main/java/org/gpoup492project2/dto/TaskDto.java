/**
 * Data Transfer Object (DTO) для task.
 * Используется для передачи данных пользователя между слоями приложения.
 * Позволяет собирать данные из пользовательского ввода и создавать объект Task.
 */

package org.gpoup492project2.dto;

import org.gpoup492project2.entity.Comment;
import org.gpoup492project2.entity.Task;
import org.gpoup492project2.entity.User;

import java.time.LocalDate;
import java.util.List;

public class TaskDto {

    // Поля DTO, соответствующие полям класса Task
    private String title;             // Название задачи
    private String description;       // Описание задачи
    private LocalDate created;        // Дата создания задачи
    private LocalDate deadline;       // Дата выполнения задачи
    private String priority;          // Приоритет задачи
    private String status;            // Статус задачи
    private User executor;            // Ответственный пользователь
    private List<Comment> comments;   // Добавлено для хранения комментариев

    // Конструктор для инициализации всех полей


    public TaskDto(String title, String description, LocalDate created, LocalDate deadline, String priority, String status, User executor, List<Comment> comments) {
        this.title = title;
        this.description = description;
        this.created = created;
        this.deadline = deadline;
        this.priority = priority;
        this.status = status;
        this.executor = executor;
        this.comments = comments;
    }

    // Преобразование DTO в объект Task
    public Task createTask() {
        // Создаем объект Task, используя конструктор с 9 параметрами
        Task task = new Task(
                null,                  // id, можно установить позже
                this.title,
                this.description,
                this.created,
                this.deadline,
                this.priority,
                this.status,
                this.executor,
                this.comments == null ? List.of() : this.comments // Если comments == null, передаем пустой список
        );
        return task;
    }

    // Геттеры и сеттеры для всех полей

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getExecutor() {
        return executor;
    }

    public void setExecutor(User executor) {
        this.executor = executor;
    }
}

