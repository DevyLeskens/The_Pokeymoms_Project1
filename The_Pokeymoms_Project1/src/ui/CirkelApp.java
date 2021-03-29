package ui;

import domain.Cirkel;
import domain.DomainException;
import domain.Punt;
import domain.Rechthoek;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class CirkelApp {
    private Label invoerXCoordinaatLabel;
    private Label invoerYCoordinaatLabel;
    private Label invoerStraalLabel;

    private TextField invoerXCoordinaatVeld;
    private TextField invoerYCoordinaatVeld;
    private TextField invoerStraalVeld;
    private Cirkel cirkel;

    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);

    public CirkelApp(GridPane root) {
        invoerXCoordinaatLabel = new Label("Geef de x-coördinaat van het middelpunt van de cirkel   ");
        invoerXCoordinaatVeld = new TextField();
        invoerYCoordinaatLabel = new Label("Geef de y-coördinaat van de middelpunt van de cirkel   ");
        invoerYCoordinaatVeld = new TextField();
        invoerStraalLabel = new Label("Geef de straal van de cirkel");
        invoerStraalVeld = new TextField();

        root.add(invoerXCoordinaatLabel, 0, 0);
        root.add(invoerXCoordinaatVeld, 1, 0);
        root.add(invoerYCoordinaatLabel, 0, 1);
        root.add(invoerYCoordinaatVeld, 1, 1);
        root.add(invoerStraalLabel, 0, 2);
        root.add(invoerStraalVeld, 1, 2);

        invoerStraalVeld.setOnAction(eventJuisteInvoerCirkel -> {
            try {
                Punt punt = new Punt(Integer.parseInt(invoerXCoordinaatVeld.getText()), Integer.parseInt(invoerYCoordinaatVeld.getText()));
                Cirkel cirkel = new Cirkel(punt, Integer.parseInt(invoerStraalVeld.getText()));
                root.getChildren().clear();

                Text uitvoer = new Text();
                uitvoer.setText(cirkel.toString());
                root.add(uitvoer, 0, 1);

            } catch (DomainException e) {
                invoerXCoordinaatVeld.clear();
                invoerYCoordinaatVeld.clear();
                invoerStraalVeld.clear();

                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText(e.getMessage());
                foutenboodschap.showAndWait();
            }
        });
    }
}
