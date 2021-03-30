package domain;

import javafx.scene.layout.Pane;
import javafx.scene.paint.*;
import javafx.scene.shape.*;

public class Rechthoek extends Vorm {
    private int breedte;
    private int hoogte;
    private Punt linkerBovenhoek;

    public Rechthoek(Punt linkerBovenhoek, int vBreedte, int vHoogte) {
        super(Color.rgb(0, 0, 0));
        setBreedte(vBreedte);
        setHoogte(vHoogte);
        setLinkerBovenhoek(linkerBovenhoek);
    }

    public int getBreedte() {
        return breedte;
    }

    private void setBreedte(int breedte) {
        if (breedte <= 0) {
            throw new DomainException("Breedte mag niet negatief zijn");
        }
        this.breedte = breedte;
    }

    public int getHoogte() {
        return hoogte;
    }

    private void setHoogte(int hoogte) {
        if (hoogte <= 0) {
            throw new DomainException("Hoogte mag niet negatief zijn");
        }
        this.hoogte = hoogte;
    }

    public Punt getLinkerBovenhoek() {
        return linkerBovenhoek;
    }

    private void setLinkerBovenhoek(Punt linkerBovenHoek) {
        if (linkerBovenHoek == null) {
            throw new DomainException("Linkerbovenhoek kan niet leeg zijn");
        }
        this.linkerBovenhoek = linkerBovenHoek;
    }

    public boolean equals(Object rechthoek) {
        if (rechthoek == null) {
            return false;
        }
        return this.linkerBovenhoek == (((Rechthoek) rechthoek).getLinkerBovenhoek()) && this.hoogte == (((Rechthoek) rechthoek).getHoogte())
                && this.breedte == (((Rechthoek) rechthoek).getBreedte());
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": linkerbovenhoek: " + this.linkerBovenhoek.toString() + " - breedte: " + this.breedte + " - hoogte: " + this.hoogte;
    }

    @Override
    public Omhullende getOmhullende() {
        if (getLinkerBovenhoek() != this.getLinkerBovenhoek() ||
                getBreedte() != this.getBreedte() ||
                getHoogte() != this.getHoogte()) {
            throw new DomainException("De rechthoek is niet gelijk aan de omhullende rechthoek.");
        }
        Omhullende omhullende = new Omhullende(linkerBovenhoek, breedte, hoogte);
        return omhullende;
    }

    @Override
    public void teken(Pane root) {
        Rectangle recht = new Rectangle(getLinkerBovenhoek().getX(), getLinkerBovenhoek().getY(), getBreedte(), getHoogte());
        recht.setFill(getKleur());
        recht.setStroke(Color.BLACK);
        root.getChildren().add(recht);
    }
}
