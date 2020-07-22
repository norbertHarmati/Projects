package org.openjx;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Pane pane;
    private static URL url = App.class.getResource("/savings.jpg");
    Screen screen = Screen.getPrimary();
    private Label exit;
    private Label income;
    private Label expense;
    private Label help;
    private Label title;


    public void init() {

        pane = new Pane();
        exit = new Label("Exit");
        income = new Label("Income");
        expense = new Label("Expense");
        help = new Label("Help");
        title = new Label("Income-expense calculator");

        setLayout(help, screen.getBounds().getWidth() - 100, screen.getBounds().getHeight() - 100);
        setLayout(income, 50, screen.getBounds().getHeight() - 250);
        setLayout(expense, 50, screen.getBounds().getHeight() - 150);
        setLayout(exit, 50, screen.getBounds().getHeight() - 50);
        setLayout(title,screen.getBounds().getWidth()/2-250, 50);
        setFonts(title);
        setFonts(exit);
        setFonts(income);
        setFonts(expense);
        setFonts(help);

        pane.getChildren().addAll(exit, income, expense, help,title);
    }

    public void setLayout(Label label, double x, double y) {

        label.setLayoutX(x);
        label.setLayoutY(y);
    }

    public void setBackground(Stage stage) {
        Background image = new Background(new BackgroundImage(new Image(String.valueOf(url), screen.getBounds().getWidth(), screen.getBounds().getHeight(), false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT));
//then you set to your node
        pane.setBackground(image);
    }

    public void setFonts(Label label) {
        label.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD,32));
    }

    @Override
    public void start(Stage stage) {


        Scene scene = new Scene(pane, 640, 480);
        setBackground(stage);
        stage.setMaximized(true);
        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        new AppController();

        stage.show();
    }

    public static Pane getPane() {
        return pane;
    }

    public static void main(String[] args) {
        launch();
    }

}