package org.gpoup492project2.Repository;

import org.gpoup492project2.entity.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TaskRepository {
    private Map<String, Task> taskStorage = new HashMap<>();

    public void addTask(Task task) {
        taskStorage.put(task.getId(), task);
    }

    // Метод для добавления задачи
    public Task getTaskById(String id) {
        return taskStorage.get(id);
    }

    // Метод для обновления задачи
    public void updateTask(Task taskToUpdate) {
        taskStorage.put(taskToUpdate.getId(), taskToUpdate);
    }

    // Метод для удаления задачи
    public void deleteTask(String taskId) {
        taskStorage.remove(taskId);
    }

    // Метод для получения списка всех задач
    public List<Task> getAllTasks() {
        return new ArrayList<>(taskStorage.values());
    }

    public List<Task> getTasksByStatus(String status) {
        return taskStorage.values().stream()
                .filter(task -> task.getStatus().equals(status))
                .collect(Collectors.toList());
    }
}
