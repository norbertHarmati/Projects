package org.openjx.View;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import org.controlsfx.control.Notifications;
import org.openjx.App;
import org.openjx.Controller.IncomeController;


public class IncomeView {


    public static Pane getPane() {
        return pane;
    }

    private static Pane pane;
    Label label, amountL, dateL, from_whom_the_income_comesL, commentL, commit;
    Tooltip amountT, dateT, from_whom_the_income_comesT, commentT;
    TextArea comment;
    TextField amount, from_whom_the_income_comes;
    DatePicker date;

    public IncomeView() {
        init();

        Notification();
        Scene scene = new Scene(pane, App.screen.getBounds().getWidth(), App.screen.getBounds().getHeight());
        scene.getStylesheets().add("text.css");
        App.setBackground(pane);
        App.setScene(scene);
        new IncomeController();
        System.out.println(App.screen.getBounds());
    }

    public void init() {

        pane = new Pane();
        comment = new TextArea();
        amount = new TextField();
        from_whom_the_income_comes = new TextField();
        date = new DatePicker();

        creatingLabels();
        creatingTooltips();
        setTooltipFonts();
        setTooltips();
        setLayouts();

        setFonts();
        setPane();
    }


    public void Notification() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Notifications notify = Notifications.create().title("Download")
                        .text("Download File")
                        .hideAfter(javafx.util.Duration.seconds(2))
                        .position(Pos.BOTTOM_RIGHT);
                notify.darkStyle();
                notify.show();
            }
        });




    }

    void creatingLabels() {
        label = new Label("Back");
        commit = new Label("Commit");
        amountL = new Label("Amount of income");
        dateL = new Label("Date");
        from_whom_the_income_comesL = new Label("Name of income");
        commentL = new Label("Your comment");

    }

    void creatingTooltips() {

        dateT = new Tooltip("The date when you got the revenue");
        from_whom_the_income_comesT = new Tooltip("Where the revenue come from");
        amountT = new Tooltip("Any revenue what you get from anywhere");
        commentT = new Tooltip("Write comments if you wish.\n" +
                "You have  max. 45 characters");

    }

    void setTooltips() {

        amountL.setTooltip(amountT);
        dateL.setTooltip(dateT);
        from_whom_the_income_comesL.setTooltip(from_whom_the_income_comesT);
        commentL.setTooltip(commentT);

    }

    void setTooltipFonts() {
        amountT.setFont(new Font("Arial", 12));
        dateT.setFont(new Font("Arial", 12));
        from_whom_the_income_comesT.setFont(new Font("Arial", 12));
        commentT.setFont(new Font("Arial", 12));
    }

    void setPane() {
        pane.getChildren().addAll(label, comment, amount, date, from_whom_the_income_comes, commit, dateL, from_whom_the_income_comesL, amountL, commentL);
    }

    void setLayouts() {
        App.setLayout(commentL, App.screen.getBounds().getWidth() / 2 + 370, App.screen.getBounds().getHeight() / 2 - 50);
        App.setLayout(amountL, App.screen.getBounds().getWidth() / 2 + 45, App.screen.getBounds().getHeight() / 2 - 50);
        App.setLayout(dateL, App.screen.getBounds().getWidth() / 2 - 445, App.screen.getBounds().getHeight() / 2 - 50);
        App.setLayout(from_whom_the_income_comesL, App.screen.getBounds().getWidth() / 2 - 240, App.screen.getBounds().getHeight() / 2 - 50);
        App.setLayout(label, 50, App.screen.getBounds().getHeight() - 50);
        App.setLayout(commit, 1150, App.screen.getBounds().getHeight() - 50);

        date.setLayoutX(App.screen.getBounds().getWidth() / 2 - 500);
        date.setLayoutY(App.screen.getBounds().getHeight() / 2);

        setTextArea(comment, App.screen.getBounds().getWidth() / 2 + 400, App.screen.getBounds().getHeight() / 2);
        setTextfield(amount, App.screen.getBounds().getWidth() / 2 + 100, App.screen.getBounds().getHeight() / 2);
        setTextfield(from_whom_the_income_comes, App.screen.getBounds().getWidth() / 2 - 200, App.screen.getBounds().getHeight() / 2);

    }

    void setFonts() {
        App.setFont(label);
        App.setFont(commentL);
        App.setFont(amountL);
        App.setFont(dateL);
        App.setFont(from_whom_the_income_comesL);
        App.setFont(commit);

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

    void showAlertNotification() {

    }
}
