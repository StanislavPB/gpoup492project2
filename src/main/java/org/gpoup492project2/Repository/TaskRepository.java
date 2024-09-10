package org.gpoup492project2.Repository;

import org.gpoup492project2.entity.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class TaskRepository {
    private Map<String, Task> taskStorage = new HashMap<>();

    public void addTask(Task task) {
        taskStorage.put(task.getId(), task);
    }

    public Task getTaskById(String id) {
        return taskStorage.get(id);
    }

    public void updateTask(Task updateTask) {
        taskStorage.put(updateTask.getId(), updateTask);
    }

    public void deleteTask(String id) {
        taskStorage.remove(id);
    }

    public List<Task> getAllTasks() {
        return new ArrayList<>(taskStorage.values());
    }

    public List<Task> getTasksByStatus(String status) {
        return taskStorage.values().stream()
                .filter(task -> task.getStatus().equals(status))
                .collect(Collectors.toList());
    }
}
