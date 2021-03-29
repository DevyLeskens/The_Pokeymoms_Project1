package domain;

public class Punt {
    private int xCoordinaat, yCoordinaat;


    public Punt(int xCoordinaat, int yCoordinaat) {
        setX(xCoordinaat);
        setY(yCoordinaat);
    }

    public int getX() {
        return this.xCoordinaat;
    }
    public void setX(int xCoordinaat) {
        this.xCoordinaat = xCoordinaat;
    }

    public int getY() {
        return this.yCoordinaat;
    }

    public void setY(int yCoordinaat){
        this.yCoordinaat = yCoordinaat;
    }

    public boolean equals(Object punt){
        if (punt == null) {
            return false;
        }
        return this.xCoordinaat == ((Punt) punt).getX() && this.yCoordinaat == ((Punt) punt).getY();
    }


    public String toString() {
        return "(" + this.xCoordinaat + ", " + this.yCoordinaat + ")";
    }
}
