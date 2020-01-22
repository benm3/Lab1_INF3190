
/**
 * Cette application demande a l'utilisateur d'entrer la date de naissance 
 * d'un personne (1920 <= annee <= 2007) et affiche ensuite si cette personne 
 * est majeure ou mineure.
 * 
 * @author Melanie Lord
 * @version 1 novembre 2015
 */
public class AgeMajeureOuMineure {
   
   //constantes de classe
   public final static int ANNEE_REF = 2007; //annee date reference 
   public final static int MOIS_REF = 05;    //mois date reference
   public final static int JOUR_REF = 12;    //jour date reference
   public final static int AGE_MAJEUR = 18;  //Age de la majorite
   public final static int ANNEE_MIN = 1920;	//annee minimum valide
   public final static int ANNEE_MAX = 2007; //annee date reference 
   public final static int MOIS_MIN = 1;     //mois minimum valide
   public final static int MOIS_MAX = 12;	   //mois maximum valise
   
   /**
    * Affiche une breve presentation du logiciel.
    */
   public static void presenterLogiciel () {
      String jourRef = "" + JOUR_REF; //jour de reference formate sur deux positions
      String moisRef = "" + MOIS_REF; //mois de reference formate sur deux positions
      if (JOUR_REF < 9) {
         jourRef = "0" + JOUR_REF;
      }
      if (MOIS_REF < 9) {
         moisRef = "0" + MOIS_REF;
      }
      System.out.println("Ce programme permet de determiner si une personne"
              + " est majeure \nou mineure, en date du " + jourRef + "/" + 
              moisRef + "/" + ANNEE_REF + ".");
      
      System.out.print("\nTaper ENTREE pour continuer...");
      Clavier.lireFinLigne();
      System.out.println();
   }
   
   public static void finProgramme () {
      System.out.println("\nFin normale du programme.\n");
   }
   
   /**
    * Cette methode saisit et valide un entier entre min et max inclus.
    *
    * @param msgSoll le message de sollicitation
    * @param msgErr le message d'erreur si l'entier saisi n'est pas entre min et
    *               max inclus.
    * @param min la valeur minimale permise pour l'entier a valider. Doit etre
    *            plus petite ou egale a max.
    * @param max la valeur maximale permise pour l'entier a valider. Doit etre
    *            plus grande ou egale a min.
    * @return un entier valide entre min et max inclusivement.
    */
   public static int validerEntier(String msgSoll, String msgErr,
           int min, int max) {
      
      int unEntier;  //entier valide a retourner

      do {
         System.out.print(msgSoll);
         unEntier = Clavier.lireInt();

         if (unEntier < min || unEntier > max) {
            System.out.println("\n" + msgErr);
         }

      } while (unEntier < min || unEntier > max);

      return unEntier;
   }

   /**
    * Cette methode retourne vrai si l'annee est bissextile, faux sinon.
    *
    * @param annee l'annee dont on doit determiner si elle est bissextile ou
    *              non.
    * @return true si l'annee est bissextile, false sinon.
    */
   public static boolean estBissextile(int annee) {
      boolean bissex = false; //vrai si l'annee est bissextile, faux sinon

      if (annee % 400 == 0 || (annee % 4 == 0 && annee % 100 != 0)) {
         bissex = true;
      }

      return bissex;
   }

   /**
    * Cette methode retourne vrai si le jour d'une date est valide par rapport
    * au mois et a l'annee donnee.
    *
    * @param jour le jour de la date (a valider).
    * @param mois le mois de la date.
    * @param annee l'annee de la date.
    * @return true si le jour est valide, false sinon.
    */
   public static boolean jourValide(int jour, int mois, int annee) {

      boolean valide = true;  //vrai si le jour est valide, faux sinon
      boolean bissex;         //vrai si annee est bissextile, faux sinon

      bissex = estBissextile(annee);

      if (jour < 1) {
         valide = false;
      } else {

         switch (mois) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:

               if (jour > 31) {
                  valide = false;
               }
               break;

            case 2:
               if (bissex) {
                  if (jour > 29) {
                     valide = false;
                  }
               } else {
                  if (jour > 28) {
                     valide = false;
                  }
               }
               break;

            case 4:
            case 6:
            case 9:
            case 11:
               if (jour > 30) {
                  valide = false;
               }
               break;

         } //fin switch

      } //fin if

