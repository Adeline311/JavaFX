import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
public class SceneController
{
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    public void switchToMain(ActionEvent event) throws java.io.IOException {
       root = FXMLLoader.load(getClass().getResource("Main.fxml")); 
       stage = (Stage)((Node)event.getSource()).getScene().getWindow();
       scene= new Scene(root);
       stage.setScene(scene);
       stage.show();
       
    }
    
    public void switchToList (ActionEvent event) throws java.io.IOException {
       root = FXMLLoader.load(getClass().getResource("Liste.fxml")); 
       stage = (Stage)((Node)event.getSource()).getScene().getWindow();
       scene= new Scene(root);
       stage.setScene(scene);
       stage.show(); 
    }
    
    public void switchToFormulaire (ActionEvent event) throws java.io.IOException {
       root = FXMLLoader.load(getClass().getResource("Formulaire.fxml")); 
       stage = (Stage)((Node)event.getSource()).getScene().getWindow();
       scene= new Scene(root);
       stage.setScene(scene);
       stage.show(); 
    }
    
    public void switchToModification (ActionEvent event) throws java.io.IOException {
       root = FXMLLoader.load(getClass().getResource("Modification.fxml")); 
       stage = (Stage)((Node)event.getSource()).getScene().getWindow();
       scene= new Scene(root);
       stage.setScene(scene);
       stage.show(); 
    }

    
}
