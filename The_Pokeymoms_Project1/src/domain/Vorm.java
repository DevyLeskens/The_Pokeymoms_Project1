package domain;

import javafx.scene.paint.Color;

public abstract class Vorm implements Drawable{
    private Color kleur;


    public Vorm(Color kleur){
        setKleur(kleur);
    }

    public Color getKleur(){
        return this.kleur;
    }

    private void setKleur(Color kleur){
        if(kleur == null){
            throw new DomainException("Kan niet leeg zijn");
        }
        this.kleur = kleur;
    }

    public abstract Omhullende getOmhullende();

    public abstract String toString();
}
