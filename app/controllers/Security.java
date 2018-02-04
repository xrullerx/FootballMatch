package controllers;

import models.*;

public class Security extends Secure.Security {

    /**
     * Переопределенный метод аутоидентификации пользователя
     * @param String username
     * @param String password
     * @return boolean
     */
    static boolean authenticate(String username, String password) {
        MyUser user = MyUser.find("byEmail", username).first();
        return user != null && user.password.equals(password) && user.isAdmin();
    }
}