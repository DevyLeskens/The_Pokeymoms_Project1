package domain;

public class Rechthoek extends Vorm {
    private int breedte;
    private int hoogte;
    private Punt linkerBovenhoek;

    public Rechthoek(Punt linkerBovenhoek, int vBreedte, int vHoogte) {
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

    public String toString() {
        return this.getClass().getSimpleName() + ": linkerbovenhoek: " + this.linkerBovenhoek.toString() + " - breedte: " + this.breedte + " - hoogte: " + this.hoogte;
    }

    public String getOmhullende(Omhullende omhullende) {
        if (omhullende.getLinkerBovenhoek() != this.getLinkerBovenhoek() ||
                omhullende.getBreedte() != this.getBreedte() ||
                omhullende.getHoogte() != this.getHoogte()) {
            throw new DomainException("De rechthoek is niet gelijk aan de omhullende rechthoek.");
        }
        return omhullende.toString() + "\n" + this.toString();
    }
}
