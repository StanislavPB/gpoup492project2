/**
 * Data Transfer Object (DTO) для Project.
 * Используется для передачи данных пользователя между слоями приложения.
 * Позволяет собирать данные из пользовательского ввода и создавать объект Project.
 */

package org.gpoup492project2.dto;

import org.gpoup492project2.entity.Project;
import java.time.LocalDate;
import java.util.ArrayList;

public class ProjectDto {

        //Поля которые мы используем в ProjectDTO
        private String title;           // Название проекта
        private String description;     // Описание проекта
        private LocalDate created;      // Дата создания проекта
        private LocalDate deadline;     // Дата завершения проекта
        private String priority;        // Приоритет проекта
        private String status;          // Статус проекта
        private User executor;          // Ответственный пользователь
        private List<Task> tasks = new ArrayList<>(); // Инициализация пустым списком

        // Конструктор
        public void ProjectDTO(String title, String description, LocalDate created, LocalDate deadline,
                               String priority, String status, User executor, List<Task> tasks) {
            this.title = title;
            this.description = description;
            this.created = created;
            this.deadline = deadline;
            this.priority = priority;
            this.status = status;
            this.executor = executor;
            this.tasks = tasks != null ? tasks : new ArrayList<>(); // Инициализация пустым списком, если передан null
        }

        // Метод для создания объекта Project
        public Project toProject() {
            return new Project(
                    null, // ID будет присвоен после добавления в репозиторий
                    title,
                    description,
                    created,
                    deadline,
                    priority,
                    status,
                    executor,
                    tasks
            );
        }

        // Геттеры
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

        public List<Task> getTasks() { return tasks; }
        public void setTasks(List<Task> tasks) { this.tasks = tasks; }
}





