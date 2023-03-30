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
    private TableColumn<Etudiant,String> Nom;
    
    @FXML
    private TableColumn<Etudiant,String> Prenom;
    
    @FXML
    private TableColumn<Etudiant,Integer> Annee;

    @FXML
    private TableColumn<Etudiant,String> Parcours;

    @FXML
    private TableColumn<Etudiant,String> Promo;

    @FXML
    private TableView<Etudiant> Tableau;
    
    // nouveaux étudiants dans le tableau
    @FXML 
    private TextField nomField;
    
    @FXML 
    private TextField prenomField;
    
    @FXML 
    private TextField  anneeField;
    
    @FXML 
    private TextField parcoursField;
    
    @FXML 
    private TextField promoField;
    
    
    // bouton qui affiche les détails
    @FXML private Button details;
    @FXML private Button test;
    @FXML private Button info;
    @FXML private Button gestion;
    @FXML
    private Parent root ;
    public void modifNomEvent(CellEditEvent edittedCell)
    {
        Etudiant etudiantSelected =  Tableau.getSelectionModel().getSelectedItem();
        etudiantSelected.setNom(edittedCell.getNewValue().toString());
    }
    
    // public void userClickedOnTable()
    // {
        // this.details.setDisable(false);
    // }
    
    public void modifPrenomEvent(CellEditEvent edittedCell)
    {
        Etudiant etudiantSelected =  Tableau.getSelectionModel().getSelectedItem();
        etudiantSelected.setPrenom(edittedCell.getNewValue().toString());
    }
    
    public void changeSceneToDetailedPersonView(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Modification.fxml"));
        Parent tableViewParent = loader.load();
        
        Scene tableViewScene = new Scene(tableViewParent);
        
        //access the controller and call a method
        EtudiantController controller = loader.getController();
        controller.initData(Tableau.getSelectionModel().getSelectedItem());
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }
    public void SwitchToMain(ActionEvent event) throws IOException
    {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Main.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage) test.getScene().getWindow();
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
    
    /**
     * Initialise le tableau
     */
    @Override
    public void initialize ( URL url, ResourceBundle rb){
        Nom.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("Nom"));
        Prenom.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("Prenom"));
        Annee.setCellValueFactory(new PropertyValueFactory<Etudiant,Integer>("Annee"));
        Parcours.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("Parcours"));
        Promo.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("Promo"));
        
        // enregistre les données
        Tableau.setItems(getEtu());
        
        //fonction pour que la msj des données soit possible
        Tableau.setEditable(true);
        Nom.setCellFactory(TextFieldTableCell.forTableColumn());
        Prenom.setCellFactory(TextFieldTableCell.forTableColumn());
        Parcours.setCellFactory(TextFieldTableCell.forTableColumn());
        Promo.setCellFactory(TextFieldTableCell.forTableColumn());
        
        //Sélection multiple
        Tableau.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        //désactive le bouton détails lors d'une modification
        //this.details.setDisable(true);
        
    }
    public void ajouterEtudiant()
    {
        Etudiant newEtudiant = new Etudiant(nomField.getText(),prenomField.getText(),Integer.parseInt(anneeField.getText()),parcoursField.getText(),promoField.getText());
        
        Tableau.getItems().add(newEtudiant);
        
    }
    
    public void SuppEtudiant()
    {
        ObservableList<Etudiant> selectedRows, allPeople;
        allPeople=Tableau.getItems();
        
        // Récupère les lignes sélectionnés
        selectedRows = Tableau.getSelectionModel().getSelectedItems();
        
        //supprime les lignes sélectionnés
        for (Etudiant etudiant: selectedRows)
        {
            allPeople.remove(etudiant);
        }
        
    }
    
    public ObservableList<Etudiant>  getEtu()
    {
        ObservableList<Etudiant> etudiant = FXCollections.observableArrayList();
        etudiant.add(new Etudiant("Guilizzoni","Giacom",1999,"ECMPS","M1"));
        etudiant.add(new Etudiant("Botton","Marco",1998,"GPHY","M2"));
        etudiant.add(new Etudiant("Maclacha","Maria",2003,"GCELL","M1"));
        etudiant.add(new Etudiant("Liberty","Valerie",2002,"GPHY","M2"));
        etudiant.add(new Etudiant("Puisais","Adeline",2000,"GPHY","M1"));
        return etudiant;
    }
    }
