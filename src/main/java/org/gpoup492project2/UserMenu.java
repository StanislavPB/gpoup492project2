package org.gpoup492project2;

import org.gpoup492project2.entity.Project;
import org.gpoup492project2.entity.User;
import org.gpoup492project2.services.ProjectService;
import org.gpoup492project2.services.TaskService;
import org.gpoup492project2.services.UserInput;
import org.gpoup492project2.services.UserService;

public class UserMenu {
    public static void main(String[] args) {

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


                    int choice = userInput.inputInt("Выберите пункт меню: ");


                    switch (choice) {
                        case 1:
                            projectService;
                            break;
                        case 2:
                            setUserService();
                            break;
                        case 3:
                            //findByTitle();
                            break;
                        case 4:
                            //findBooksByAuthor();
                            break;
                        case 5:
                            //findMagazineByIssueNumber();
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

            /* private void findByTitle() {
                String title = userInput.inputText("Введите название для поиска: ");
                Book book = bookService.findBookByTitle(title);
                Magazine magazine = magazineService.findMagazineByTitle(title);
                if (book != null) {
                    book.printBook();
                } else if (magazine != null) {
                    magazine.printMagazine();
                } else {
                    System.out.println("Такое название не найдено.");
                }
            }

            private void findBooksByAuthor() {
                String author = userInput.inputText("Введите автора для поиска книг: ");
                Book[] books = bookService.findBooksByAuthor(author);
                if (books.length > 0) {
                    for (Book book : books) {
                        book.printBook();
                    }
                } else {
                    System.out.println("Книги не найдены.");
                }
            }

            private void findMagazineByIssueNumber() {
                String issueNumber = userInput.inputText("Введите номер выпуска журнала для поиска: ");
                Magazine magazine = magazineService.findMagazineByIssueNumber(issueNumber);
                if (magazine != null) {
                    magazine.printMagazine();
                } else {
                    System.out.println("Журнал не найден.");
                }
            }

            */

        }

    }
}
