package org.openjx.View;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import org.openjx.App;
import org.openjx.Controller.IncomeController;


public class IncomeView {

    public static Pane getPane() {
        return pane;
    }

    private  static Pane pane;
    Label label;
    TextField comment;

    public IncomeView() {
        init();
        Scene scene = new Scene(pane, App.screen.getBounds().getWidth(), App.screen.getBounds().getHeight());
        App.setBackground(pane);
        App.setScene(scene);
        new IncomeController();

    }

    public void init() {

        pane = new Pane();
        label = new Label("Back");
        comment = new TextField();
        pane.getChildren().addAll(label, comment);
        label.setLayoutX(50);
        label.setLayoutY(App.screen.getBounds().getHeight() - 50);
        App.setFonts(label);
    }


}
