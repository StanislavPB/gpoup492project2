/**
 * Data Transfer Object (DTO) для task.
 * Используется для передачи данных пользователя между слоями приложения.
 * Позволяет собирать данные из пользовательского ввода и создавать объект Task.
 */

package org.gpoup492project2.dto;

import org.gpoup492project2.entity.Task;
import java.time.LocalDate;

public class TaskDto {

    //Поля которые мы используем в TaskDTO
    public class TaskDTO {
        private String title;             // Название задачи
        private String description;       // Описание задачи
        private LocalDate created;        // Дата создания задачи
        private LocalDate deadline;       // Дата выполнения задачи
        private String priority;          // Приоритет задачи (например, высокий, средний, низкий)
        private String status;            // Статус задачи (например, в работе, завершена)
        private User executor;            // Ответственный пользователь

        // Конструктор для инициализации полей
        public TaskDTO(String title, String description, LocalDate created, LocalDate deadline,
                       String priority, String status, User executor) {
            this.title = title;
            this.description = description;
            this.created = created;
            this.deadline = deadline;
            this.priority = priority;
            this.status = status;
            this.executor = executor;
        }

        // Метод для создания объекта Task
        public void createTask(Task task) {
            // Устанавливаем данные для объекта Task из полей TaskDTO
            task.setTitle(this.title);
            task.setDescription(this.description);
            task.setCreated(this.created);
            task.setDeadline(this.deadline);
            task.setPriority(this.priority);
            task.setStatus(this.status);
            task.setExecutor(this.executor);
        }

        // Геттеры и сеттеры

        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }

        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }

        public LocalDate getCreated() { return created; }
        public void setCreated(LocalDate created) { this.created = created; }

        public LocalDate getDeadline() { return deadline; }
        public void setDeadline(LocalDate deadline) { this.deadline = deadline; }

        public String getPriority() { return priority; }
        public void setPriority(String priority) { this.priority = priority; }

        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }

        public User getExecutor() { return executor; }
        public void setExecutor(User executor) { this.executor = executor; }
    }


}

/*
Создаем объект TaskDTO в нужном классе:
TaskDTO taskDTO = new TaskDTO(title, description, created, deadline, priority, status, executor);

Создаем объект Task в сервисном классе, где будет вызываться метод createTask:
Task task = new Task();
taskDTO.createTask(task);
*/