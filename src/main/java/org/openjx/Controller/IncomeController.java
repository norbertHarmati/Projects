package org.openjx.Controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.openjx.App;
import org.openjx.View.IncomeView;


public class IncomeController {

    Label back;
    TextArea comment;
    TextField amount, from_whom_the_income_comes;
    DatePicker date;
    private static final int max_length = 45;

    public IncomeController() {
        back = (Label) IncomeView.getPane().getChildren().get(0);
        amount = (TextField) IncomeView.getPane().getChildren().get(2);
        date = (DatePicker) IncomeView.getPane().getChildren().get(3);
        from_whom_the_income_comes = (TextField) IncomeView.getPane().getChildren().get(4);
        comment = (TextArea) IncomeView.getPane().getChildren().get(1);
        addTextLimiter(comment,max_length);
        addMouseEvent();
        mouseEntered();
        mouseExited();

    }

    public static void addTextLimiter(final TextArea tf, final int maxLength) {
        tf.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(final ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
                if (tf.getText().length() > maxLength) {
                    String s = tf.getText().substring(0, maxLength);
                    tf.setText(s);
                }
            }
        });
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
