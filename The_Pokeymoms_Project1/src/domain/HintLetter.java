package domain;

public class HintLetter {
    private char letter;
    private boolean isGeraden;

    public HintLetter(char letter) {
        this.letter = letter;
        isGeraden = false;
    }

    public char getLetter() {
        return this.letter;
    }

    public boolean raad(char letter) {
        if (Character.toUpperCase(letter) == Character.toUpperCase(this.letter)) {
            if (isGeraden) {
                return false;
            }
            isGeraden = true;
            return true;
        }
        return false;
    }

    public char toChar() {
        if (isGeraden) {
            return getLetter();
        }
        return '_';
    }

    public boolean isGeraden() {
        return isGeraden;
    }
}
