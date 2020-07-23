package org.openjx.Controller;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.openjx.App;
import org.openjx.View.IncomeView;

public class AppController {
    public Pane pane = App.getPane();
    Label exit, income, expense, help;

    public AppController() {
        exit = (Label) pane.getChildren().get(0);
        income = (Label) pane.getChildren().get(1);
        expense = (Label) pane.getChildren().get(2);
        help = (Label) pane.getChildren().get(3);
        addMouseEvent();
        mouseEntered();
        mouseExited();
    }

    public void addMouseEvent() {
        exit.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                System.exit(0);
            }
        });

        income.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                new IncomeView();
            }
        });

        expense.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {

            }
        });

        help.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {

            }
        });

    }


    public void mouseEntered() {
        exit.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                resizeLabels(exit, 1.5);
            }
        });

        income.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                resizeLabels(income, 1.5);
            }
        });

        expense.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                resizeLabels(expense, 1.5);
            }
        });

        help.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                resizeLabels(help, 1.5);
            }
        });
    }

    public void mouseExited() {
        exit.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                resizeLabels(exit, 1);
            }
        });

        income.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                resizeLabels(income, 1);
            }
        });

        expense.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                resizeLabels(expense, 1);
            }
        });

        help.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                resizeLabels(help, 1);
            }
        });


    }


    public static void resizeLabels(Label label, double x) {
        label.setScaleX(x);
        label.setScaleY(x);
    }

}
