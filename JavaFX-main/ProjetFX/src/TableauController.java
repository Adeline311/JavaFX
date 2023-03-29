import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class TableauController implements Initializable
{

    @FXML
    private TableColumn<Etudiant,Integer> Annee;

    @FXML
    private TableColumn<Etudiant,String> Nom;

    @FXML
    private TableColumn<Etudiant,String> Parcours;

    @FXML
    private TableColumn<Etudiant,String> Prenom;

    @FXML
    private TableColumn<Etudiant,String> Promo;

    @FXML
    private TableView<Etudiant> Tableau;
    
    // nouveaux étudiants dans le tableau
    @FXML 
    private TextField NomField;
    
    @FXML 
    private TextField PrenomField;
    
    @FXML 
    private TextField ParcoursField;
    
    @FXML 
    private TextField AnneeField;
    
    @FXML 
    private TextField PromoField;
    
    
    // bouton qui affiche les détails
    @FXML private Button Détails;
    
    public void changeSceneToDetailedPersonView(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Modification.fxml"));
        Parent tableViewParent = loader.load();
        
        Scene tableViewScene = new Scene(tableViewParent);
        
        // //access the controller and call a method
        // EtudiantController controller = loader.getController();
        // controller.initData(Tableau.getSelectionModel().getSelectedItem());
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }
    
    @Override
    public void initialize ( URL url, ResourceBundle rb){
        
    }
    
    }
