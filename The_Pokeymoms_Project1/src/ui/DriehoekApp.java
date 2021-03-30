package ui;

import domain.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class DriehoekApp {
    private Label invoerXHoek1Label, invoerXHoek2Label, invoerXHoek3Label, invoerYHoek1Label, invoerYHoek2Label, invoerYHoek3Label;
    private TextField invoerXHoek1Veld, invoerXHoek2Veld, invoerXHoek3Veld, invoerYHoek1Veld, invoerYHoek2Veld, invoerYHoek3Veld;

    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);

    private Vorm vorm;

    public DriehoekApp(GridPane root) {
        init(root, 0);
        invoerYHoek3Veld.setOnAction(eventJuisteInvoerDriehoek -> {
            try {
                Punt punt1 = new Punt(Integer.parseInt(invoerXHoek1Veld.getText()), Integer.parseInt(invoerYHoek1Veld.getText()));
                Punt punt2 = new Punt(Integer.parseInt(invoerXHoek2Veld.getText()), Integer.parseInt(invoerYHoek2Veld.getText()));
                Punt punt3 = new Punt(Integer.parseInt(invoerXHoek3Veld.getText()), Integer.parseInt(invoerYHoek3Veld.getText()));

                vorm = new Driehoek(punt1, punt2, punt3);
                root.getChildren().clear();

                Text uitvoer = new Text();
                uitvoer.setText(vorm.toString());
                root.add(uitvoer, 0, 1);

            } catch (DomainException e) {
                cleanUp(root);

                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText(e.getMessage());
                foutenboodschap.showAndWait();
            }
        });
    }

    public DriehoekApp(GridPane root, Tekening tekening) {
        init(root, 1);
        invoerYHoek3Veld.setOnAction(eventIngaveYHoek -> {
            try {
                Punt punt1 = new Punt(Integer.parseInt(invoerXHoek1Veld.getText()), Integer.parseInt(invoerYHoek1Veld.getText()));
                Punt punt2 = new Punt(Integer.parseInt(invoerXHoek2Veld.getText()), Integer.parseInt(invoerYHoek2Veld.getText()));
                Punt punt3 = new Punt(Integer.parseInt(invoerXHoek3Veld.getText()), Integer.parseInt(invoerYHoek3Veld.getText()));
                vorm = new Driehoek(punt1, punt2, punt3);
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
    }

    private void cleanUp(GridPane root) {
        root.getChildren().remove(invoerXHoek1Label);
        root.getChildren().remove(invoerXHoek1Veld);
        root.getChildren().remove(invoerXHoek2Label);
        root.getChildren().remove(invoerXHoek2Veld);
        root.getChildren().remove(invoerXHoek3Label);
        root.getChildren().remove(invoerXHoek3Veld);
        root.getChildren().remove(invoerYHoek1Label);
        root.getChildren().remove(invoerYHoek1Veld);
        root.getChildren().remove(invoerYHoek2Label);
        root.getChildren().remove(invoerYHoek2Veld);
        root.getChildren().remove(invoerYHoek3Label);
        root.getChildren().remove(invoerYHoek3Veld);

    }
}
