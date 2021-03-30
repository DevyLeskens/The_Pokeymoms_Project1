package ui;

import domain.*;
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

    private Vorm vorm;

    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);

    public RechthoekApp(GridPane root) {

        init(root, 0);
        invoerHoogteVeld.setOnAction(eventIngaveHoogteveld -> {
            try {
                Punt middelpunt = new Punt(Integer.parseInt(invoerXCoordinaatVeld.getText()),Integer.parseInt(invoerYCoordinaatVeld.getText()));
                vorm = new Rechthoek(middelpunt, Integer.parseInt(invoerBreedteVeld.getText()), Integer.parseInt(invoerHoogteVeld.getText()));
                root.getChildren().clear();
                Text uitvoer = new Text();
                uitvoer.setText(vorm.toString());
                root.add(uitvoer,0,0);
            } catch (DomainException e) {
                cleanUp(root);
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setHeaderText(null);
                foutenboodschap.setContentText(e.getMessage());
                foutenboodschap.showAndWait();
            }

        });
    }

    public RechthoekApp(GridPane root, Tekening tekening) {
        init(root, 1);
        invoerHoogteVeld.setOnAction(eventIngaveHoogteveld -> {
            try {
                Punt punt = new Punt(Integer.parseInt(invoerXCoordinaatVeld.getText()), Integer.parseInt(invoerYCoordinaatVeld.getText()));
                vorm = new Rechthoek(punt, Integer.parseInt(invoerBreedteVeld.getText()), Integer.parseInt(invoerHoogteVeld.getText()));
                tekening.voegToe(vorm);
                cleanUp(root);

            } catch (DomainException e) {
                cleanUp(root);
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setHeaderText(null);
                foutenboodschap.setContentText(e.getMessage());
                foutenboodschap.showAndWait();
            }

        });
    }

    private void init(GridPane root, int teller) {
        invoerXCoordinaatLabel = new Label("Geef de x-coördinaat van de linkerbovenhoek van de rechthoek   ");
        invoerXCoordinaatVeld = new TextField();
        invoerYCoordinaatLabel = new Label("Geef de y-coördinaat van de linkerbovenhoek van de rechthoek   ");
        invoerYCoordinaatVeld = new TextField();
        invoerBreedteLabel = new Label("Geef de breedte van de rechthoek            ");
        invoerBreedteVeld = new TextField();
        invoerHoogteLabel = new Label("Geef de hoogte van de rechthoek          ");
        invoerHoogteVeld = new TextField();

        root.add(invoerXCoordinaatLabel, 0, teller);
        root.add(invoerXCoordinaatVeld, 1, teller);

        invoerXCoordinaatVeld.setOnAction(eventIngaveX -> {
            try {
                Integer.parseInt(invoerXCoordinaatVeld.getText());
                root.add(invoerYCoordinaatLabel, 0, teller + 1);
                root.add(invoerYCoordinaatVeld, 1, teller + 1);
            } catch (NumberFormatException e) {
                invoerXCoordinaatVeld.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("x coördinaat van linkerbovenhoek van de rechthoek moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }

        });

        invoerYCoordinaatVeld.setOnAction(eventIngaveY -> {
            try {
                Integer.parseInt(invoerYCoordinaatVeld.getText());
                root.add(invoerBreedteLabel, 0, teller + 2);
                root.add(invoerBreedteVeld, 1, teller + 2);
            } catch (NumberFormatException e) {
                invoerYCoordinaatVeld.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("y coördinaat van linkerbovenhoek van de rechthoek moet een geheel getal zijn");
                foutenboodschap.showAndWait();

            }
        });

        invoerBreedteVeld.setOnAction(eventIngaveBreedte -> {
            try {
                Integer.parseInt(invoerBreedteVeld.getText());
                root.add(invoerHoogteLabel, 0, teller + 3);
                root.add(invoerHoogteVeld, 1, teller + 3);
            } catch (NumberFormatException e) {
                invoerHoogteVeld.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("Breedte van de rechthoek moet groter zijn dan nul");
            }
        });

        invoerHoogteVeld.setOnAction(eventIngaveHoogte -> {
            try {
                Integer.parseInt(invoerHoogteVeld.getText());
            } catch (DomainException e) {
                System.out.println(e.getMessage());
            }
        });
    }

    private void cleanUp(GridPane root) {
        root.getChildren().remove(invoerXCoordinaatLabel);
        root.getChildren().remove(invoerXCoordinaatVeld);
        root.getChildren().remove(invoerYCoordinaatLabel);
        root.getChildren().remove(invoerYCoordinaatVeld);
        root.getChildren().remove(invoerBreedteLabel);
        root.getChildren().remove(invoerBreedteVeld);
        root.getChildren().remove(invoerHoogteLabel);
        root.getChildren().remove(invoerHoogteVeld);

    }
}
