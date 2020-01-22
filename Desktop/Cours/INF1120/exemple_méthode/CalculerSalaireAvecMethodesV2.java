
/**
 * Cette classe est une application qui permet de calculer les salaires
 * hebdomadaires d'employes d'une entreprise d'apres le nombre d'heures de
 * travail pendant la semaine et le taux salarial horaire de chaque employe.
 * 
 * Cette version utilise la methode plus generale validerReel pour saisir 
 * et valider le nombre d'heures travaillees, et le taux horaire.
 *
 * @author Melanie Lord
 * @version 10 octobre 2015
 */
public class CalculerSalaireAvecMethodesV2 {
   
   // ------------
   // CONSTANTES
   // ------------
   //le taux salarial horaire maximum
   public static final double TAUX_MAX = 17.35;

   //le taux salarial horaire minimum
   public static final double TAUX_MIN = 8.55;

   //Le nombre max valide d'heures travaillees
   public static final double NBR_HR_MAX = 80;

   //Le nombre min valide d'heures travaillees
   public static final double NBR_HR_MIN = 0;

   //le nombre d'heures normal pour une semaine
   public static final double NBR_HR_NORMAL = 40;

   //facteur multiplicatif du salaire pour les heures sup.
   public static final double TEMPS_SUP = 1.5;

   //message de sollicitation du taux horaire
   public static final String MSG_SOL_TAUX_HORAIRE = "Entrez le taux horaire : ";

   //message de sollicitation du nombre d'heures travaillees
   public static final String MSG_SOL_NBR_HEURES = "Entrez le nombre d’heures "
           + "travaillées : ";

   //message d'erreur pour un taux horaire invalide
   public static final String MSG_ERR_TAUX_HORAIRE = "Erreur. Le taux horaire "
           + "doit se trouver entre " + TAUX_MIN + " et " + TAUX_MAX 
           + " inclusivement.\n";

   //message d'erreur pour un nombre d'heures invalide
   public static final String MSG_ERR_NBR_HEURES = "Erreur. Le nombre d'heures "
           + "doit se trouver entre " + NBR_HR_MIN + " et " + NBR_HR_MAX 
           + " inclusivement.\n";

   //message de présentation du logiciel
   public static final String MSG_PRESENTATION = "Ce logiciel permet de "
           + "calculer les salaires\nhebdomadaires des employes d'une "
           + "entreprise.\n\n\n";

   //message de fin du programme
   public static final String MSG_FIN = "\n\n\n\n\nFin normale du programme.";
   
   
   // ------------
   // METHODES
   // ------------
   
   /**
    * Provoque l'arret du programme et demande d'entrer un 
    * ENTER pour continuer.
    */
   public static void pause () {
      System.out.print("Taper ENTER pour continuer...");
      Clavier.lireFinLigne();
      System.out.println("\n");
   }
   
   /**
    * Affiche une breve presentation du logiciel.
    */
   public static void presenterLogiciel () {
      System.out.println(MSG_PRESENTATION);
      pause(); //appel de la methode pause()
   }
   
   /**
    * Demande de saisir un nombre reel et le valide entre les bornes donnees 
    * min et max.
    * @param msgSoll le message de sollicitation du nombre reel.
    * @param msgErr le message d'erreur pour un nombre entre invalide.
    * @param min la borne inferieure pour un nombre valide.
    * @param max la borne superieure pour un nombre valide.
    * @return un nombre reel valide.
    */
   public static double validerReel(String msgSoll, String msgErr, double min,
           double max) {
      double nbrReel;  //le nbr heures saisi
      
      //saisir et valider le nombre d'heures travaillees
      System.out.print(msgSoll);
      nbrReel = Clavier.lireDouble();
      while (nbrReel < min || nbrReel > max) {
         System.out.println(msgErr);
         System.out.print(msgSoll);
         nbrReel = Clavier.lireDouble();
      }
      return nbrReel;
   }

   /**
    * Calcule le salaire hebdomadaire selon le nombre d'heures
    * travaillees et le taux salarial horaire donnes. Les heures  
    * travaillees apres NBR_HR_NORMAL heures sont calculees a temps 
    * et demi.
    * @param nbrHr le nombre d'heures travaillees.
    * @param tauxHr le taux salarial horaire.
    * @return le salaire hebdomadaire.
    */
   public static double calculerSalaireHebdo (double nbrHr, double tauxHr) {
      double salaire; //le salaire hebdo calcule
      
      //calcul du salaire selon que le nombre d'heures depasse ou non
      //NBR_HR_NORMAL.
      if (nbrHr <= NBR_HR_NORMAL) {
         salaire = nbrHr * tauxHr;
      } else {
         salaire = (nbrHr - NBR_HR_NORMAL) * tauxHr * TEMPS_SUP 
                 + NBR_HR_NORMAL * tauxHr;
      }
      return salaire;
   }
   
   /**
    * Affiche le salaire hebdomadaire donne (arrondi a 2 decimales).
    * @param salaireHebdo le salaire a afficher.
    */
   public static void afficherSalaireHebdo (double salaireHebdo) {
      System.out.printf("\nSalaire hebdomadaire : %10.2f $\n\n", salaireHebdo);

   }
   
   /**
    * Affiche un message de fin du programme.
    */
   public static void afficherFinProg () {
      System.out.println(MSG_FIN);
   }

   /**
    * Application de calcul de salaires hebdomadaires.
    * @param params (tableau vide)
    */
   public static void main(String[] params) {

      //declarations des variables
      double nbrHeures;       //le nombre d'heures travaillees
      double tauxHoraire;     //le taux salariale horaire 
      double salaireHebdo;    //le salaire hebdomadaire

      //presenter le logiciel
      presenterLogiciel();
      
      //saisir et valider le nbr d'heures travaillees
      nbrHeures = validerReel(MSG_SOL_NBR_HEURES, MSG_ERR_NBR_HEURES,
              NBR_HR_MIN, NBR_HR_MAX);

      while (nbrHeures != NBR_HR_MIN) {
         
         //saisir et valider le taux horaire
         tauxHoraire = validerReel(MSG_SOL_TAUX_HORAIRE, MSG_ERR_TAUX_HORAIRE,
                 TAUX_MIN, TAUX_MAX);

         //Calculer le salaire hebdo
         salaireHebdo = calculerSalaireHebdo (nbrHeures, tauxHoraire);

         //afficher le salaire hebdo
         afficherSalaireHebdo(salaireHebdo);

         //saisir et valider le nbr d'heures travaillees
         nbrHeures = validerReel(MSG_SOL_NBR_HEURES, MSG_ERR_NBR_HEURES,
              NBR_HR_MIN, NBR_HR_MAX);
      }
      
      //afficher la fin du programme
      afficherFinProg();

   }


}
