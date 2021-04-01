package domain;

import javafx.scene.paint.Color;

public abstract class Vorm implements Drawable{
    private Color kleur;
    private boolean isZichtbaar;

    public Vorm(Color kleur){
        setKleur(kleur);
        this.isZichtbaar = false;
    }

    public Color getKleur(){
        return this.kleur;
    }

    private void setKleur(Color kleur){
        if(kleur == null){
            this.kleur = Color.WHITE;
        }
        this.kleur = kleur;
    }

    public boolean isZichtbaar(){
        return this.isZichtbaar;
    }

    public void setZichtbaar(boolean zichtbaar){
        this.isZichtbaar = zichtbaar;
    }

    public abstract Omhullende getOmhullende();

    public abstract String toString();
}
