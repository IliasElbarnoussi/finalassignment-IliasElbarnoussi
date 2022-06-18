//package nl.hu.bep.security;
//
//
//import java.security.Principal;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//public class MyUser implements Principal {
//
//
//    public String username;
//    public String password;
//    private String role;
////    private Shopper shopper;
//
//    public static List<MyUser> allUsers = new ArrayList<>();
//
//    private static List<MyUser> getAllUsers() {
//        return Collections.unmodifiableList(allUsers);
//    }
//
//    private MyUser(String username, String password, Shopper theShopper) {
//        this.username = username;
//        this.password = password;
//        this.role = "user";
//        this.shopper = theShopper;
//        allUsers.add(this);
//    }
//
//    public static String validateLogin(String username, String password) {
//        MyUser found = getUserByUsername(username);
//
//        if (found != null && found.password.equals(password)) return found.role;
//        return null;
//    }
//
//    public static MyUser getUserByUsername(String username) {
//        for (MyUser myUser : allUsers) {
//            if(myUser.username.equals(username)) return myUser;
//        }
//        return null;
//    }
//
//    public static boolean addUser(String username, String password, String shopperName, String role) {
//        Shopper shopper = Shopper.getShopperByName(shopperName);
//
////        if (getUserByUsername(username) == null && shopper != null) {
////            new MyUser(username, password, shopper);
////        }
////        else return false;
//
//        if (getUserByUsername(username) == null && shopper != null && role.equals("admin")) {
//            MyUser admin = new MyUser(username, password, shopper);
//            admin.setRole("admin");
//        }
//        else if (getUserByUsername(username) == null && shopper != null && role.equals("user")) new MyUser(username, password, shopper);
//        else return false;
//
//        return true;
//    }
//
//    public String getRole() {
//        return role;
//    }
//
//    public void setRole(String role) {
//        this.role = role;
//    }
//
//    @Override
//    public String getName() {
//        return username;
//    }
//
//    public Shopper getShopper() {
//        return shopper;
//    }
//}
