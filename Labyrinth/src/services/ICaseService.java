package services;

import entities.Case;

import java.util.ArrayList;

public interface ICaseService {

    public ArrayList<Case> createDefaultMaze(int longueur,int hauteur);
}
