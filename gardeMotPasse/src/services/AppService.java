package services;

import entities.App;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class AppService {

    public Scanner sc = new Scanner(System.in);

    public ArrayList<App> addApp(ArrayList<App> appList) {

        System.out.println("Nom de l'application");
        String name = sc.nextLine();

        System.out.println("Nom d'utilisateur");
        String user = sc.nextLine();

        String car;
        boolean verif;
        do{
            verif = true;
            System.out.println("Nombre de caractère dans le mot de passe ? ");
            car = sc.nextLine();
            try{
                Integer.parseInt(car);
            }catch(Exception e){
                verif = false;
            }

        }while(!verif);

        System.out.println("Création mot de passe en cours....");

        String password = generatePassword(car);
        System.out.println(password);

        App currentApp = new App(name,user,password);
        appList.add(currentApp);


        return appList;
    }

    private String generatePassword(String car) {
        char ch;
        String password = "";
        Random ran = new Random();
        for (int i = 0; i < Integer.parseInt(car); i++) {
            ch = (char) (ran.nextInt(122+1-97)+97);
            if(ran.nextBoolean()){
                password += String.valueOf(ch).toUpperCase();
            } else {
                password += ch;
            }

        }
        return password;
    }

    public void displayAllApp(ArrayList<App> appList) {
        ArrayList<App> verifApp = new ArrayList<>();
        for (App app:appList) {
            if(verifIfDisplay(verifApp,app)){
                continue;
            }else{
                System.out.println("-"+app.getAppName());
                verifApp.add(app);
            }

        }
    }

    private boolean verifIfDisplay(ArrayList<App> verifApp, App app) {
        for (App appli:verifApp) {
            if(appli.getAppName().equalsIgnoreCase(app.getAppName())){
                return true;
            }
        }
        return false;
    }

    public void searchApp(ArrayList<App> appList) {
        System.out.println("Saisir le nom de l'application");
        String appName = sc.nextLine();

        for (App app:appList) {
            if(app.getAppName().contains(appName)){
                System.out.println("Pour l'application : "+app.getAppName());
                System.out.println("-> Nom d'utilisateur : "+app.getUserName());
                System.out.println("-> Mot de passe : "+app.getPassword());
                System.out.println("===============================================");
            }
        }
    }

    public void stockage(ArrayList<App> appList) {
        ObjectOutputStream oos;
        try {
            FileOutputStream fichier = new FileOutputStream("app.ser");
            oos = new ObjectOutputStream(fichier);
            oos.writeObject(appList);
            oos.flush();
            oos.close();
        } catch (final java.io.IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<App> recupStockage(ArrayList<App> appList) {
        ObjectInputStream oos;
        try {
            FileInputStream fichier = new FileInputStream("app.ser");
            oos = new ObjectInputStream(fichier);
            appList =(ArrayList<App>) oos.readObject();
            oos.close();
            return appList;
        } catch (final java.io.IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return appList;
    }
}
