package entities;

public class Case {
    private static int cpt = 1;
    private int id;
    private int numCellule;
    private boolean personnage = false;
    private boolean topWall = true;
    private boolean rightWall = true;
    private boolean bottomWall = true;
    private boolean leftWall = true;

    public Case(){
        this.id = cpt++;
        this.numCellule = this.id;
        if(this.id==1){
            this.personnage=true;
        }
    }

    public boolean isPersonnage() {
        return personnage;
    }

    public void setPersonnage(boolean personnage) {
        this.personnage = personnage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumCellule() {
        return numCellule;
    }

    public void setNumCellule(int numCellule) {
        this.numCellule = numCellule;
    }

    public boolean isTopWall() {
        return topWall;
    }

    public void setTopWall(boolean topWall) {
        this.topWall = topWall;
    }

    public boolean isRightWall() {
        return rightWall;
    }

    public void setRightWall(boolean rightWall) {
        this.rightWall = rightWall;
    }

    public boolean isBottomWall() {
        return bottomWall;
    }

    public void setBottomWall(boolean bottomWall) {
        this.bottomWall = bottomWall;
    }

    public boolean isLeftWall() {
        return leftWall;
    }

    public void setLeftWall(boolean leftWall) {
        this.leftWall = leftWall;
    }
}
