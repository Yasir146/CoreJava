package com.internshala.connectFour;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    private Controller controller;
    @Override
    public void start(Stage primaryStage) throws Exception {
       FXMLLoader loader=new FXMLLoader(getClass().getResource("game.fxml"));
        GridPane rootGridPane=loader.load();
        controller=loader.getController();
        controller.createPlayground();
        MenuBar menuBar=createMenu();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
         Pane menuPane= (Pane) rootGridPane.getChildren().get(0);
         menuPane.getChildren().addAll(menuBar);

        Scene scene=new Scene(rootGridPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Connect Four");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    private MenuBar createMenu(){
        Menu fileMenu=new Menu("File");
        MenuItem newgame=new MenuItem("New Game");
        newgame.setOnAction(event -> controller.resetGame());
        MenuItem resetGame=new MenuItem("Reset");
        resetGame.setOnAction(event -> controller.resetGame());
        SeparatorMenuItem separatorMenuItem=new SeparatorMenuItem();
        MenuItem exitGame=new MenuItem("Exit");
        exitGame.setOnAction(event -> exit());
        fileMenu.getItems().addAll(newgame,resetGame,separatorMenuItem,exitGame);
        //helpMenu
        Menu helpMenu=new Menu("Help");
        MenuItem aboutMe=new MenuItem("About Me");
        aboutMe.setOnAction(event -> aboutMe());
        SeparatorMenuItem separator=new SeparatorMenuItem();
        MenuItem aboutGame=new MenuItem("About Game ");
        aboutGame.setOnAction(event -> aboutGame());
        helpMenu.getItems().addAll(aboutGame,separator,aboutMe);

        MenuBar menuBar=new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);
        return menuBar;
    }

    private void aboutMe() {
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Developer");
        alert.setHeaderText("Mohammad Yasir");
        alert.setContentText("i like coding");
        alert.show();
    }

    private void aboutGame() {
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("about Connect Four");
        alert.setHeaderText("How To Play?");
        alert.setContentText("Connect Four is a two-player connection game in which the players first choose a color and then take turns dropping colored discs from the top into a seven-column, six-row vertically suspended grid. The pieces fall straight down, occupying the next available space within the column. The objective of the game is to be the first to form a horizontal, " +
                "vertical, or diagonal line of four of one's own discs. Connect Four is a solved game. The first player can always win by playing the right moves.");
        alert.show();
    }

    private void exit() {
        Platform.exit();
        System.exit(0);
    }

    private void reset() {
    }

    public static void main(String[] args) {
        launch(args);
    }
}
