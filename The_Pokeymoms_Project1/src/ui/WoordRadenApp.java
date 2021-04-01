
package ui;

import db.WoordenLezer;
import domain.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class WoordRadenApp {
    private Label boodschap, instructies, correct, fout, gewonnen;
    private Text woord;
    private TextField invoerLetter;

    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);

    private WoordenLijst woordenLijst = WoordenLezer.lees();
    private HintWoord hintwoord = woordenLijst.getRandomWoord();

    public WoordRadenApp(GridPane root, Speler speler) {

        init(root);
        invoerLetter.setOnAction(eventIngaveLetter -> {
            try {
                if (hintwoord.raad(invoerLetter.getText().charAt(0))){
                    woord.setText(hintwoord.toString());
                    correct(root);
                } else {
                    fout(root);
                }

            } catch (DomainException e) {
                invoerLetter.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setHeaderText(null);
                foutenboodschap.setContentText(e.getMessage());
                foutenboodschap.showAndWait();
            }
        });
    }

    private void init(GridPane root) {
        boodschap = new Label("Rarara, welk woord zoeken we?");
        woord = new Text(hintwoord.toString());
        instructies = new Label("Geef een letter: ");
        correct = new Label("Super, doe zo voort!");
        fout = new Label("Helaas, volgende keer beter!");
        invoerLetter = new TextField();
        gewonnen = new Label("Goed gedaan naamSpeler! Je hebt het woord geraden in ... aantal zetten!");

        root.add(boodschap, 0, 0);
        root.add(woord, 0, 1);
        root.add(instructies, 0, 3);
        root.add(invoerLetter, 0, 5);


    }

    private void correct(GridPane root) {
       root.getChildren().clear();
       root.add(correct, 0, 0);
       root.add(boodschap, 0, 1);
       root.add(woord, 0, 2);
       root.add(instructies, 0, 4);
       root.add(invoerLetter, 0, 6);
        invoerLetter.clear();
    }

    private void fout(GridPane root){
        root.getChildren().clear();
        root.add(fout, 0, 0);
        root.add(boodschap, 0, 1);
        root.add(woord, 0, 2);
        root.add(instructies, 0, 4);
        root.add(invoerLetter, 0, 6);
        invoerLetter.clear();
    }

    private void cleanUp(GridPane root) {
        root.getChildren().remove(boodschap);
        root.getChildren().remove(woord);
        root.getChildren().remove(instructies);
        root.getChildren().remove(correct);
        root.getChildren().remove(fout);
        root.getChildren().remove(invoerLetter);

    }
}
