
/**
 * Cette classe represente une date formee d'une annee, d'un mois, et d'un jour.
 * NOTE : Les methodes et le constructeur qui modifient le mois, le jour ou 
 *        l'annee de cette date n'empechent pas la formation d'une date 
 *        invalide.
 *
 * @author Melanie Lord
 * @version 2015
 */
public class Date {

   //CONSTANTES DE CLASSE

   public static final int ANNEE_MIN = 1900; //annee min valide
   public static final int ANNEE_MAX = 2015; //annee max valide
   public static final int MOIS_MIN = 1;     //mois min valide
   public static final int MOIS_MAX = 12;    //mois max valide
   public static final int JOUR_MIN = 1;     //jour min valide
   public static final int JOUR_MAX = 31;    //jour max valide
   
   //ATTRIBUTS (VARIABLES D'INSTANCE)
   
   private int annee = 2000;  //l'annee de cette date
   private int mois = 1;      //le mois de cette date
   private int jour = 1;      //le jour de cette date

   //CONSTRUCTEURS
   
   /**
    * Constructeur sans argument qui ne fait rien.
    */
   public Date() {
      //vide
   }
   
   /**
    * Constructeur qui initialise l'annee, le mois et le jour de cette date.
    *
    * @param annee l'annee de cette date. 
    * @param mois le mois de cette date. 
    * @param jour le jour de cette date. 
    */
   public Date(int annee, int mois, int jour) {
      this.annee = annee;
      this.mois = mois;
      this.jour = jour;
   }
   
   //GETTERS
   
   /**
    * Methode qui permet d'obtenir la valeur de l'attribut annee.
    * @return l'annee de cette date.
    */
   public int getAnnee() {
      return annee;
   }

   /**
    * Methode qui permet d'obtenir la valeur de l'attribut mois.
    * @return le mois de cette date.
    */
   public int getMois() {
      return mois;
   }

   /**
    * Methode qui permet d'obtenir la valeur de l'attribut jour.
    * @return le jour de cette date.
    */
   public int getJour() {
      return jour;
   }

   //SETTERS
   
   /**
    * Cette methode permet de modifier la valeur de l'attribut annee.
    * @param annee la nouvelle valeur pour l'annee.
    */
   public void setAnnee(int annee) {
      this.annee = annee;
   }

   /**
    * Cette methode permet de modifier la valeur de l'attribut mois.
    * @param mois la nouvelle valeur pour le mois.
    */
   public void setMois(int mois) {
      this.mois = mois;
   }

   /**
    * Cette methode permet de modifier la valeur de l'attribut jour.
    * @param jour la nouvelle valeur pour le jour.
    */
   public void setJour(int jour) {
      this.jour = jour;
   }

   //AUTRES METHODES D'INSTANCE PUBLIQUES
   
   /**
    * Cette methode determine si l'annee de cette date est bissextile ou non.
    * @return true si l'annee est bissextile, false sinon.
    */
   public boolean estBissex() {
      return (annee % 400 == 0)
              || (annee % 4 == 0 && annee % 100 != 0);
   }

   /**
    * Cette methode retourne cette date sous forme de chaine de caracteres, 
    * sous le format jj/mm/aaaa. Si la date est invalide, le format retourne
    * peut ne pas etre tout a fait juste.
    * @return une chaine de caracteres representant cette date.
    */
   public String formater() {
      String sJour = String.valueOf(jour);
      String sMois = String.valueOf(mois);
     
      if (jour > 0 && jour <= 9) {
         sJour = "0" + jour;
      }
      if (mois > 0 && mois <= 9) {
         sMois = "0" + mois;
      }
      return sJour + "/" + sMois + "/" + annee;
   }
   
   /**
    * Cette methode determine si cette date est une date valide.
    * Une date valide est formee :
    *    - d'une annee entre ANNEE_MIN et ANNEE_MAX inclusivement.
    *    - d'un mois entre MOIS_MIN et MOIS_MAX
    *    - d'un jour entre JOUR_MIN et 28 ou 29 ou 30 ou JOUR_MAX selon le mois 
    *      et selon que l'annee est bissextile ou non.
    *
    * @return true si cette date est valide, false sinon.
    */
   public boolean estDateValide() {
      return annee >= ANNEE_MIN && annee <= ANNEE_MAX 
              && mois >= MOIS_MIN && mois <= MOIS_MAX
              && jourValide();
   }
   
   //METHODE D'INSTANCE PRIVEE
   
   /**
    * Determine si le jour de cette date est valide selon le mois de cette
    * date et selon que l'annee de cette date est bissextile ou non.
    * @return true si le jour de cette date est valide, false sinon.
    */
   private boolean jourValide() {
      boolean valide;
      
      if (jour < JOUR_MIN) {
         valide = false;

      } else {
         //mois de 31 jours
         if (mois == 1 || mois == 3 || mois == 5 || mois == 7
                 || mois == 8 || mois == 10 || mois == 12) {
            valide = jour <= JOUR_MAX;  

         //mois de fevrier
         } else if (mois == 2) {
            valide = (estBissex() && jour <= JOUR_MAX - 2) //29 jours
                    || (jour <= JOUR_MAX - 3);  //28 jours

         //mois de 30 jours
         } else {
            valide = jour <= JOUR_MAX - 1; //30 jours
         }
      }
      return valide;
   }

}
