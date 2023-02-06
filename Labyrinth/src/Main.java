import entities.Case;
import services.ICaseService;
import services.IMP.CaseServiceIMP;
import views.MazeView;

import java.util.ArrayList;

public class Main {

    public static MazeView mazeView = new MazeView();
    public static ICaseService caseService = new CaseServiceIMP();
    public static ArrayList<Case> maze = caseService.createDefaultMaze(6,3);
    public static void main(String[] args) {
        mazeView.showMaze(maze,6,3);
    }
}