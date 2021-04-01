package domain;

public class HangMan {
    private Speler speler;
    private TekeningHangMan tekeningHangMan;
    private WoordenLijst woordenLijst;
    private HintWoord hintWoord;
    private boolean gewonnen;

    public HangMan(Speler speler, WoordenLijst woordenLijst) {
        setSpeler(speler);
        setWoordenLijst(woordenLijst);
        this.hintWoord = this.woordenLijst.getRandomWoord();
        this.gewonnen = false;
        this.tekeningHangMan = new TekeningHangMan();
        this.hintWoord = (woordenLijst.getRandomWoord());
    }

    private void setSpeler(Speler speler) {
        if (speler == null) {
            throw new DomainException("Speler kan niet null zijn");
        }
        this.speler = speler;
    }

    private void setWoordenLijst(WoordenLijst woordenLijst) {
        if (woordenLijst == null || woordenLijst.getAantalWoorden() == 0) {
            throw new DomainException("Woordenlijst kan niet null of leeg zijn");
        }
        this.woordenLijst = woordenLijst;
    }

    public Speler getSpeler() {
        return this.speler;
    }

    public TekeningHangMan getTekening() {
        return this.tekeningHangMan;
    }

    public String getHint() {
        return hintWoord.toString();
    }

    public boolean isGameOver() {
        return this.tekeningHangMan.getAantalOnzichtbaar() == 0;
    }

    public boolean isGewonnen() {
        return this.hintWoord.isGeraden();
    }

    public boolean raad(char letter) {
        if (!hintWoord.raad(letter)) {
            tekeningHangMan.zetVolgendeZichtbaar();
        }
        return false;
    }
}
