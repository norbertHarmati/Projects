package org.openjx.View;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import org.openjx.App;
import org.openjx.Controller.IncomeController;


public class IncomeView {

    public static Pane getPane() {
        return pane;
    }

    private static Pane pane;
    Label label, amountL, dateL, from_whom_the_income_comesL, commentL;
    Tooltip amountT, dateT, from_whom_the_income_comesT, commentT;
    TextArea comment;
    TextField amount, from_whom_the_income_comes;
    DatePicker date;

    public IncomeView() {
        init();
        Scene scene = new Scene(pane, App.screen.getBounds().getWidth(), App.screen.getBounds().getHeight());
        scene.getStylesheets().add("text.css");
        App.setBackground(pane);
        App.setScene(scene);
        new IncomeController();
    }

    void creatingLabels() {
        label = new Label("Back");
        amountL = new Label(" Your income");
        dateL = new Label("Date");
        from_whom_the_income_comesL = new Label("Your name");
        commentL = new Label("Your comment");

    }

    void creatingTooltips() {

        amountT = new Tooltip("");
        dateT = new Tooltip("");
        commentT = new Tooltip("Here you can write comments if you wish." +
                "You have  max. 45 character");
        from_whom_the_income_comesT = new Tooltip("The name whom the income comes");
    }

    void setTooltips() {

        amountL.setTooltip(amountT);
        dateL.setTooltip(dateT);
        from_whom_the_income_comesL.setTooltip(from_whom_the_income_comesT);
        commentL.setTooltip(commentT);

    }

    public void init() {

        pane = new Pane();
        comment = new TextArea();
        amount = new TextField();
        from_whom_the_income_comes = new TextField();
        date = new DatePicker();


        comment.setWrapText(true);

        creatingLabels();
        creatingTooltips();

        setTooltips();
        setLayouts();

        setFonts();
        setPane();



    }

    void setPane(){
        pane.getChildren().addAll(label, comment, amount, date, from_whom_the_income_comes, commentL, amountL, dateL, from_whom_the_income_comesL);
    }

    void setLayouts(){
        App.setLayout(commentL, App.screen.getBounds().getWidth() / 2 + 400, App.screen.getBounds().getHeight() / 2 - 50);
        App.setLayout(amountL, App.screen.getBounds().getWidth() / 2 + 100, App.screen.getBounds().getHeight() / 2 - 50);
        App.setLayout(dateL, App.screen.getBounds().getWidth() / 2 - 500, App.screen.getBounds().getHeight() / 2 - 50);
        App.setLayout(from_whom_the_income_comesL, App.screen.getBounds().getWidth() / 2 - 200, App.screen.getBounds().getHeight() / 2 - 50);
        App.setLayout(label, 50, App.screen.getBounds().getHeight() - 50);

        date.setLayoutX(App.screen.getBounds().getWidth() / 2 - 500);
        date.setLayoutY(App.screen.getBounds().getHeight() / 2);

        setTextArea(comment, App.screen.getBounds().getWidth() / 2 + 400, App.screen.getBounds().getHeight() / 2);
        setTextfield(amount, App.screen.getBounds().getWidth() / 2 + 100, App.screen.getBounds().getHeight() / 2);
        setTextfield(from_whom_the_income_comes, App.screen.getBounds().getWidth() / 2 - 200, App.screen.getBounds().getHeight() / 2);

    }

    void setFonts(){
        App.setFonts(label);
        App.setFonts(commentL);
        App.setFonts(amountL);
        App.setFonts(dateL);
        App.setFonts(from_whom_the_income_comesL);

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
    }



}
