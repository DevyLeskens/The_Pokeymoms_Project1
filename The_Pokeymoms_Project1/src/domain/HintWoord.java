package domain;

public class HintWoord {
    private HintLetter[] hintwoord;

    public HintWoord(String woord) {
        setWoord(woord);
    }

    public void setWoord(String woord){
        if(woord == null){
            throw new DomainException("Woord kan niet null zijn");
        }
        if (woord.isBlank()){
            throw new DomainException("Woord mag niet leeg zijn");
        }
        this.hintwoord = new HintLetter[woord.length()];
        for (int i = 0; i != woord.length(); i++){
            this.hintwoord[i] = new HintLetter(woord.charAt(i));
        }
    }

    public String getWoord(){
        String result = "";
        for (HintLetter c: this.hintwoord){
            result += c.getLetter();
        }
        return result;
    }

    public boolean raad(char letter){
        boolean result = false;
        for (HintLetter c: hintwoord){
            if (c.raad(letter)){
                result = true;
            }
        }
        return result;
    }

    public boolean isGeraden(){
        int result = 0;
        for (HintLetter c: this.hintwoord){
            if (c.isGeraden()){
                result++;
            }
        }
        return result == hintwoord.length;
    }

    public String toString(){
        String result = "";
        for (int i = 0; i != this.hintwoord.length; i++){
            if (i != this.hintwoord.length - 1){
                result += hintwoord[i].toChar() + " ";
            } else {
                result += hintwoord[i].toChar();
            }
        }
        return result;
    }
}
