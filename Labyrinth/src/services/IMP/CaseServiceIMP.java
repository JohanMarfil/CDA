package services.IMP;

import entities.Case;
import services.ICaseService;

import java.util.ArrayList;

public class CaseServiceIMP implements ICaseService {
    @Override
    public ArrayList<Case> createDefaultMaze(int longueur, int hauteur) {
        ArrayList<Case> maze = new ArrayList<>();
        for(int i = 1;i<= longueur*hauteur;i++){
            maze.add(new Case());
        }
        return maze;
    }
}
