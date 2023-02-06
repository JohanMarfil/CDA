package views;

import entities.Case;

import java.util.ArrayList;

public class MazeView {

    public void showMaze(ArrayList<Case> maze,int longueur,int hauteur){
        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < longueur; j++) {
                System.out.print("******");
            }
            System.out.println("");
            for (int j = 0; j < longueur; j++) {
                if(maze.get(i*j).isLeftWall() && maze.get(i*j).isRightWall()){
                    if(i==0 && j==0){
                        System.out.print("| P  |");
                    } else if (i+1 == hauteur && j+1 ==longueur) {
                        System.out.print("|-><-|");
                    } else {
                        System.out.print("|    |");
                    }

                }

                if(!maze.get(i*j).isLeftWall() && maze.get(i*j).isRightWall()){
                    if(i==0 && j==0){
                        System.out.print("  P  |");
                    }else if (i+1 == hauteur && j+1 ==longueur) {
                        System.out.print(" -><-|");
                    } else {
                        System.out.print("     |");
                    }
                }
                if(maze.get(i*j).isLeftWall() && !maze.get(i*j).isRightWall()){
                    if(i==0 && j==0){
                        System.out.print("| P   ");
                    }else if (i+1 == hauteur && j+1 ==longueur) {
                        System.out.print("|-><- ");
                    }else {
                        System.out.print("|     ");
                    }
                }
            }
            System.out.println("");
            for (int j = 0; j < longueur; j++) {
                System.out.print("******");
            }
            System.out.println("");
        }

    }

}
