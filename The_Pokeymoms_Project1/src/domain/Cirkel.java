package domain;

import javafx.scene.layout.Pane;
import javafx.scene.paint.*;
import javafx.scene.shape.*;

public class Cirkel extends Vorm implements Drawable{
    private Punt middelpunt;
    private int radius;

    public Cirkel(Punt punt, int radius){
        super(Color.rgb(0, 0, 0));
        setMiddelPunt(punt);
        setRadius(radius);
    }

    public Cirkel(Color kleur, Punt punt, int radius) {
        super(kleur);
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

    @Override
    public boolean equals(Object cirkel) {
        if(!(cirkel instanceof Cirkel)){
            return false;
        }

        if (cirkel == null) {
            return false;
        }
        return ((Cirkel) cirkel).getRadius() == this.radius && ((Cirkel) cirkel).getMiddelpunt() == this.middelpunt;
    }

    @Override
    public String toString() {
        return ("Cirkel met middelpunt (" + middelpunt.getX() + "," + middelpunt.getY() + ") en straal " + getRadius());
    }

    @Override
    public Omhullende getOmhullende() {
        return new Omhullende(new Punt((this.getMiddelpunt().getX()-this.getRadius()),(this.getMiddelpunt().getY()-this.getRadius())),this.getRadius()*2,this.getRadius()*2);
    }

    @Override
    public void teken(Pane root) {

        Circle cirkel = new Circle(getMiddelpunt().getX(), getMiddelpunt().getY(), getRadius());
        cirkel.setFill(getKleur());
        cirkel.setStroke(Color.BLACK);
        root.getChildren().add(cirkel);
    }
}
