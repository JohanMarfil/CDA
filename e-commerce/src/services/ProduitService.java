package services;

import entities.Produit;

import java.util.ArrayList;
import java.util.Scanner;

public interface ProduitService {

    public void addProduit();
    public void suppProduit();

    public void modifProduit();
    public void displayAllProduit();
    public void addProduitInPanier();
    public void modifPanier();
    public void validatePanier();
    public void displayTicketCaisse(String adresse, String nom);

    public void stockage();
    public void recupStockage();
}
