package domain;

public class Cirkel extends Vorm {
    private Punt middelpunt;
    private int radius;

    public Cirkel(Punt punt, int radius) {
        setMiddelPunt(punt);
        setRadius(radius);
    }

    private void setMiddelPunt(Punt punt) {
        if (punt == null) {
            throw new DomainException("Kan niet leeg zijn");
        }
        this.middelpunt = punt;
    }

    private void setRadius(int radius) {
        if (radius <= 0) {
            throw new DomainException("radius mag niet kleiner of gelijk aan 0 zijn");
        }
        this.radius = radius;
    }

    public Punt getMiddelpunt() {
        return this.middelpunt;
    }

    public int getRadius() {
        return this.radius;
    }

    public boolean equals(Object cirkel) {
        if (cirkel == null) {
            return false;
        }
        return ((Cirkel) cirkel).getRadius() == this.radius && ((Cirkel) cirkel).getMiddelpunt() == this.middelpunt;
    }

    public String toString() {
        return ("Cirkel met middelpunt (" + middelpunt.getX() + "," + middelpunt.getY() + ") en straal " + getRadius());
    }


}
