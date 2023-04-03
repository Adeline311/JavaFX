package src;

import javafx.beans.property.SimpleStringProperty;

/**

 */
public class Etudiant
{
    private SimpleStringProperty Nom, Prenom, Promo,Parcours;
    private int Annee;
    public Etudiant(String Nom, String Prenom, int Annee,String Parcours,String Promo)
    {
        this.Nom = new SimpleStringProperty(Nom);
        this.Prenom = new SimpleStringProperty(Prenom);
        this.Annee = Annee;
        this.Parcours = new SimpleStringProperty(Parcours);
        this.Promo = new SimpleStringProperty(Promo);
    }
    
    /**
     * @return l'annee de naissance
     */
    public int getAnnee(){
        return Annee;
    }
    
    /**
     * @param Annee
     */
    public void setAnnee (int Annee){
        this.Annee = Annee;
    }
    
    /**
     * @return le nom de l'Etudiant
     */
    public String getNom(){
        return Nom.get();
    }
    
    /**
     * @param Parcours
     */
    public void setNom( String Nom){
        this.Nom = new SimpleStringProperty(Nom);
    }
    
    /**
     * @return le parcours de l'Etudiant
     */
    public String getParcours(){
        return Parcours.get();
    }
    
    /**
     * @param Parcours
     */
    public void setParcours( String Parcours){
        this.Parcours= new SimpleStringProperty(Parcours);
    }
    
    /**
     *@return la promo 
     */
    public String getPromo(){
        return Promo.get();
    }
    
    /**
     * @param Promo
     */
    public void setPromo(String Promo){
        this.Promo = new SimpleStringProperty(Promo);
    }
    
    /**
     * @return le prenom de l'Etudaint
     */
    public String getPrenom(){
        return Prenom.get();
    }
    
    /**
     * @param Prenom
     */
    public void setPrenom(String Prenom){
        this.Prenom = new SimpleStringProperty(Prenom);
    }
    
}
