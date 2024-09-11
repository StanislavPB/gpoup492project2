package org.gpoup492project2.services;

import org.gpoup492project2.Repository.TaskRepository;
import org.gpoup492project2.entity.Task;
import org.gpoup492project2.entity.User;

import java.time.LocalDate;
import java.util.List;

public class TaskService {
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void createTask(String id, String title, String description, LocalDate created, LocalDate deadline, String priority, String status, User executor){
        Task task = new Task(id, title, description,created, deadline, priority, status, executor);
        taskRepository.addTask(task);
        System.out.println("Задача " + title + " создана.");
    }

    public Task getTaskById(String id){
        return taskRepository.getTaskById(id);
    }

    public void updateTask(Task taskToUpdate){
        taskRepository.updateTask(taskToUpdate);
    }

    public void deleteTask(String taskToDelete){
        taskRepository.deleteTask(taskToDelete);
    }
    //
    public List<Task> getAllTasks(){
        return taskRepository.getAllTasks();
    }

    public List<Task> tasksByStatus(String status){
        return taskRepository.getTasksByStatus(status);
    }
}
