package imp;

import entities.Produit;
import services.ProduitService;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ProduitServiceIMP implements ProduitService {

    public static ArrayList<Produit> panierClient = new ArrayList<>();
    public static ArrayList<Produit> listProduits = new ArrayList<>();

    public static Scanner sc = new Scanner(System.in);


    @Override
    public void addProduit() {

        System.out.print("Nom du produit : ");
        String name = sc.nextLine();
        System.out.print("Prix du produit (ex : 15.99) : ");
        double price = Double.parseDouble(sc.nextLine());
        int id = this.listProduits.size()+1;
        Produit currentProduit = new Produit(id,name,price);
        this.listProduits.add(currentProduit);

    }

    @Override
    public void suppProduit() {
        if(this.listProduits.size() == 0){
            System.out.println("ERROR : Aucune produit a supprimer");
            return;
        }
        System.out.print("Quelle produit souhaitez vous supprimer (id) : ");
        String id = sc.nextLine();

        for (Produit produit: this.listProduits) {
            if(produit.getId() == Integer.parseInt(id)){
                this.listProduits.remove(this.listProduits.indexOf(produit));
                break;
            }
        }
    }

    @Override
    public void modifProduit() {
        if(this.listProduits.size() == 0){
            System.out.println("ERROR : Aucune produit a modifier");
            return;
        }
        System.out.print("Quelle produit souhaitez vous modifier (id) : ");
        String id = sc.nextLine();

        for (Produit produit: this.listProduits) {
            if(produit.getId() == Integer.parseInt(id)){
                this.listProduits.remove(produit);
                System.out.print("Nouveau nom -> ");
                produit.setNom(sc.nextLine());
                System.out.println("Nouveau prix ->");
                produit.setPrix(Double.parseDouble(sc.nextLine()));
                this.listProduits.add(produit);
            }
        }
    }

    @Override
    public void displayAllProduit() {
        for (Produit produit:this.listProduits) {
            System.out.println(produit);
        }
    }

    @Override
    public void addProduitInPanier() {
        if(this.listProduits.size() == 0){
            System.out.println("ERROR : Aucune produit a ajouter");
            return;
        }
        System.out.print("Quelle produit souhaitez vous ajouter a votre panier (id) : ");
        String id = sc.nextLine();

        for (Produit produit: this.listProduits) {
            if(produit.getId() == Integer.parseInt(id)){
                this.panierClient.add(produit);
                break;
            }
        }
    }

    @Override
    public void modifPanier() {
        String resp;
        this.afficherPanier();
        System.out.println("Quelle produit souhaitez vous modifier (ajout ou suppression) : ");
        String id = sc.nextLine();
        int respQuantite;
        do{
            System.out.println("Souhaitez vous en ajouter (1) ou en supprimer (2) : ");
            resp = sc.nextLine();

            switch (resp){
                case "1":
                    System.out.println("Combien souhaitez vous en ajouter ? ");
                    respQuantite = Integer.parseInt(sc.nextLine());
                    for (Produit produit: this.listProduits) {
                        if(produit.getId() == Integer.parseInt(id)){
                            for (int i = 0; i < respQuantite; i++) {
                                this.panierClient.add(produit);
                            }
                            break;
                        }
                    }
                    break;
                case "2":

                    for (Produit produit: this.listProduits) {
                        if(produit.getId() == Integer.parseInt(id)){
                            this.panierClient.remove(produit);
                        }
                    }
                    break;
                default:
                    System.out.println("ERROR mauvais choix");
                    break;
            }
        }while(!resp.equalsIgnoreCase("1") && !resp.equalsIgnoreCase("2"));




    }

    private void afficherPanier() {
        System.out.println("Votre panier : ");
        for (Produit produit:this.panierClient) {
            System.out.println(produit);
        }
    }

    @Override
    public void validatePanier() {
        System.out.println("Valisation panier -> paiement en cours...");
        System.out.println("Adresse : ");
        String adresse = sc.nextLine();
        System.out.println("Nom : ");
        String nom = sc.nextLine();

        System.out.println("Paiment accepter");
        displayTicketCaisse(adresse,nom);


    }

    @Override
    public void displayTicketCaisse(String adresse, String nom) {
        System.out.println("Ticket Caisse de "+nom+"habitant a "+adresse);
        double somme = 0d;
        for (Produit produit:this.panierClient){
            System.out.println(produit);
            somme += produit.getPrix();
        }
        System.out.println("PRIX TOTAL (ht) -> "+somme);
        System.out.println("TVA -> 20%");
        System.out.println("PRIX TOTAL (ttc) -> "+(somme*1.2));

    }

    public void stockage() {
        ObjectOutputStream oos;
        try {
            FileOutputStream fichier = new FileOutputStream("produit.ser");
            oos = new ObjectOutputStream(fichier);
            oos.writeObject(this.listProduits);
            oos.flush();
            oos.close();
        } catch (final java.io.IOException e) {
            e.printStackTrace();
        }
    }

    public void recupStockage() {
        ObjectInputStream oos;
        try {
            FileInputStream fichier = new FileInputStream("produit.ser");
            oos = new ObjectInputStream(fichier);
            this.listProduits =(ArrayList<Produit>) oos.readObject();
            oos.close();
        } catch (final java.io.IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
