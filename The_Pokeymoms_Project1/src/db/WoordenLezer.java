package db;

import domain.WoordenLijst;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;

public class WoordenLezer {

    static public WoordenLijst lees() {
        Scanner sc = new Scanner("hangman.txt");
        if(!sc.hasNextLine()){
            throw new DbException("hangman.txt is leeg");
        }
        WoordenLijst lijst = new WoordenLijst();
        while(sc.hasNextLine()) {
            String woord = sc.nextLine();
            lijst.voegToe(woord);
        }
        sc.close();
        return lijst;
    }

    public void schrijf(String woord){
        PrintWriter out;
        try {
            out = new PrintWriter("hangman.txt");
            out.println(woord);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
