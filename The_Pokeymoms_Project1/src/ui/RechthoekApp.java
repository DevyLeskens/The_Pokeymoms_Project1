package ui;

import domain.DomainException;
import domain.Punt;
import domain.Rechthoek;
import domain.Speler;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class RechthoekApp {
    private Label invoerXCoordinaatLabel;
    private Label invoerYCoordinaatLabel;
    private Label invoerBreedteLabel;
    private Label invoerHoogteLabel;
    private TextField invoerXCoordinaatVeld;
    private TextField invoerYCoordinaatVeld;
    private TextField invoerBreedteVeld;
    private TextField invoerHoogteVeld;
    private Rechthoek rechthoek;

    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);

    public RechthoekApp(GridPane root) {

        invoerXCoordinaatLabel = new Label("Geef de x-coördinaat van de linkerbovenhoek van de rechthoek   ");
        invoerXCoordinaatVeld = new TextField();
        invoerYCoordinaatLabel = new Label("Geef de y-coördinaat van de linkerbovenhoek van de rechthoek   ");
        invoerYCoordinaatVeld = new TextField();
        invoerBreedteLabel = new Label("Geef de breedte van de rechthoek            ");
        invoerBreedteVeld = new TextField();
        invoerHoogteLabel = new Label("Geef de hoogte van de rechthoek          ");
        invoerHoogteVeld = new TextField();

        root.add(invoerXCoordinaatLabel, 0, 0);
        root.add(invoerXCoordinaatVeld, 1, 0);
        root.add(invoerYCoordinaatLabel, 0, 1);
        root.add(invoerYCoordinaatVeld, 1, 1);
        root.add(invoerBreedteLabel, 0, 2);
        root.add(invoerBreedteVeld, 1, 2);
        root.add(invoerHoogteLabel, 0, 3);
        root.add(invoerHoogteVeld, 1, 3);

        invoerHoogteVeld.setOnAction(eventJuisteInvoerRechthoek -> {
            try {
                Punt punt = new Punt(Integer.parseInt(invoerXCoordinaatVeld.getText()), Integer.parseInt(invoerYCoordinaatVeld.getText()));
                rechthoek = new Rechthoek(punt, Integer.parseInt(invoerBreedteVeld.getText()), Integer.parseInt(invoerHoogteVeld.getText()));
                root.getChildren().clear();

                Text uitvoer = new Text();
                uitvoer.setText(rechthoek.toString());
                root.add(uitvoer, 0, 1);

            } catch (DomainException e) {
                invoerXCoordinaatVeld.clear();
                invoerYCoordinaatVeld.clear();
                invoerBreedteVeld.clear();
                invoerHoogteVeld.clear();

                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText(e.getMessage());
                foutenboodschap.showAndWait();
            }
        });


    }
}
