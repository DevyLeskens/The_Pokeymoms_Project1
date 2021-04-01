package ui;

import domain.DomainException;
import domain.LijnStuk;
import domain.Punt;
import domain.Rechthoek;
import domain.Vorm;
import domain.Tekening;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class LijnstukApp {
    private Label invoerXStartPuntLabel;
    private Label invoerYStartPuntLabel;
    private Label invoerXEindPuntLabel;
    private Label invoerYEindPuntLabel;
    private TextField invoerXStartPuntVeld;
    private TextField invoerYStartPuntVeld;
    private TextField invoerXEindPuntVeld;
    private TextField invoerYEindPuntVeld;
    private LijnStuk lijnStuk;

    private Vorm vorm;

    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);

    public LijnstukApp(GridPane root) {
        invoerXStartPuntLabel = new Label("Geef de x-coördinaat van het startpunt van het lijnstuk    ");
        invoerYStartPuntLabel = new Label("Geef de y-coördinaat van het startpunt van het lijnstuk  ");
        invoerXEindPuntLabel = new Label("Geef de x-coördinaat van het eindpunt van het lijnstuk    ");
        invoerYEindPuntLabel = new Label("Geef de y-coördinaat van het eindpunt van het lijnstuk    ");
        invoerXStartPuntVeld = new TextField();
        invoerYStartPuntVeld = new TextField();
        invoerXEindPuntVeld = new TextField();
        invoerYEindPuntVeld = new TextField();

        root.add(invoerXStartPuntLabel, 0, 0);
        root.add(invoerXStartPuntVeld, 1, 0);
        root.add(invoerYStartPuntLabel, 0, 1);
        root.add(invoerYStartPuntVeld, 1, 1);
        root.add(invoerXEindPuntLabel, 0, 2);
        root.add(invoerXEindPuntVeld, 1, 2);
        root.add(invoerYEindPuntLabel, 0, 3);
        root.add(invoerYEindPuntVeld, 1, 3);

        invoerYEindPuntVeld.setOnAction(eventJuisteInvoerLijnstuk -> {
            try {
                Punt startPunt = new Punt(Integer.parseInt(invoerXStartPuntVeld.getText()), Integer.parseInt(invoerYStartPuntVeld.getText()));
                Punt eindPunt = new Punt(Integer.parseInt(invoerXEindPuntVeld.getText()), Integer.parseInt(invoerYEindPuntVeld.getText()));
                LijnStuk lijnstuk = new LijnStuk(startPunt, eindPunt);
                root.getChildren().clear();

                Text uitvoer = new Text();
                uitvoer.setText(lijnstuk.toString());
                root.add(uitvoer, 0, 1);

            } catch (DomainException e) {
                invoerXStartPuntVeld.clear();
                invoerYStartPuntVeld.clear();
                invoerXEindPuntVeld.clear();
                invoerYEindPuntVeld.clear();

                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText(e.getMessage());
                foutenboodschap.showAndWait();
            }
        });
    }

    public LijnstukApp(GridPane root, Tekening tekening){
        init(root, 1);
        invoerYEindPuntVeld.setOnAction(eventIngaveEindpunt -> {
            try {
                Punt startpunt = new Punt(Integer.parseInt(invoerXStartPuntVeld.getText()), Integer.parseInt(invoerYStartPuntVeld.getText()));
                Punt eindpunt = new Punt(Integer.parseInt(invoerXEindPuntVeld.getText()), Integer.parseInt(invoerYEindPuntVeld.getText()));
                vorm = new LijnStuk(startpunt, eindpunt);
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
        invoerXStartPuntLabel = new Label("Geef de x-coördinaat van het startpunt van het lijnstuk   ");
        invoerXStartPuntVeld = new TextField();
        invoerYStartPuntLabel = new Label("Geef de y-coördinaat van de startpunt van het lijnstuk   ");
        invoerYStartPuntVeld = new TextField();
        invoerXEindPuntLabel = new Label("Geef de breedte van de rechthoek            ");
        invoerXEindPuntVeld = new TextField();
        invoerYEindPuntLabel = new Label("Geef de hoogte van de rechthoek          ");
        invoerYEindPuntVeld = new TextField();


        invoerXStartPuntVeld.setOnAction(eventIngaveStartX -> {
            try {
                Integer.parseInt(invoerXStartPuntVeld.getText());
                root.add(invoerYStartPuntLabel, 0, teller + 1);
                root.add(invoerYStartPuntVeld, 1, teller + 1);
            } catch (NumberFormatException e) {
                invoerXStartPuntVeld.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("x coördinaat van startpunt van het lijnstuk moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }

        });

        invoerYStartPuntVeld.setOnAction(eventIngaveStartY -> {
            try {
                Integer.parseInt(invoerYStartPuntVeld.getText());
            } catch (DomainException e) {
                System.out.println(e.getMessage());
            }
        });

        invoerXEindPuntVeld.setOnAction(eventIngaveEindX -> {
            try {
                Integer.parseInt(invoerXEindPuntVeld.getText());
            } catch (DomainException e){
                System.out.println(e.getMessage());
            }
        });

        invoerYEindPuntVeld.setOnAction(eventIngaveEindY -> {
            try {
                Integer.parseInt(invoerYEindPuntVeld.getText());
            } catch (DomainException e){
                System.out.println(e.getMessage());
            }
        });
    }

    private void cleanUp(GridPane root) {
        root.getChildren().remove(invoerXStartPuntLabel);
        root.getChildren().remove(invoerXStartPuntVeld);
        root.getChildren().remove(invoerYStartPuntLabel);
        root.getChildren().remove(invoerYStartPuntVeld);
        root.getChildren().remove(invoerXEindPuntLabel);
        root.getChildren().remove(invoerXEindPuntVeld);
        root.getChildren().remove(invoerYEindPuntLabel);
        root.getChildren().remove(invoerYEindPuntVeld);

    }
}
