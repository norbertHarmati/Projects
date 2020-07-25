package org.openjx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.openjx.Controller.AppController;
import org.openjx.Controller.IncomeController;

import java.net.URL;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Pane pane;
    private static URL url = App.class.getResource("/savings.jpg");
    public static Screen screen = Screen.getPrimary();
    private static Stage stage;
    private static final int letterSize = 32;
    private Label exit;
    private Label income;
    private Label expense;
    private Label help;
    private Label title;
    static Scene scene;


    public static Scene getScene() {
        return scene;
    }

    @Override
    public void start(Stage stage) {

        App.stage = stage;
        scene = new Scene(pane, screen.getBounds().getWidth(), screen.getBounds().getHeight());
        setBackground(pane);
        stage.setMaximized(true);
        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        new AppController();
        stage.show();
    }

    public void init() {

        pane = new Pane();
        creatingLabels();
        setLayouts();
        setFonts();

        pane.getChildren().addAll(exit, income, expense, help, title);
    }

    void creatingLabels() {
        exit = new Label("Exit");
        income = new Label("Income");
        expense = new Label("Expense");
        help = new Label("Help");
        title = new Label("Income-expense calculator");


    }

    void setLayouts() {
        setLayout(help, screen.getBounds().getWidth() - 100, screen.getBounds().getHeight() - 100);
        setLayout(income, 50, screen.getBounds().getHeight() - 250);
        setLayout(expense, 50, screen.getBounds().getHeight() - 150);
        setLayout(exit, 50, screen.getBounds().getHeight() - 50);
        setLayout(title, screen.getBounds().getWidth() / 2 - 250, 50);

    }

    void setFonts() {
        setFont(title);
        setFont(exit);
        setFont(income);
        setFont(expense);
        setFont(help);
    }

    public static void setLayout(Label label, double x, double y) {

        label.setLayoutX(x);
        label.setLayoutY(y);
    }

    public static void setFont(Label label) {
        label.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, letterSize));
    }

    public static void setBackground(Pane pane) {
        Background image = new Background(new BackgroundImage(new Image(String.valueOf(url), screen.getBounds().getWidth(), screen.getBounds().getHeight(), false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT));
        pane.setBackground(image);
    }

    public static Pane getPane() {
        return pane;
    }

    public static void setScene(Scene scene) {
        stage.setScene(scene);

    }

    public static void main(String[] args) {
        launch();
    }

}