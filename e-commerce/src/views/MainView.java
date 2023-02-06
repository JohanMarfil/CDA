package views;

import imp.ProduitServiceIMP;
import services.ProduitService;

import java.util.Scanner;

public class MainView {

    static Scanner sc = new Scanner(System.in);
    static ProduitService produitService = new ProduitServiceIMP();
    public void masterMenu(){
        produitService.recupStockage();
        String username;
        String password;
        do {
            System.out.print("Nom utilisateur : ");
            username = sc.nextLine();
            System.out.print("Mot de passe : ");
            password = sc.nextLine();

        }while((!username.equalsIgnoreCase("zobat") || !password.equalsIgnoreCase("0000")) &&
                (!username.equalsIgnoreCase("admin") || !password.equalsIgnoreCase("admin")));

        switch (username){
            case "admin":
                menuAdmin();
                break;
            default:
                menuUser();
                break;
        }
    }

    private void menuUser() {
        String resp;
        do {
            System.out.println("1- Affichage de tous les produits");
            System.out.println("2- Ajout d'un produit dans le panier (SearchById)");
            System.out.println("3- Modification panier");
            System.out.println("4- Valider panier");
            System.out.println("5- Déconnexion du compte");
            System.out.println("0- Quitter le programme");

            System.out.print("Votre choix : ");
            resp = sc.nextLine();

            switch (resp){
                case "1":
                    produitService.displayAllProduit();
                    break;
                case "2":
                    produitService.addProduitInPanier();
                    break;
                case "3":
                    produitService.modifPanier();
                    break;
                case "4":
                    produitService.validatePanier();
                    break;
                case "5":
                    System.out.println("DECONNEXION...");
                    masterMenu();
                    break;
                case "0":
                    produitService.stockage();
                    System.out.println("Au revoir");
                    break;
                default:
                    System.out.println("Veuillez sasisir un choix valide !");
                    break;
            }

        }while(!resp.equalsIgnoreCase("0"));
    }

    private void menuAdmin() {
        String resp;
        do {
            System.out.println("1- Ajout Produit");
            System.out.println("2- Supression Produit");
            System.out.println("3- Modification Produit");
            System.out.println("4- Déconnexion du compte");
            System.out.println("0- Quitter le programme");

            System.out.print("Votre choix : ");
            resp = sc.nextLine();

            switch (resp){
                case "1":
                    produitService.addProduit();
                    break;
                case "2":
                    produitService.suppProduit();
                    break;
                case "3":
                    produitService.modifProduit();
                    break;
                case "4":
                    System.out.println("DECONNEXION...");
                    masterMenu();
                    break;
                case "0":
                    produitService.stockage();
                    System.out.println("Au revoir");
                    break;
                default:
                    System.out.println("Veuillez sasisir un choix valide !");
                    break;
            }

        }while(!resp.equalsIgnoreCase("0"));
    }


}
