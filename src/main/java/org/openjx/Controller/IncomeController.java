package org.openjx.Controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import org.openjx.App;
import org.openjx.Modell.IncomeModell;
import org.openjx.View.IncomeView;

import java.sql.Date;


public class IncomeController {
    public Pane pane = IncomeView.getPane();
    IncomeModell incomeModell;
    Label back, commit;
    TextArea comment;
    TextField amount, from_whom_the_income_comes;
    DatePicker date;
    private static final int max_length = 45;
    String empty = null;
    IncomeView incomeView;


        this.incomeView = incomeView;
        gettingDataFromIncomeView();
        addTextLimiter(comment, max_length);
        addMouseEvent();
        mouseEntered();
        mouseExited();
        incomeModell = new IncomeModell();
        incomeModell.read();
    }

    void gettingDataFromIncomeView() {

        back = (Label) pane.getChildren().get(0);
        comment = (TextArea) IncomeView.getPane().getChildren().get(1);
        amount = (TextField) pane.getChildren().get(2);
        date = (DatePicker) pane.getChildren().get(3);
        date.setEditable(false);
        from_whom_the_income_comes = (TextField) IncomeView.getPane().getChildren().get(4);
        commit = (Label) pane.getChildren().get(5);


    }

    static void addTextLimiter(final TextArea tf, final int maxLength) {
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

        commit.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent mouseEvent) {
                if (comment.getText() != null) {
                    incomeModell.setComment(comment.getText());
                } else {
                    incomeModell.setComment("");
                }
                try {
                    incomeModell.setDate(Date.valueOf(date.getValue()));

                    if (from_whom_the_income_comes.getText().equals("") || from_whom_the_income_comes.getText() == null) {

                        throw new NullPointerException();

                    }

                    try {
                        if (isValidName(from_whom_the_income_comes.getText())) {
                            incomeModell.setName(from_whom_the_income_comes.getText());

                        } else {
                            throw new Exception();
                        }
                        try {
                            incomeModell.setIncome(Long.parseLong(amount.getText()));
                            comment.setText("");
                            amount.setText(empty);
                            from_whom_the_income_comes.setText(empty);
                            date.setValue(null);
                            incomeModell.sortInputs();
                            incomeModell.sort(incomeModell.getData().getDates(), incomeModell.getData().getDates(), incomeModell.getData().getNames(), incomeModell.getData().getIncomes(), incomeModell.getData().getComments());
                            incomeModell.write();

                        } catch (NumberFormatException e) {
                            incomeView.showWarningNotification(e);
                        }
                    } catch (Exception e) {
                        incomeView.showWarningNotification(e);
                    }
                } catch (NullPointerException e) {
                    incomeView.showWarningNotification(e);
                }
            }
        });

    }

    private boolean isValidName(String text) {

        try {
            long i = Long.parseUnsignedLong(text);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    void mouseEntered() {
        back.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                AppController.resizeLabels(back, 1.5);
            }
        });

        commit.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                AppController.resizeLabels(commit, 1.5);
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
        commit.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                AppController.resizeLabels(commit, 1);
            }
        });
    }

}
