package menus;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    Scene scene;
    BorderPane borderPane;
    Menu fileMenu;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Menus");

        // File Menu
        fileMenu = new Menu("_File");

        // File Menu Items
        MenuItem newFile = new MenuItem("New...");
        newFile.setOnAction(e -> {
            System.out.println("New File");
        });
        MenuItem openFile = new MenuItem("Open...");
        openFile.setOnAction(e -> {
            System.out.println("Open File");
            NewFileWindow.displayNewFile();
        });
        fileMenu.getItems().add(newFile);
        fileMenu.getItems().add(openFile);
        fileMenu.getItems().add(new MenuItem("Save..."));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Settings..."));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Exit..."));

        // Edit menu
        Menu editMenu = new Menu("_Edit");

        // Edit Menu Items
        editMenu.getItems().add(new MenuItem("Cut"));
        editMenu.getItems().add(new MenuItem("Copy"));
        MenuItem paste = new MenuItem("Paste");
        paste.setOnAction(e -> System.out.println("Paste"));
        paste.setDisable(true);
        editMenu.getItems().add(paste);

        // Help Menu
        Menu helpMenu = new Menu("_Help");
        CheckMenuItem showLines = new CheckMenuItem("Show Line Numbers");
        showLines.setOnAction(e -> {
            if (showLines.isSelected()) {
                System.out.println("Display Line Numbers");
            } else {
                System.out.println("Hiding Line Numbers");
            }
        });
        CheckMenuItem autoSave = new CheckMenuItem("Enable Autosave");
        autoSave.setSelected(true);
        helpMenu.getItems().addAll(showLines, autoSave);

        // Difficulty RadioMenu
        Menu difficultyMenu = new Menu("Difficulty");

        // Difficulty RadioMenuItems
        ToggleGroup difficultyToggle = new ToggleGroup();

        // RadioMenuItems
        RadioMenuItem easy = new RadioMenuItem("Easy");
        RadioMenuItem medium = new RadioMenuItem("Medium");
        RadioMenuItem hard = new RadioMenuItem("Hard");

        // Adding the RadioMenuItems to ToggleGroup object
        easy.setToggleGroup(difficultyToggle);
        medium.setToggleGroup(difficultyToggle);
        hard.setToggleGroup(difficultyToggle);

        // Adding RadioMenuItems to the Menu
        difficultyMenu.getItems().addAll(easy, medium, hard);

        // Menu Bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu, difficultyMenu);

        // Layout and Stage
        borderPane = new BorderPane();
        borderPane.setTop(menuBar);
        scene = new Scene(borderPane, 400,300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}