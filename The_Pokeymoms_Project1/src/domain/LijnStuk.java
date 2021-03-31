package domain;

import javafx.scene.layout.Pane;
import javafx.scene.paint.*;
import javafx.scene.shape.*;


public class LijnStuk extends Vorm {
    private Punt startPunt;
    private Punt eindPunt;
    private Punt linksbovenhoek;

    public LijnStuk(Punt vStart, Punt vEind) {
        super(Color.rgb(0, 0, 0));
        setStartEnEindPunt(vStart, vEind);
    }

    public LijnStuk(Color kleur, Punt vStart, Punt vEind){
        super(kleur);
        setStartEnEindPunt(vStart, vEind);
    }

    private void setStartEnEindPunt(Punt vStart, Punt vEind) {
        if (vStart == null) {
            throw new DomainException("Startpunt mag niet leeg zijn");
        }
        if (vEind == null) {
            throw new DomainException("Eindpunt mag niet leeg zijn");
        }
        if (vStart.equals(vEind)){
            throw new DomainException("Startpunt en eindpunt mogen niet aan elkaar gelijk zijn");
        }
        this.startPunt = vStart;
        this.eindPunt = vEind;
    }

    public Punt getStartPunt() {
        return this.startPunt;
    }

    public Punt getEindPunt() {
        return this.eindPunt;
    }

    public boolean equals(Object lijnstuk) {
        if(!(lijnstuk instanceof LijnStuk)){
            return false;
        }

        if (lijnstuk == null) {
            return false;
        }
        return (((LijnStuk) lijnstuk).getStartPunt() == this.startPunt && ((LijnStuk) lijnstuk).getEindPunt()
                == this.eindPunt) || (((LijnStuk) lijnstuk).getStartPunt() == this.eindPunt && ((LijnStuk) lijnstuk).getEindPunt() == this.startPunt);
    }

    public String toString() {
        return "Lijn: startpunt: " + startPunt.toString() + " - eindpunt: " + eindPunt.toString();
    }

    @Override
    public Omhullende getOmhullende(){
        int breedte = eindPunt.getX() - startPunt.getX();
        int hoogte = eindPunt.getY() - startPunt.getY();
        if(startPunt.getY() < eindPunt.getY()) {
            linksbovenhoek = startPunt;
        } else {
            linksbovenhoek = new Punt(startPunt.getX(), startPunt.getY() - hoogte);
        }
        Omhullende omhullende = new Omhullende(linksbovenhoek, breedte, hoogte);

        return omhullende;
    }
    @Override
    public void teken(Pane root){
        Line lijn = new Line(getStartPunt().getX(), getStartPunt().getY(), getEindPunt().getX(), getEindPunt().getY());
        lijn.setStrokeWidth(5);
        root.getChildren().add(lijn);
    }

}
