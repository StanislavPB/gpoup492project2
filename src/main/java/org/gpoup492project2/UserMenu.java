package org.gpoup492project2;

import org.gpoup492project2.entity.Project;
import org.gpoup492project2.entity.User;
import org.gpoup492project2.services.ProjectService;
import org.gpoup492project2.services.TaskService;
import org.gpoup492project2.services.UserInput;
import org.gpoup492project2.services.UserService;

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

            public void showMenu() {
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


                    int choice = userInput.inputInt("Выберите пункт меню: ");


                    switch (choice) {
                        case 1:
                            projectService;
                            break;
                        case 2:
                            setUserService();
                            break;
                        case 3:
                            //();
                            break;
                        case 4:
                            //();
                            break;
                        case 5:
                            //();
                            break;
                        case 6:
                            System.out.println("Выход из программы.");
                            return;
                        default:
                            System.out.println("Неверный пункт меню. Пожалуйста, попробуйте снова.");
                    }
                }
            }

           public void setProjectService() {
                String title = userInput.inputText("Введите название проекта: ");
                String description = userInput.inputText("Введите описание проекта: ");
                String priority = userInput.inputText("Введите приротет проекта: ");
                String executor = userInput.inputText("Введите ответственного: ");
                projectService.createProject(new Project(title,description,priority,executor));
            }

            private void setUserService() {
                String name = userInput.inputText("Введите ваше имя: ");
                String surname = userInput.inputText("Введите вашу фамилию: ");
                User user = new User();
                userService.createUser(new User(id, name, surname, login, password));
            }
        }