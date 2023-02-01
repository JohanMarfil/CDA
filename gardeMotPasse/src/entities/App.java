package entities;

import java.io.Serializable;

public class App implements Serializable {

    private static int cpt = 1;
    private int id;
    private String appName;
    private String userName;
    private String password;

    public App(){

    }

    public App(String appName,String userName,String password){
        this.id = cpt++;
        this.appName = appName;
        this.userName = userName;
        this.password = password;
    }


    @Override
    public String toString() {
        return "Pour l'application : "+ this.appName+", \nnom utilisateur -> "+this.userName+"\nmot de passe -> "+this.password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
