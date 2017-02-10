package controller;

import javafx.scene.Node;
import javafx.stage.Stage;

/**
 * Created by dmitry on 10.02.17.
 */
public class GraphicsLoader {
    public static void closeWindow(Node node) {
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }
}
