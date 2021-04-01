package domain;

import java.util.ArrayList;

public class WoordenLijst {
    private ArrayList<HintWoord> woorden;

    public WoordenLijst(){
        woorden = new ArrayList<HintWoord>();
    }

    public void voegToe(String woord){
        if(woord == null || woord.isEmpty()){
            throw new DomainException("woord moet bestaan");
        }

        for(HintWoord word: woorden){
            if(woord.equals(word.getWoord())){
                throw new DomainException("woord zit al in lijst");
            }
        }
        HintWoord woord1 = new HintWoord(woord);
        woorden.add(woord1);
    }


    public int getAantalWoorden() {
        return this.woorden.size();
    }

    public HintWoord getRandomWoord() {
        if(woorden.isEmpty()){
            return null;
        }

        int random = (int) Math.floor(Math.random()*getAantalWoorden());
        return woorden.get(random);
    }
}
