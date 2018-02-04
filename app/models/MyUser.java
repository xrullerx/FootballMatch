package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;
import play.data.validation.*;

/**
 * Модель пользователя
 */
@Entity
public class MyUser extends Model {
    public String email;        // Login по почтовому ящику
    public String password;     // Пароль
    public String fullname;     // Полное имя пользователя
    public boolean isAdmin;     // Признак администратора

    // Конструктор
    public MyUser(String email, String password, String fullname, boolean isAdmin) {
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.isAdmin = isAdmin;
    }


    // Геттеры и сеттеры полей
    // В данном случае не обязательня, т.к. поля публичные

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}