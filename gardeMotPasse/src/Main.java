import entities.App;
import services.AppService;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AppService appService = new AppService();
        ArrayList<App> appList = new ArrayList<>();
        appList = appService.recupStockage(appList);
        String resp;
        String userName;
        String password;
        int cptLife = 3;
        do{
            if(cptLife == 0){
                System.out.println("Trop d'erreur.... Fermeture du programme...");
                System.exit(0);
            }
            System.out.println(cptLife+" Vie Restantes");
            System.out.print("Nom utilisateur : ");
            userName = appService.sc.nextLine();
            System.out.print("Mot de passe :");
            password = appService.sc.nextLine();
            if(!userName.equalsIgnoreCase("zobat") || !password.equalsIgnoreCase("0000")){
                cptLife--;
            }
        }while(!userName.equalsIgnoreCase("zobat") || !password.equalsIgnoreCase("0000"));
        do {
            System.out.println("MENU");
            System.out.println("1 - Ajouter les logs d'une application");
            System.out.println("2 - Rechercher une application");
            System.out.println("3 - Afficher toutes les applications.");
            System.out.println("0 - Pour quitter ");
            System.out.print("Votre CHOIX : ");
            resp = appService.sc.nextLine();

            switch (resp) {
                case "1":
                    appService.addApp(appList);
                    break;
                case "2":
                    System.out.println("2");
                    appService.searchApp(appList);
                    break;
                case "3":
                    System.out.println("3");
                    appService.displayAllApp(appList);
                    break;
                case "0":
                    appService.stockage(appList);
                    System.out.println("Au revoir");
                    break;
                default:
                    System.out.println("Veuillez saisir une donner valide");
                    break;

            }
        }while(!resp.equalsIgnoreCase("0"));


    }
}