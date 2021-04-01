package domain;

import javafx.scene.layout.Pane;
import javafx.scene.paint.*;
import javafx.scene.shape.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Driehoek extends Vorm implements Drawable{
    Punt hoekPunt1;
    Punt hoekPunt2;
    Punt hoekPunt3;

    public Driehoek(Punt punt1, Punt punt2, Punt punt3) {
        super(Color.rgb(0, 0, 0));
        if (punt1 == null || punt2 == null || punt3 == null) {
            throw new DomainException("Mag niet leeg zijn");
        }
        if (punt1.equals(punt2) || punt2.equals(punt3) || punt1.equals(punt3)) {
            throw new DomainException("punten mogen niet samenvallen");
        }
        if (liggenOp1Lijn(punt1, punt2, punt3)) {
            throw new DomainException("punten mogen niet op een lijn liggen");
        }
        setHoekPunt1(punt1);
        setHoekPunt2(punt2);
        setHoekPunt3(punt3);
    }

    public Driehoek(Color kleur, Punt punt1, Punt punt2, Punt punt3) {
        super(kleur);
        if (punt1 == null || punt2 == null || punt3 == null) {
            throw new DomainException("Mag niet leeg zijn");
        }
        if (punt1.equals(punt2) || punt2.equals(punt3) || punt1.equals(punt3)) {
            throw new DomainException("punten mogen niet samenvallen");
        }
        if (liggenOp1Lijn(punt1, punt2, punt3)) {
            throw new DomainException("punten mogen niet op een lijn liggen");
        }
        setHoekPunt1(punt1);
        setHoekPunt2(punt2);
        setHoekPunt3(punt3);
    }

    private boolean liggenOp1Lijn(Punt punt1, Punt punt2, Punt punt3) {
        if (punt1 == null || punt2 == null || punt3 == null) {
            throw new DomainException("Punt is null");
        }
        int x1 = punt1.getX();
        int x2 = punt2.getX();
        int x3 = punt3.getX();
        int y1 = punt1.getY();
        int y2 = punt2.getY();
        int y3 = punt3.getY();
        if ((x2 - x1) * (y3 - y1) == (x3 - x1) * (y2 - y1)) {
            return true;
        }
        return false;
    }

    public Punt getHoekPunt1() {
        return this.hoekPunt1;
    }

    public Punt getHoekPunt2() {
        return this.hoekPunt2;
    }

    public Punt getHoekPunt3() {
        return this.hoekPunt3;
    }

    public void setHoekPunt1(Punt hoekPunt) {
        if (hoekPunt == null) {
            throw new DomainException("Mag niet leeg zijn");
        }
        if (hoekPunt == hoekPunt2 || hoekPunt == hoekPunt3) {
            throw new DomainException("Mogen niet samenvallen");
        }
        this.hoekPunt1 = hoekPunt;
    }

    public void setHoekPunt2(Punt hoekPunt) {
        if (hoekPunt == null) {
            throw new DomainException("Mag niet leeg zijn");
        }
        if (hoekPunt == hoekPunt1 || hoekPunt == hoekPunt3) {
            throw new DomainException("Mogen niet samenvallen");
        }
        this.hoekPunt2 = hoekPunt;
    }

    public void setHoekPunt3(Punt hoekPunt) {
        if (hoekPunt == null) {
            throw new DomainException("Mag niet leeg zijn");
        }
        if (hoekPunt == hoekPunt1 || hoekPunt == hoekPunt2) {
            throw new DomainException("Mogen niet samenvallen");
        }
        this.hoekPunt3 = hoekPunt;
    }

    @Override
    public boolean equals(Object driehoek) {
        if (driehoek == null) {
            return false;
        }
        if (driehoek instanceof Driehoek) {
            if (this.getHoekPunt1() == ((Driehoek) driehoek).getHoekPunt1() || this.getHoekPunt2() == ((Driehoek) driehoek).getHoekPunt1() || this.getHoekPunt3() == ((Driehoek) driehoek).getHoekPunt1()) {
                if (this.getHoekPunt1() == ((Driehoek) driehoek).getHoekPunt2() || this.getHoekPunt2() == ((Driehoek) driehoek).getHoekPunt2() || this.getHoekPunt3() == ((Driehoek) driehoek).getHoekPunt2()) {
                    return this.getHoekPunt1() == ((Driehoek) driehoek).getHoekPunt3() || this.getHoekPunt2() == ((Driehoek) driehoek).getHoekPunt3() || this.getHoekPunt3() == ((Driehoek) driehoek).getHoekPunt3();
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return ("Driehoek: hoekpunt1: " + this.getHoekPunt1() + " - hoekpunt2: " + this.getHoekPunt2() + " - hoekpunt3: " + this.getHoekPunt3());
    }

    @Override
    public Omhullende getOmhullende() {
        List<Integer> xVal = Arrays.asList(hoekPunt1.getX(), hoekPunt2.getX(), hoekPunt3.getX());
        List<Integer> yVal = Arrays.asList(hoekPunt1.getY(), hoekPunt2.getY(), hoekPunt3.getY());
        int b = Collections.max(xVal) - Collections.min(xVal);
        int h = Collections.max(yVal) - Collections.min(yVal);
        return new Omhullende(new Punt(Collections.min(xVal), Collections.min(yVal)), b, h);
    }


    @Override
    public void teken(Pane root) {
        Polyline drie = new Polyline();
        drie.setFill(getKleur());
        drie.setStroke(Color.BLACK);
        drie.getPoints().addAll(new Double[]{(double) getHoekPunt1().getX(), (double) getHoekPunt1().getY(), (double) getHoekPunt2().getX(), (double) getHoekPunt2().getY(), (double) getHoekPunt3().getX(), (double) getHoekPunt3().getY()});
        root.getChildren().add(drie);
    }
}
