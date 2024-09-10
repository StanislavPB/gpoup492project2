package org.gpoup492project2.services;

import aMainProject.entity.Task;
import aMainProject.repositories.TaskRepository;

import java.util.List;

public class TaskService {
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void createTask(String title, String description, String assignTo, String dueDate, int priority){
        Task task = new Task(title, description, assignTo, dueDate, priority);
        taskRepository.addTask(task);
        System.out.println("Задача " + title + " создана.");
    }

    public Task findTask(String title){
        return taskRepository.findTask(title);
    }

    public List<Task> getAllTasks(){
        return taskRepository.getAllTasks();
    }
}
