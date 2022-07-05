package nl.hu.bep.security;


import nl.hu.bep.PersistensieManager.AppManager;
import nl.hu.bep.model.Snake;

import java.io.Serializable;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyUser implements Principal, Serializable {
    public String username;
    public String password;
    private String role;

//    public static List<MyUser> allUsers = new ArrayList<>();

    private static List<MyUser> getAllUsers() {
        return Collections.unmodifiableList(AppManager.getAppManager().getAlleUsers());
    }

    private MyUser(String username, String password) {
        this.username = username;
        this.password = password;
        this.role = "user";

//        allUsers.add(this);
        if (!AppManager.getAppManager().getAlleUsers().contains(this)) AppManager.getAppManager().getAlleUsers().add(this);
    }

    @Override
    public boolean equals(Object obj) {
        boolean resultaat = obj instanceof MyUser;

        resultaat = resultaat && ((MyUser) obj).role.equals(role);
        resultaat = resultaat && ((MyUser) obj).username.equals(username);
        resultaat = resultaat && ((MyUser) obj).password.equals(password);

        return resultaat;
    }

    public static String validateLogin(String username, String password) {
        for (MyUser myUser : getAllUsers()) {
            if (myUser.username.equals(username) && myUser.password.equals(password)) {
                return myUser.role;
            }
        }
        return null;
    }

    public static MyUser getUserByUsername(String username) {
        for (MyUser myUser : getAllUsers()) {
            if(myUser.username.equals(username)) return myUser;
        }
        return null;
    }

//    public static Snake getSnakeByUsername(String username){
//        for (MyUser myUser : allUsers) {
//            if (myUser.getName().equals(username)) {
//                return myUser.getSnake();
//            }
//        }
//        return null;
//    }

    public static boolean addUser(String username, String password, String role) {
        MyUser myUser = MyUser.getUserByUsername(username);

        if (myUser == null) {
            new MyUser(username, password);
            return true;
        }

        return false;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String getName() {
        return username;
    }

}
