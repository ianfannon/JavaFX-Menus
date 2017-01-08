package menus;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Date;

/**
 * Created by Ian James Fannon on 1/7/2017.
 */
public class NewFileWindow {

    private static TableView<Table> table;

    public static void displayNewFile() {
        Stage stage = new Stage();
        stage.setTitle("File Menu");

        // Buttons
        Button open = new Button("Open");
        Button copy = new Button("Copy");
        Button delete = new Button("Delete");
        delete.setOnAction(e -> deleteFile());

        // Table View
        TableColumn<Table, String> fileName = new TableColumn<>("File Name");
        fileName.setMinWidth(100);
        fileName.setCellValueFactory(new PropertyValueFactory<>("fileName"));

        TableColumn<Table, Double> fileSize = new TableColumn<>("Size");
        fileSize.setMinWidth(50);
        fileSize.setCellValueFactory(new PropertyValueFactory<>("fileSize"));

        TableColumn<Table, String> fileDate = new TableColumn<>("Date Created");
        fileDate.setMinWidth(50);
        fileDate.setCellValueFactory(new PropertyValueFactory<>("format"));

        // Adding the TableColumns to the TableView
        table = new TableView<>();
        table.setItems(getFiles());
        table.getColumns().addAll(fileName, fileSize, fileDate);

        // Layout
        BorderPane borderPane = new BorderPane();
        HBox bottom = new HBox();
        bottom.setPadding(new Insets(10,10,10,10));
        bottom.setSpacing(10);
        bottom.getChildren().addAll(open, copy, delete);
        borderPane.setCenter(table);
        borderPane.setBottom(bottom);

        // Stage
        Scene scene = new Scene(borderPane, 400, 250);
        stage.setScene(scene);
        stage.showAndWait();
    }

    /**
     * This method adds a file to the Table
     * @return the ObservableList object files
     */
    private static ObservableList<Table> getFiles() {
        ObservableList<Table> files = FXCollections.observableArrayList();
        Table table = new Table();
        Date time = new Date();
        long date = time.getTime();
        files.add(new Table("Journal.doc", 58, String.format("1/7/2017")));
        files.add(new Table("Contacts.csv", 169, String.format("1/7/2017")));
        files.add(new Table("Solitare.exe", 289.00, String.format("1/7/2017")));
        return files;
    }

    /**
     * This method deletes items from the file Table
     */
    private static void deleteFile() {
        ObservableList<Table> filesSelected, allFiles;
        allFiles = table.getItems();
        filesSelected = table.getSelectionModel().getSelectedItems();

        filesSelected.forEach(allFiles::remove);
    }
}
