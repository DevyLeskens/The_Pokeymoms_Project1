package ui;

import domain.Punt;
import domain.Driehoek;
import domain.DomainException;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class DriehoekApp {
    private Label invoerXHoek1Label;
    private Label invoerXHoek2Label;
    private Label invoerXHoek3Label;
    private Label invoerYHoek1Label;
    private Label invoerYHoek2Label;
    private Label invoerYHoek3Label;

    private TextField invoerXHoek1Veld;
    private TextField invoerXHoek2Veld;
    private TextField invoerXHoek3Veld;
    private TextField invoerYHoek1Veld;
    private TextField invoerYHoek2Veld;
    private TextField invoerYHoek3Veld;

    private Driehoek driehoek;

    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);

    public DriehoekApp(GridPane root) {
        invoerXHoek1Label = new Label("Geef het x-coordinaat van Hoekpunt 1 van de driehoek");
        invoerXHoek1Veld = new TextField();
        invoerYHoek1Label = new Label("Geef het y-coordinaat van Hoekpunt 1 van de driehoek");
        invoerYHoek1Veld = new TextField();
        invoerXHoek2Label = new Label("Geef het x-coordinaat van Hoekpunt 2 van de driehoek");
        invoerXHoek2Veld = new TextField();
        invoerYHoek2Label = new Label("Geef het y-coordinaat van Hoekpunt 2 van de driehoek");
        invoerYHoek2Veld = new TextField();
        invoerXHoek3Label = new Label("Geef het x-coordinaat van Hoekpunt 3 van de driehoek");
        invoerXHoek3Veld = new TextField();
        invoerYHoek3Label = new Label("Geef het y-coordinaat van Hoekpunt 3 van de driehoek");
        invoerYHoek3Veld = new TextField();

        root.add(invoerXHoek1Label, 0, 0);
        root.add(invoerXHoek1Veld, 1, 0);
        root.add(invoerYHoek1Label, 0, 1);
        root.add(invoerYHoek1Veld, 1, 1);
        root.add(invoerXHoek2Label, 0, 2);
        root.add(invoerXHoek2Veld, 1, 2);
        root.add(invoerYHoek2Label, 0, 3);
        root.add(invoerYHoek2Veld, 1, 3);
        root.add(invoerXHoek3Label, 0, 4);
        root.add(invoerXHoek3Veld, 1, 4);
        root.add(invoerYHoek3Label, 0, 5);
        root.add(invoerYHoek3Veld, 1, 5);


        invoerYHoek3Veld.setOnAction(eventJuisteInvoerDriehoek -> {
            try {
                Punt punt1 = new Punt(Integer.parseInt(invoerXHoek1Veld.getText()), Integer.parseInt(invoerYHoek1Veld.getText()));
                Punt punt2 = new Punt(Integer.parseInt(invoerXHoek2Veld.getText()), Integer.parseInt(invoerYHoek2Veld.getText()));
                Punt punt3 = new Punt(Integer.parseInt(invoerXHoek3Veld.getText()), Integer.parseInt(invoerYHoek3Veld.getText()));

                Driehoek driehoek = new Driehoek(punt1, punt2, punt3);
                root.getChildren().clear();

                Text uitvoer = new Text();
                uitvoer.setText(driehoek.toString());
                root.add(uitvoer, 0, 1);

            } catch (DomainException e) {
                invoerXHoek1Veld.clear();
                invoerYHoek1Veld.clear();
                invoerXHoek2Veld.clear();
                invoerYHoek2Veld.clear();
                invoerXHoek3Veld.clear();
                invoerYHoek3Veld.clear();

                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText(e.getMessage());
                foutenboodschap.showAndWait();
            }
        });
    }
}
