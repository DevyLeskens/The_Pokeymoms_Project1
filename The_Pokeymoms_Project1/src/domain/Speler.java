package domain;

public class Speler {
    private String naam;
    private int score;

    public Speler(String naam) {
        setNaam(naam);
        setScore(0);
    }

    private void setNaam(String naam) {
        if (naam == null || naam.trim().isEmpty()) {
            throw new DomainException("Naam mag niet leeg zijn");
        }
        this.naam = naam;
    }

    private void setScore(int score) {
        if (score < 0) {
            throw new DomainException("Score kan niet lager dan 0 zijn.");
        }
        this.score = score;
    }

    public String getNaam() {
        return this.naam;
    }

    public int getScore() {
        return this.score;
    }

    public void addToScore(int score) {
        if ((this.score + score) < 0) {
            throw new DomainException("Score kan niet lager dan 0 zijn.");
        }

        this.score += score;
    }

    public boolean equals(Object speler) {
        if (speler == null) {
            return false;
        }
        return this.naam.equalsIgnoreCase(((Speler) speler).getNaam()) && this.score == ((Speler) speler).getScore();
    }

    public String toString() {
        return this.naam + " heeft als score " + this.score;
    }
}
