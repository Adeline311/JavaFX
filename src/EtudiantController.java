package src;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author jwright
 */
public class EtudiantController implements Initializable {

    private Etudiant selectedEtudiant;
    
    @FXML private Label NomLabel;
    @FXML private Label PrenomLabel;    
    @FXML private Label AnneeLabel;
    @FXML private Label ParcoursLabel;
    @FXML private Label PromoLabel;
    
    /**
     * This method accepts a person to initialize the view
     * @param person 
     */
    public void initData(Etudiant etudiant)
    {
        selectedEtudiant = etudiant;
        NomLabel.setText(selectedEtudiant.getNom());
        PrenomLabel.setText(selectedEtudiant.getPrenom());
        AnneeLabel.setText(Integer.toString(selectedEtudiant.getAnnee()));
        ParcoursLabel.setText(selectedEtudiant.getParcours());
        PromoLabel.setText(selectedEtudiant.getPromo());
    }
    
    
    public void SwitchToPrincipal(ActionEvent event) throws IOException
    {
        Parent Parent = FXMLLoader.load(getClass().getResource("test.fxml"));
        Scene Scene = new Scene(Parent);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(Scene);
        window.show();
    }
    
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
