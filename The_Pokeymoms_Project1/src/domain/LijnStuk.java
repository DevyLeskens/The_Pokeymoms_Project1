package domain;

public class LijnStuk extends Vorm {
    private Punt startPunt;
    private Punt eindPunt;

    public LijnStuk(Punt vStart, Punt vEind) {
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
        if (lijnstuk == null) {
            return false;
        }
        return (((LijnStuk) lijnstuk).getStartPunt() == this.startPunt && ((LijnStuk) lijnstuk).getEindPunt()
                == this.eindPunt) || (((LijnStuk) lijnstuk).getStartPunt() == this.eindPunt && ((LijnStuk) lijnstuk).getEindPunt() == this.startPunt);
    }

    public String toString() {
        return "Lijn: startpunt: " + startPunt.toString() + " - eindpunt: " + eindPunt.toString();
    }
}
