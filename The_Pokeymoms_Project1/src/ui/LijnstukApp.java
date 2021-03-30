package ui;

import domain.DomainException;
import domain.LijnStuk;
import domain.Punt;
import domain.Rechthoek;
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

}
