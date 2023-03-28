import javafx.fxml.Initializable; 
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.fxml.FXML;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.control.cell.PropertyValueFactory;
import java.awt.event.ActionEvent;


/**
 * Décrivez votre classe Tableau ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
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
    
    ObservableList<Etudiant> list = FXCollections.observableArrayList(
        new Etudiant(1999,"Guilizzoni","ECMPS","M1","Giacom"),
        new Etudiant(2000,"Botton","GPHY","M2","Marco"),
        new Etudiant(2003,"Maclacha","GCELL","M1","Maria"),
        new Etudiant(2002,"Liberty","GPHY","M2","Valerie"),
        new Etudiant(2000,"Puisais","GPHY","M1","Adeline"));
    
    @Override
    public void initialize ( URL url, ResourceBundle rb){
        Annee.setCellValueFactory(new PropertyValueFactory<Etudiant,Integer>("Annee"));
        Nom.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("Nom"));
        Parcours.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("Parcours"));
        Prenom.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("Prenom"));
        Promo.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("Promo"));
        
        Tableau.setItems(list);
    
    }
    
    }
