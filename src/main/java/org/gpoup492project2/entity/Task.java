/**
  Автор Vladimir Romaikin
  Сohort49-2

  Класс Task представляет задачу в системе управления проектами.
  Этот класс хранит информацию о задаче, её характеристиках и предоставляет методы для её управления.

  Основные поля:

- id: Уникальный идентификатор задачи.
- title: Название задачи.
- description: Описание задачи.
- created: Дата создания задачи.
- deadline: Дата выполнения задачи.
- priority: Приоритет задачи (например, высокий, средний, низкий).
- status: Статус задачи (например, в работе, завершена).
- executor: Ответственный пользователь за выполнение задачи.

  Основные методы:

- editTask(String newTitle, String newDescription, LocalDate newDeadline,
  String newPriority, String newStatus): Обновляет информацию о задаче,
  включая название, описание, дату выполнения, приоритет и статус.
- Геттеры и сеттеры для доступа и обновления полей задачи.
- toString(): Возвращает строковое представление объекта Task.
- Включает информацию о всех полях задачи.
- equals(Object o): Сравнивает текущий объект Task с другим объектом.
  Возвращает true, если объекты равны, false в противном случае.
- hashCode(): Вычисляет хэш-код для объекта Task.
- Используется для корректного функционирования хэш-таблиц и других коллекций.
*/

package org.gpoup492project2.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Task {

        // Поля класса Task
        private String id;                // Уникальный идентификатор задачи
        private String title;             // Название задачи
        private String description;       // Описание задачи
        private LocalDate created;        // Дата создания задачи
        private LocalDate deadline;       // Дата выполнения задачи
        private String priority;          // Приоритет задачи (например, высокий, средний, низкий)
        private String status;            // Статус задачи (например, в работе, завершена)
        private User executor;            // Ответственный пользователь

        //Конструктор класса Task.
        public Task(String id, String title, String description, LocalDate created, LocalDate deadline, String priority, String status, User executor) {
            this.id = id;
            this.title = title;
            this.description = description;
            this.created = created;
            this.deadline = deadline;
            this.priority = priority;
            this.status = status;
            this.executor = executor;
        }

        //Метод для редактирования задачи.
        public void editTask(String newTitle, String newDescription, LocalDate newDeadline, String newPriority, String newStatus) {
            this.title = newTitle;
            this.description = newDescription;
            this.deadline = newDeadline;
            this.priority = newPriority;
            this.status = newStatus;
        }

        // Геттеры для доступа к полям задачи

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

        // Сеттеры для обновления данных задачи
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

        //Метод для переопределения
        @Override
        public String toString() {
            return "Task{" +
                    "id='" + id + '\'' +
                    ", title='" + title + '\'' +
                    ", description='" + description + '\'' +
                    ", created=" + created +
                    ", deadline=" + deadline +
                    ", priority='" + priority + '\'' +
                    ", status='" + status + '\'' +
                    ", executor=" + executor.getName() + " " + executor.getSurname() +
                    '}';
        }

        //Сравнивает текущий объект Task с другим объектом Task.
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Task task = (Task) o;
             return Objects.equals(id, task.id) &&
                    Objects.equals(title, task.title) &&
                    Objects.equals(description, task.description) &&
                    Objects.equals(created, task.created) &&
                    Objects.equals(deadline, task.deadline) &&
                    Objects.equals(priority, task.priority) &&
                    Objects.equals(status, task.status) &&
                    Objects.equals(executor, task.executor);
        }

        //Вычисляет хэш-код объекта Task.
        @Override
        public int hashCode() {
            return Objects.hash(id, title, description, created, deadline, priority, status, executor);
        }
    }


