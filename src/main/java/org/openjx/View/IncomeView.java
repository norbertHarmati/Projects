package org.openjx.View;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import org.openjx.App;
import org.openjx.Controller.IncomeController;


public class IncomeView {


    public static Pane getPane() {
        return pane;
    }

    private static Pane pane;
    Label back, amountL, dateL, from_whom_the_income_comesL, commentL, commit, intervalStartL, intervalEndL;
    Tooltip amountT, dateT, from_whom_the_income_comesT, commentT, intervalStartT, intervalEndT;
    TextArea comment;
    TextField amount, from_whom_the_income_comes;
    DatePicker date, intervalStart, intervalEnd;
    ChoiceBox cb;
 cb.getItems().addAll("item1", "item2", "item3");

    public IncomeView() {
        init();


        Scene scene = new Scene(pane, App.screen.getBounds().getWidth(), App.screen.getBounds().getHeight());
        scene.getStylesheets().add("text.css");
        App.setBackground(pane);
        App.setScene(scene);
        new IncomeController(this);
        System.out.println(App.screen.getBounds());
    }

    public void init() {

        pane = new Pane();
        comment = new TextArea();
        amount = new TextField();
        from_whom_the_income_comes = new TextField();
        date = new DatePicker();
        intervalStart = new DatePicker();
        intervalEnd = new DatePicker();
        cb = new ChoiceBox();

        creatingLabels();
        creatingTooltips();
        setTooltipFonts();
        setTooltips();
        setLayouts();
        setFonts();
        setPane();
    }

    public void showWarningNotification(Exception e) {
        if (e instanceof NullPointerException) {
            System.out.println("Nullpointer");

            Notifications notification = Notifications.create().title("Warning")
                    .text("Fill the Date, Name of Income and Amount of income textbars!")
                    .graphic(null)
                    .darkStyle()
                    .hideAfter(Duration.seconds(2))
                    .position(Pos.BOTTOM_CENTER);

            notification.show();

        } else if (e instanceof NumberFormatException) {
            System.out.println("numberformat");
            Notifications notification = Notifications.create().title("Warning")
                    .text("Invalid type! Enter a number, please!")
                    .graphic(null)
                    .darkStyle()
                    .hideAfter(Duration.seconds(2))
                    .position(Pos.BOTTOM_CENTER);

            notification.show();

        } else {
            Notifications notification = Notifications.create().title("Warning")
                    .text("Invalid name!")
                    .graphic(null)
                    .darkStyle()
                    .hideAfter(Duration.seconds(2))
                    .position(Pos.BOTTOM_CENTER);

            notification.show();
        }
    }


    void creatingLabels() {
        back = new Label("Back");
        commit = new Label("Commit");
        amountL = new Label("Amount of income");
        dateL = new Label("Date");
        from_whom_the_income_comesL = new Label("Name");
        commentL = new Label("Your comment");
        intervalStartL = new Label("From");
        intervalEndL = new Label("To");

    }
    public void

    void creatingTooltips() {

        dateT = new Tooltip("The date when you got the revenue");
        from_whom_the_income_comesT = new Tooltip("The person who got the revenue");
        amountT = new Tooltip("Any revenue what you got from anywhere");
        commentT = new Tooltip("Write comments if you wish.\n" +
                "You have  max. 45 characters");
        intervalStartT = new Tooltip("From");
        intervalEndT = new Tooltip("To");

    }

    void setTooltips() {

        amountL.setTooltip(amountT);
        dateL.setTooltip(dateT);
        from_whom_the_income_comesL.setTooltip(from_whom_the_income_comesT);
        commentL.setTooltip(commentT);
        intervalStartL.setTooltip(intervalStartT);
        intervalEndL.setTooltip(intervalEndT);

    }

    void setTooltipFonts() {
        amountT.setFont(new Font("Arial", 12));
        dateT.setFont(new Font("Arial", 12));
        from_whom_the_income_comesT.setFont(new Font("Arial", 12));
        commentT.setFont(new Font("Arial", 12));
        intervalStartL.setFont(new Font("Arial", 12));
        intervalEndL.setFont(new Font("Arial", 12));
    }

    void setPane() {
        pane.getChildren().addAll(back, comment, amount, date, from_whom_the_income_comes, commit, dateL, from_whom_the_income_comesL, amountL, commentL, intervalStart,intervalEnd,intervalStartL, intervalEndL);
    }

    void setLayouts() {

        date.setLayoutX(App.screen.getBounds().getWidth() / 16);
        date.setLayoutY(App.screen.getBounds().getHeight() / 6);
        App.setLayout(dateL, App.screen.getBounds().getWidth() / 11, App.screen.getBounds().getHeight() / 8);

        setTextfield(from_whom_the_income_comes, App.screen.getBounds().getWidth() / 4, App.screen.getBounds().getHeight() / 6);
        App.setLayout(from_whom_the_income_comesL, App.screen.getBounds().getWidth() / 3.75, App.screen.getBounds().getHeight() / 8);

        setTextfield(amount, App.screen.getBounds().getWidth() / 14, App.screen.getBounds().getHeight() / 3);
        App.setLayout(amountL, App.screen.getBounds().getWidth() / 23, App.screen.getBounds().getHeight() / 3.5);

        setTextArea(comment, App.screen.getBounds().getWidth() / 4, App.screen.getBounds().getHeight() / 3);
        App.setLayout(commentL, App.screen.getBounds().getWidth() / 4.25, App.screen.getBounds().getHeight() / 3.5);


        App.setLayout(back, 50, App.screen.getBounds().getHeight() - 50);
        App.setLayout(commit, App.screen.getBounds().getWidth() / 6 , App.screen.getBounds().getHeight() / 2);

        intervalStart.setLayoutX(App.screen.getBounds().getWidth()/1.175);
        intervalStart.setLayoutY(App.screen.getBounds().getHeight()/6);
        App.setLayout(intervalStartL, App.screen.getBounds().getWidth() / 1.45, App.screen.getBounds().getHeight() / 8);

        intervalEnd.setLayoutX(App.screen.getBounds().getWidth()/1.5);
        intervalEnd.setLayoutY(App.screen.getBounds().getHeight()/6);
        App.setLayout(intervalEndL, App.screen.getBounds().getWidth() / 1.125, App.screen.getBounds().getHeight() / 8);


    }

    void setFonts() {
        App.setFont(back);
        App.setFont(commentL);
        App.setFont(amountL);
        App.setFont(dateL);
        App.setFont(from_whom_the_income_comesL);
        App.setFont(commit);
        App.setFont(intervalStartL);
        App.setFont(intervalEndL);

    }

    public static void setTextfield(TextField textField, double x, double y) {

        textField.setLayoutX(x);
        textField.setLayoutY(y);
        textField.setMaxSize(150, 50);
    }

    public static void setTextArea(TextArea textArea, double x, double y) {

        textArea.setLayoutX(x);
        textArea.setLayoutY(y);
        textArea.setMaxSize(150, 50);
        textArea.setWrapText(true);
    }


}
