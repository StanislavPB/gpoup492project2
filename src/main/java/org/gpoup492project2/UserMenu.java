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
                    System.out.println("3.3.1 Изменить название задачи");
                    System.out.println("3.3.2 Изменить описание задачи");
                    System.out.println("3.3.3 Изменить дедлайн задачи");
                    System.out.println("3.3.4 Изменить приоритет задачи");
                    System.out.println("3.3.5 Изменить статус задачи");
                    System.out.println("3.4 Удалить задачу");

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
                            Project[] choosenProject = allProjects[].getId();
                            System.out.println("Управление проектом. Информация о проекте.");
                            System.out.println(choosenProject);
                            break;
                        case 4:
                            Task newTask = projectService.addTaskToProject();
                           // String newTask = userInput.inputText("Введите название задачи: ");
                            System.out.println("Задача добавлена" + newTask);
                            break;
                        case 5:
                            System.out.println("Редактировать задачу");
                            break;
                        case 6:
                            Task updateTask = taskService.updateTask();
                            System.out.println("Выход из программы.");
                            return;
                        default:
                            System.out.println("Неверный пункт меню. Пожалуйста, попробуйте снова.");
                    }
                }
            }
        }