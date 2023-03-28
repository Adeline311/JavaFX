import javafx.beans.property.SimpleStringProperty;
/**
 * Décrivez votre classe Etudiant ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Etudiant
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    int Annee;
    String Nom,Parcours, Promo,Prenom;
    
    public Etudiant(int Annee,String Nom, String Parcours,String Promo, String Prenom)
    {
        this.Annee = Annee;
        this.Nom = Nom;
        this.Parcours = Parcours;
        this.Promo = Promo;
        this.Prenom = Prenom;
    }
    
    /**
     * @return l'année de naissance
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
     * @return le nom de l'étudiant
     */
    public String getNom(){
        return Nom;
    }
    
    /**
     * @param Parcours
     */
    public void setNom( String Nom){
        this.Nom = Nom;
    }
    
    /**
     * @return le parcours de l'étudiant
     */
    public String getParcours(){
        return Parcours;
    }
    
    /**
     * @param Parcours
     */
    public void setParcours( String Parcours){
        this.Parcours= Parcours;
    }
    
    /**
     *@return la promo 
     */
    public String getPromo(){
        return Promo;
    }
    
    /**
     * @param Promo
     */
    public void setPromo(){
        this.Promo = Promo;
    }
    
    /**
     * @return le prénom de l'étudaint
     */
    public String getPrenom(){
        return Prenom;
    }
    
    /**
     * @param Prenom
     */
    public void setPrenom(){
        this.Prenom = Prenom;
    }
    
}
