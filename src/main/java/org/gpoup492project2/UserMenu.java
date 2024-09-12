package org.gpoup492project2;

import org.gpoup492project2.dto.ProjectDto;
import org.gpoup492project2.entity.Project;
import org.gpoup492project2.entity.Task;
import org.gpoup492project2.entity.User;
import org.gpoup492project2.services.ProjectService;
import org.gpoup492project2.services.TaskService;
import org.gpoup492project2.services.UserInput;
import org.gpoup492project2.services.UserService;

import java.util.Map;

public class UserMenu {
          private ProjectService projectService;
          private TaskService taskService;
          private UserService userService;
          private UserInput userInput;

            public UserMenu(ProjectService projectService, TaskService taskService, UserService userService) {
                this.projectService = projectService;
                this.taskService = taskService;
                this.userService = userService;
            }

            public void menuStart() {
                while (true) {
                    System.out.println("Главное Меню:");
                    System.out.println("1. Создать проект");
                    System.out.println("2. Просмотреть все проекты");
                    System.out.println("3. Управлять проектом");
                    System.out.println("3.1 Просмотреть информацию о проекте");
                    System.out.println("3.2 Добавить задачу");
                    System.out.println("3.3 Редактировать задачу");
                    System.out.println("3.4 Удалить задачу");
                   // System.out.println("3.5 Управление комментариями задачи");
                    System.out.println("3.6 Изменить информацию о проекте");
                   // System.out.println("3.7 Управление комментариями проекта");
                    System.out.println("3.8 Назначить ответственного за проект");
                    System.out.println("4. Выйти из программы");

                    int userChoose = userInput.inputInt("Выберите пункт меню: ");

                    switch (userChoose) {
                        case 1:
                            //String nameNewProject = userInput.inputText("Введите название проекта: ");
                           // String descriptionNewProject = userInput.inputText("Введите описание проекта: ");
                            Project newProject = projectService.createProject(ProjectDto projectDto);
                            if (newProject != null){
                                System.out.println("Успешно добавлен новый проект.");
                                System.out.println(newProject);
                            } else {
                                System.out.println("Проект добавить не удалось.");
                            }
                            break;
                        case 2:
                            Project[] allProjects = projectService.getAllProjects();
                            int projectCounter = 0;
                            for (int i = 0; i < allProjects.length; i++) {
                                if (allProjects[i] != null){
                                    System.out.println("Проект " + allProjects[i].getId() + " название: " + allProjects[i].getTitle());
                                    projectCounter++;
                                }
                            }
                            if (projectCounter == 0){
                                System.out.println("Проект не найден.");
                            }
                            break;

                        case 3:
                            System.out.println("3.1 Просмотреть информацию о проекте");
                            System.out.println("3.2 Добавить задачу");
                            System.out.println("3.3 Редактировать задачу");
                            System.out.println("3.4 Удалить задачу");
                            System.out.println("3.5 Изменить информацию о проекте");
                            System.out.println("3.6 Назначить ответственного за проект");

                            int subChoose = userInput.inputInt("Выберите пункт подменю: ");

                            switch (subChoose) {
                                case 1:
                                    String projectId = userInput.inputText("Введите id проекта: ");
                                    Project project = projectService.getProjectById(projectId);
                                    if (project != null) {
                                        System.out.println("Информация о проекте: " + project);
                                    } else {
                                        System.out.println("Проект не найден");
                                    }
                                    break;
                                case 2:
                                    String taskProjectId = userInput.inputText("Введите id проекта для добавления задачи: ");
                                    String newTaskTitle = userInput.inputText("Введите название задачи: ");
                                    Task newTask = projectService.addTaskToProject(taskProjectId, newTaskTitle);
                                    if (newTask != null) {
                                        System.out.println("Задача добавлена" + newTask);
                                    } else {
                                        System.out.println("Не удалось добавить задачу");
                                    }
                                    break;
                                case 3:
                                    String taskIdToUpdate = userInput.inputText("Введите id задачи для редактирования: ");
                                    Task updatedTask = taskService.updateTask(taskIdToUpdate);
                                    if (updatedTask != null) {
                                        System.out.println("Задача отредактирована " + updatedTask);
                                    } else {
                                        System.out.println("Не удалось отредактировать задачу");
                                    }
                                    break;
                                case 4:
                                    String taskIdToDelete = userInput.inputText("Введите id задачи для удаления: ");
                                    boolean removeTask = taskService.deleteTask(taskIdToDelete);
                                    if (removeTask) {
                                        System.out.println("Задача удалена");
                                    } else {
                                        System.out.println("Не удалось удалить задачу");
                                    }
                                    break;
                                case 5:
                                    String projectIdToUpdate = userInput.inputText("Введите id проекта для редактирования: ");
                                    Project updateProject = projectService.updateProject(projectIdToUpdate);
                                    if (updateProject != null) {
                                        System.out.println("Проект обновлен " + updateProject);
                                    } else {
                                        System.out.println("Не удалось изменить информацию о проекте");
                                    }
                                    break;
                                case 6:
                                    String projectIdForExecutor = userInput.inputText("Введите id проекта для назначения ответственного: ");
                                    String userId = userInput.inputText("Введите id пользователя для назначения: ");
                                    User executorForProject = userService.getUserById(userId);
                                    if (executorForProject != null) {
                                        System.out.println("Ответственный назначен");
                                    } else {
                                        System.out.println("Ответственного назначить не удалось");
                                    }
                                    break;
                                default:
                                    System.out.println("Неверный пункт подменю. Пожалуйста, попробуйте снова.");
                            }
                            break;
                        case 4:
                            System.out.println("Выход из программы.");
                            return;
                        default:
                            System.out.println("Неверный пункт меню. Пожалуйста, попробуйте снова.");
                    }
                }
            }
        }