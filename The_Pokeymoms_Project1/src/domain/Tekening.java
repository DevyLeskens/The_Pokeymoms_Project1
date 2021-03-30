package domain;
import javafx.scene.layout.Pane;
import java.util.ArrayList;

public class Tekening implements Drawable {
    private String naam;
    private ArrayList<Vorm> vormen;
    public static final int MIN_X = 0;
    public static final int MIN_Y = 0;
    public static final int MAX_X = 399;
    public static final int MAX_Y = 399;

    public Tekening(String vNaam) {
        vormen = new ArrayList<>();
        setNaam(vNaam);
    }

    public void voegToe(Vorm vorm) {
        if (bevat(vorm)) {
            throw new DomainException("Vorm bestaat al in de lijst met vormen.");
        }
        vormen.add(vorm);
    }

    public static boolean isValidNaam(String naam) {
        return !naam.isBlank();
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        if (naam == null || naam.isBlank()) {
            throw new DomainException("Naam kan niet leeg zijn.");
        }
        this.naam = naam;
    }

    public Vorm getVorm(int index) {
        if (index > vormen.size() - 1) {
            throw new DomainException("de index is te groot voor deze lijst");
        }
        return vormen.get(index);
    }

    public int getAantalVormen() {
        return vormen.size();
    }

    public void verwijder(Vorm vorm) {
        if (!bevat(vorm)) {
            throw new DomainException("Deze vorm bestaat niet in de lijst met vormen");
        }
        vormen.remove(vorm);
    }

    public boolean bevat(Vorm vorm) {
        return vormen.contains(vorm);
    }

    public boolean equals(Object tekening) {
        if (tekening == null) {
            return false;
        }
        int aantal = 0;
        if (((Tekening) tekening).getAantalVormen() == this.getAantalVormen()) {
            for (int i = 0; i != ((Tekening) tekening).getAantalVormen(); i++) {
                for (int j = 0; j != ((Tekening) tekening).getAantalVormen(); j++) {
                    if (((Tekening) tekening).getVorm(i) == this.getVorm(j)) {
                        aantal++;
                    }
                }
            }
            return aantal == this.getAantalVormen();
        }
        return false;
    }

    public String toString() {
        return this.getClass().getSimpleName() + ": naam: " + this.getNaam();
    }

    @Override
    public void teken(Pane root) {
        for (Vorm vorm: vormen) {
            vorm.teken(root);

        }
    }
}
