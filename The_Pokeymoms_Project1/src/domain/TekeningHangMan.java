package domain;

import java.util.ArrayList;

public class TekeningHangMan extends Tekening {
    public TekeningHangMan() {
        super("Hangman");
        Vorm galgBodem = new Rechthoek(new Punt(10, 350), 300, 40);
        galgBodem.setZichtbaar(true);
        Vorm galgStaaf = new LijnStuk(new Punt(160, 350), new Punt(160, 50));
        galgStaaf.setZichtbaar(true);
        Vorm hangbar = new LijnStuk(new Punt(160, 50), new Punt(280, 50));
        hangbar.setZichtbaar(true);
        Vorm koord = new LijnStuk(new Punt(280,50), new Punt(280,100));//altijd zichtbaar
        koord.setZichtbaar(true);
        Vorm hoofd = new Cirkel(new Punt(280,125),25); //zichtbaar na 1 fout
        Vorm oogLinks = new Cirkel(new Punt(270,118),2); //Zichtbaar na 2 fouten
        Vorm oogRechts = new Cirkel(new Punt(290,118),2);//...
        Vorm neus = new Cirkel(new Punt(280,128),2);
        Vorm mond = new LijnStuk(new Punt(270,138),new Punt(290,138));
        Vorm lijf = new LijnStuk(new Punt(280,150), new Punt(280,250));
        Vorm beenLinks = new LijnStuk(new Punt(280,250), new Punt(240,310));
        Vorm beenRechts = new LijnStuk(new Punt(280,250), new Punt(320,310));
        Vorm voetLinks = new Cirkel(new Punt(240,310),5);
        Vorm voetRechts = new Cirkel(new Punt(320,310),5);
        Vorm armLinks = new LijnStuk(new Punt(280,200),new Punt(230,170));
        Vorm armRechts = new LijnStuk(new Punt(280,200), new Punt(330,170));
        Vorm handLinks = new Cirkel(new Punt(230,170),5);
        Vorm handRechts = new Cirkel(new Punt(330,170),5);

        voegToe(galgBodem);
        voegToe(galgStaaf);
        voegToe(hangbar);
        voegToe(koord);
        voegToe(hoofd);
        voegToe(oogLinks);
        voegToe(oogRechts);
        voegToe(neus);
        voegToe(mond);
        voegToe(lijf);
        voegToe(beenLinks);
        voegToe(beenRechts);
        voegToe(voetLinks);
        voegToe(voetRechts);
        voegToe(armLinks);
        voegToe(armRechts);
        voegToe(handLinks);
        voegToe(handRechts);
    }

    public int getAantalOnzichtbaar(){
        int i = 0;
        int zichtbaar = 0;
        while (i < this.getAantalVormen()){
            if (this.getVorm(i).isZichtbaar()){
                zichtbaar++;
                i++;
            }
        }
        return this.getAantalVormen() - zichtbaar;
    }

    public void zetVolgendeZichtbaar(){
        int i = 0;
        boolean stop = false;
        while (!stop && i < this.getAantalVormen()){
            if (!this.getVorm(i).isZichtbaar()){
                this.getVorm(i).setZichtbaar(true);
                stop = true;
            }
        }
    }

    @Override
    public void voegToe(Vorm vorm){
        super.voegToe(vorm);
    }

    @Override
    public void verwijder(Vorm vorm){
        super.verwijder(vorm);
    }
}
