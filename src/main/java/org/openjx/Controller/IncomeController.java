package org.openjx.Controller;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import org.openjx.App;
import org.openjx.View.IncomeView;


public class IncomeController {

    Label back;


    public IncomeController() {
        back = (Label) IncomeView.getPane().getChildren().get(0);
        addMouseEvent();
        mouseEntered();
        mouseExited();

    }

    void addMouseEvent() {
        back.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                App.setScene(App.getScene());
            }
        });
    }

    void mouseEntered() {
        back.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                AppController.resizeLabels(back, 1.5);
            }
        });

    }

    void mouseExited() {
        back.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                AppController.resizeLabels(back, 1);
            }
        });

    }

}
