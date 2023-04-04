import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class infoController 
{

    // bouton qui affiche les détails
    @FXML private Button details;
    @FXML private Button main;
    @FXML private Button info;
    @FXML private Button gestion;
  
    public void SwitchToMain(ActionEvent event) throws IOException
    {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Main.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage) main.getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
        
    }
    
    public void SwitchToGestion(ActionEvent event) throws IOException
    {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("test.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage) gestion.getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
        
    }
    
    public void SwitchToInfo(ActionEvent event) throws IOException
    {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("info.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage) info.getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
        
    }
    
    }
