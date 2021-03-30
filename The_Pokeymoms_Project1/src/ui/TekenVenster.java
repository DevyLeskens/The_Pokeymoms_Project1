package ui;

import javafx.scene.layout.GridPane;
import domain.*;
import javafx.scene.layout.Pane;
import javafx.scene.shape.*;
import javafx.scene.paint.*;


public class TekenVenster {
    private Tekening tekening;

    public TekenVenster(Pane root, Tekening tekening){
        if (tekening == null) throw new UiException();
        this.tekening = tekening;
       // this.tekening(root);
    }

  public void teken(Pane root) {
      // TODO vormen toevoegen aan tekening
      tekening.teken(root);
  }
}