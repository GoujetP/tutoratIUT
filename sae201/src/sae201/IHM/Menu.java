package IHM;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Menu extends Application {
    // labels
    Label l;
 
    // launch the application
    public void start(Stage s){
    	
        // set title for the stage
        s.setTitle("creating MenuButton ");
 
        // create a tile pane
       // TilePane r = new TilePane();
 
        // create a label
        Label l1 = new Label("This is a MenuButton example ");
 
        // create a menu button
        MenuButton m1 = new MenuButton("Consutation");
        MenuButton m2 = new MenuButton("Modifications");
        MenuButton m3 = new MenuButton("EXIT");
 
 
        // create a tilepane
        TilePane vb = new TilePane(l1, m1, m2, m3);
 
        // create a scene
        Scene sc = new Scene(vb, 200, 200);
        // set the scene
        s.setScene(sc);
 
        s.show();
    }
 
    public static void main(String args[]){
        // launch the application
    	Application.launch(args);
    }
}