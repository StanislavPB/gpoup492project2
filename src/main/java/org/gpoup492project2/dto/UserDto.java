/**
 * Data Transfer Object (DTO) для UserD.
 * Используется для передачи данных пользователя между слоями приложения.
 * Позволяет собирать данные из пользовательского ввода и создавать объект UserD.
 */

package org.gpoup492project2.dto;

import org.gpoup492project2.entity.User;

public class UserDto {

        //Поля которые мы используем в UserDTO
        private String name;
        private String surname;
        private String login;
        private Object passwordHash;

        // Конструктор с параметрами
        public void UserDTO(String name, String surname, String login, Object passwordHash) {
            this.name = name;
            this.surname = surname;
            this.login = login;
            this.passwordHash = passwordHash;
        }

        // Геттеры и сеттеры
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public Object getPasswordHash() {
            return passwordHash;
        }

        public void setPasswordHash(Object passwordHash) {
            this.passwordHash = passwordHash;
        }


}
