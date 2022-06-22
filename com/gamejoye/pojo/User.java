package com.gamejoye.pojo;

public class User {


    final int IsAdmin_Default = 0;
    int id;
    String name;
    String password;
    int is_Admin = IsAdmin_Default;

    public User(){

    }
    public User(String name,String password){
        this.name = name;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAdmin() {
        return is_Admin;
    }

    public void setAdmin(int admin) {
        is_Admin = admin;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
