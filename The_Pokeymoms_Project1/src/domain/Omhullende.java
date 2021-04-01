package domain;

public class Omhullende {
    private int hoogte, breedte;
    private Punt linkerbovenhoek;

    public Omhullende(Punt linkerbovenhoek, int breedte, int hoogte) {
        setLinkerBovenhoek(linkerbovenhoek);
        setHoogte(hoogte);
        setBreedte(breedte);

    }

    public Punt getLinkerBovenhoek() {
        return this.linkerbovenhoek;
    }

    public int getHoogte() {
        return hoogte;
    }

    public int getBreedte() {
        return breedte;
    }

    private Punt setLinkerBovenhoek(Punt linkerbovenhoek) {
        if (linkerbovenhoek == null) {
            throw new DomainException("Mag niet null zijn.");
        }
        return this.linkerbovenhoek = linkerbovenhoek;
    }

    private int setHoogte(int hoogte) {
        if (hoogte < 0) {
            throw new DomainException("De hoogte mag niet negatief zijn.");
        }
        return this.hoogte = hoogte;
    }

    private int setBreedte(int breedte) {
        if (breedte < 0) {
            throw new DomainException("De breedte mag niet negatief zijn");
        }
        return this.breedte = breedte;
    }

    public boolean equals(Object omhullende) {
        if (omhullende == null) {
            return false;
        }
         return this.linkerbovenhoek == (((Omhullende) omhullende).getLinkerBovenhoek()) && this.hoogte == (((Omhullende) omhullende).getHoogte())
                && this.breedte == (((Omhullende) omhullende).getBreedte());
    }

    public String toString(){
        return  this.getClass().getSimpleName() + ": (" + linkerbovenhoek.getX() + ", " + linkerbovenhoek.getY() + ") - " + breedte + " - " + hoogte;
    }

    public int getMinimumX() {
        return linkerbovenhoek.getX();
    }

    public int getMinimumY() {
        return linkerbovenhoek.getY();
    }

    public int getMaximumX() {
        return linkerbovenhoek.getX() + breedte;
    }

    public int getMaximumY() {
        return linkerbovenhoek.getY() + hoogte;
    }
}