      return valide;
   }

   /**
    * Cette methode valide le jour d'une date selon le mois de cette date et
    * selon que l'annee est bissextile ou non.
    *
    * @param mois le mois de la date a valider
    * @param annee l'annee de la date a valider
    * @return true si le jour est valide, faux sinon.
    */
   public static int validerJour(int mois, int annee) {

      boolean valide;     //true si le jour est valide, faux sinon
      int jour;           //Le jour a valider

      do {
         System.out.print("Entrez le jour : ");
         jour = Clavier.lireInt();

         valide = jourValide(jour, mois, annee);

         if (!valide) {
            System.out.println("\nErreur, jour invalide... recommencez.");
         }

      } while (!valide);

      return jour;
   }

   /**
    * Verifie si une personne avec la date de naissance donnee en parametre
    * est majeure ou mineure en date du 12/05/2007.
    * @param annee l'annee de naissance de la personne (doit etre <= 2007)
    * @param mois le mois de naissance de la personne
    * @param jour le jour de naissance de la personne
    * @return true si la personne est majeure, faux sinon.
    */
   public static boolean estMajeure(int annee, int mois, int jour) {
      int nbrAnnee = ANNEE_REF - annee; //nombre d'annees de difference avec
                                        //l'annee de reference.
      boolean estMajeur = false;

      if (nbrAnnee > AGE_MAJEUR) {
         estMajeur = true;

      } else if (nbrAnnee == AGE_MAJEUR) {
         if (MOIS_REF > mois) {
            estMajeur = true;
         } else if (MOIS_REF == mois) {
            if (JOUR_REF >= jour) {
               estMajeur = true;
            }
         }
      }
      return estMajeur;
   }

   /**
    * Saisit et valide la reponse de l'utilisateur a savoir s'il veut recommencer
    * ou terminer le programme. Une reponse valide est 'o' ou 'O' pour OUI et 
    * 'n' ou 'N' pour non.
    * @return true si l'utilisateur a entre 'o' ou 'O', false sinon.
    */
   public static boolean encore() {
      char rep; //reponse de l'utilisateur

      System.out.print("Voulez-vous entrez une autre date (o/n): ");
      rep = Clavier.lireCharLn();
      rep = Character.toUpperCase(rep);

      while (rep != 'O' && rep != 'N') {
         System.out.println("\nRepondez par (o)ui ou (n)on !");
         System.out.print("Voulez-vous entrer une autre date (o/n): ");
         rep = Clavier.lireCharLn();
         rep = Character.toUpperCase(rep);
      }
      return rep == 'O';
   }
   
   /**
    * Afficher si la date de naissance donnee correspond a une personne 
    * majeure ou mineure en date du 5 janvier 2007.
    * @param annee l'annee de la date de naissance
    * @param mois le mois de la date de naissance
    * @param jour le jour de la date de naissance
    */
   public static void afficherMajeurOuMineur (int annee, int mois, int jour) {
      if (estMajeure(annee, mois, jour)) {
         System.out.println("\nCette personne est majeure.\n");
      } else {
         System.out.println("\nCette personne est mineure.\n");
      }
   }

   
   public static void main(String[] params) {

      int anneeNaissance;     //L'annee de la date de naissance
      int moisNaissance;      //Le mois de la date de naissance
      int jourNaissance;      //Le jour de la date de naissance

      presenterLogiciel();
      
      do {
         //Lire et valider l'annee de naissance (entre 1920 et 2007)
         anneeNaissance = validerEntier("Entrez votre annee de naissance : ",
                 "Erreur, annee invalide... recommencez!",
                 ANNEE_MIN, ANNEE_MAX);

         //Lire et valider le mois de naissance
         moisNaissance = validerEntier("Entrez votre mois de naissance : ",
                 "Erreur, mois invalide... recommencez!",
                 MOIS_MIN, MOIS_MAX);

         //Lire et valider le jour de naissance selon mois et annee naissance
         jourNaissance = validerJour(moisNaissance, anneeNaissance);

         //afficher si la personne est majeure ou mineure
         afficherMajeurOuMineur(anneeNaissance, moisNaissance, jourNaissance);

      } while (encore());
      
      finProgramme();
      
   } 

}
