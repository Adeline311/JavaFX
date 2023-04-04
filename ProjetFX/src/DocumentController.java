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
import java.util.List;

import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.logging.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;



public class DocumentController implements Initializable
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
    private TableColumn<Etudiant,Integer> ID;

    @FXML
    private TableView<Etudiant> Tableau;
    
    @FXML
    private TextField anneeField;

    @FXML
    private TextField nomField;

    @FXML
    private TextField parcoursField;

    @FXML
    private TextField prenomField;

    @FXML
    private TextField promoField;

    @FXML
    private TextField IDField;
    
    ObservableList<Etudiant> listeM;
    int index = -1;
    
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    @FXML private Button info;
    @FXML private Button main;
    @FXML
    private Button ajout;
    
    
    @FXML
    void Selection (MouseEvent event){
        index = Tableau.getSelectionModel().getSelectedIndex();       
        if (index <=-1){
            return;
        }
        nomField.setText(Nom.getCellData(index).toString());
        prenomField.setText(Prenom.getCellData(index).toString());
        anneeField.setText(Annee.getCellData(index).toString());
        parcoursField.setText(Parcours.getCellData(index).toString());
        promoField.setText(Promo.getCellData(index).toString());
        IDField.setText(ID.getCellData(index).toString());
        
        UpdateTable();
        ajout.setDisable(true);
    }
    
    public void Clear(){
        nomField.clear();
        prenomField.clear();
        parcoursField.clear();
        promoField.clear();
        IDField.clear();
        anneeField.clear();
        ajout.setDisable(false);
        
    }
    
    public void Supprimer(){
        conn = mysqlconnect.ConnectDb();
        String sql = "delete from etudiant where ID = ?";
        try{
           pst = conn.prepareStatement(sql);
           pst.setString(1,IDField.getText());
           
           Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
           alert.setTitle("Confirmation");
           alert.setHeaderText("Confirmez vous la supression de l'étudiant ? ");
           
        if (alert.showAndWait().get() == ButtonType.OK){
            pst.execute();
            Clear();
            UpdateTable();
            ajout.setDisable(false);}
        else{
           System.out.println("Annulation");  }
    
        }catch(Exception e){
            e.printStackTrace();
                System.out.println("Impossible de supprimer un étudiant");  
        }
    }
    
    public void Modifier (){
        try{
            conn = mysqlconnect.ConnectDb();
            
            String value1 = nomField.getText();
            String value2 = prenomField.getText();
            String value3 = anneeField.getText();
            String value4 = parcoursField.getText();
            String value5 = promoField.getText();
            String value6 = IDField.getText();
            
            String sql = "Update etudiant set Nom= '"+value1+"',Prenom= '"+value2+"',Annee='"+value3+"',Parcours='"+value4+"',Promo='"+value5+"',ID='"+value6+"'where ID='"+value6+"' ";
            pst = conn.prepareStatement(sql);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Confirmez vous la modification de l'étudiant ? ");
           
        if (alert.showAndWait().get() == ButtonType.OK){
            pst.execute();
            Clear();
            UpdateTable();
            ajout.setDisable(false);}
        else{
           System.out.println("Annulation");  }
    
        }catch(Exception e){
        e.printStackTrace();
                System.out.println("Impossible de modifier un étudiant");            
        }
    }
    public void ajouterEtudiant()
    {
        conn = mysqlconnect.ConnectDb();
        int cpt = 0;
        String sql = "INSERT into etudiant (Nom,Prenom,Annee,Parcours,Promo,ID) values(?,?,?,?,?,?)";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1,nomField.getText());
            pst.setString(2,prenomField.getText());
            pst.setString(3,anneeField.getText());
            pst.setString(4,parcoursField.getText());
            pst.setString(5,promoField.getText());
            pst.setString(6,IDField.getText());
            
            if (nomField.getText().isEmpty() | prenomField.getText().isEmpty() | anneeField.getText().isEmpty() | parcoursField.getText().isEmpty()
            | promoField.getText().isEmpty() | IDField.getText().isEmpty()){
           
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Formulaire non complet");
            alert.setContentText("Veuillez completer le formulaire entièrement ");
            alert.show();
            
            }else {
                    int t = getTestEtu();
                    if (t==1){
                    pst.execute();
                    UpdateTable();
                }
                
            }

        }catch (Exception e){
            e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText("CCEtudiant déjà présent dans le tableau");
                alert.setContentText("Veuillez modifier ");
                alert.showAndWait();
                System.out.println("Impossible d'ajouter un étudiant");
        }
    }

    
    public int getTestEtu()  {
    Connection conn = mysqlconnect.ConnectDb();
    String value1 = nomField.getText();
    String value2 = prenomField.getText();  
    Boolean result;
    int r = 0;
    System.out.println("TEST");
    try {

        PreparedStatement ps = conn.prepareStatement("select * from Etudiant where Nom= '"+value1+"' and  Prenom= '"+value2+"'");
        ResultSet rs = ps.executeQuery();
        result = rs.next();
        if (result == true){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText("Etudiant déjà présent dans le tableau");
                alert.setContentText("Veuillez modifier ");
                alert.show();
                
            } else{
                r=1;
            }

    }catch (Exception e) {
        // TODO Auto-generated catch block
                e.printStackTrace();
                System.out.println("Erreur select");
        
            }
     return r ;
     }
   
    public void UpdateTable(){
        Nom.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("Nom"));
        Prenom.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("Prenom"));
        Annee.setCellValueFactory(new PropertyValueFactory<Etudiant,Integer>("Annee"));
        Parcours.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("Parcours"));
        Promo.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("Promo"));
        ID.setCellValueFactory(new PropertyValueFactory<Etudiant,Integer>("ID"));
        listeM = mysqlconnect.getEtu();
        Tableau.setItems(listeM);
    }
    @Override
    public void initialize ( URL url, ResourceBundle rb){
        UpdateTable();
        
    }
    
    public void SwitchToMain(ActionEvent event) throws IOException
    {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Main.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage) main.getScene().getWindow();
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
    
    