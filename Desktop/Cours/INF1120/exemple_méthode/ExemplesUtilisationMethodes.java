
/**
 * La methode main montre differentes utilisations des methodes definies dans
 * cette classe.
 *
 * @author Melanie Lord
 * @version Octobre 2015
 */
public class ExemplesUtilisationMethodes {

   /**
    * Cette methode affiche un menu de 3 options.
    */
   public static void afficherMenu() {
      System.out.println("1. Option 1");
      System.out.println("2. Option 2");
      System.out.println("3. Option 3");
   }

   /**
    * Cette methode marque une pause en demandant a l'utilisateur d'appuyer sur
    * la touche [ENTREE] pour continuer.
    */
   public static void pause() {
      System.out.print("Appuyer sur <ENTREE> pour continuer...\n\n");
      Clavier.lireFinLigne();
   }

   /**
    * Cette methode affiche nbr lignes blanches a l'ecran.
    *
    * @param nbr le nombre de lignes blanches a afficher a l'ecran.
    */
   public static void sautLignes(int nbr) {
      for (int i = 0; i < nbr; i++) {
         System.out.println();
      }
   }

   /**
    * Cette methode affiche les résultats d'un nombre donne de lances successifs
    * d'un de. Chaque lance donne un nombre entre 1 et 6.
    *
    * @param nbr le nombre de lances que l'on veut effectuer.
    */
   public static void lancerDe(int nbr) {
      int de;
      for (int i = 1; i <= nbr; i++) {
         de = (int) (Math.random() * (6 - 1) + 1.5);
         System.out.println("Lance # " + i + " : " + de);
      }
   }

   /**
    * Cette methode calcule la somme des nombres entiers de 1 a 10.
    *
    * @return la somme des entiers de 1 a 10.
    */
   public static int sommeUnADix() {
      int somme = 0;
      for (int i = 1; i <= 10; i++) {
         somme = somme + i;
      }
      return somme;
   }

   /**
    * Cette methode tire un nombre entier au hasard, entre 1 et 6.
    *
    * @return un nombre tire au hasard entre 1 et 6.
    */
   public static int lancerDe() {
      int de = (int) (Math.random() * (6 - 1) + 1.5);
      return de;
   }

   /**
    * Cette methode retourne vrai si l'annee est bissextile, faux sinon.
    *
    * @param annee l'annee dont on doit determiner si bissextile.
    * @return true si l'annee est bissextile, false sinon.
    */
   public static boolean estBissextile(int annee) {
      boolean bissex = annee % 400 == 0
              || (annee % 4 == 0 && annee % 100 != 0);
      return bissex;
   }

   /**
    * Cette methode calcule le perimetre d'un rectangle (2 * base + 2 *
    * hauteur).
    *
    * @param base la base du rectangle.
    * @param hauteur la hauteur du rectangle.
    * @return le perimetre du rectangle (2 * base + 2 * hauteur).
    */
   public static double perimetreRectangle(double base, double hauteur) {
      return (2 * base + 2 * hauteur);
   }

   /**
    * Cette methode saisit et valide le choix de l'utilisateur entre borneInf et
    * borneSup.
    *
    * @param msgSoll le msg de sollicitation du choix de l'utilisateur.
    * @param msgErr le msg d'erreur lorsqu'un choix est invalide.
    * @param borneInf la borne inferieure pour un choix valide.
    * @param borneSup la borne superieure pour un choix valide.
    * @return le choix valide de l'utilisateur, entre borneInf et borneSup.
    */
   public static char validerChoixMenu(String msgSoll, String msgErr, char borneInf, char borneSup) {

      char choixMenu;
      System.out.print("\n" + msgSoll);
      choixMenu = Clavier.lireCharLn();

      while (choixMenu < borneInf || choixMenu > borneSup) {
         System.out.println(msgErr);
         System.out.print(msgSoll);
         choixMenu = Clavier.lireCharLn();
      }
      return choixMenu;
   }

   public static double salaire(double nbrHeures, double tauxHoraire) {
      double salaireHebdo;

      if (nbrHeures <= 40) {
         salaireHebdo = nbrHeures * tauxHoraire;
      } else {
         salaireHebdo = (nbrHeures - 40) * tauxHoraire
                 * 1.5 + 40 * tauxHoraire;
      }
      return salaireHebdo; //un seul return
   }
   
   //Enlever les commentaires des instructions que vous voulez tester.
   public static void main (String [] args) {
      
      short nbr = 10;
      double nbrReel = 12.3;
      boolean bissex;
      char choix;
      int nombre;
      final char MIN = '1';
      final char MAX = '4';
      
      /*****************************************
       * Appel de methodes sans valeur de retour
       *****************************************/
      
      //afficherMenu();
      
      //pause();
      
      //sautLignes ();       //ne compile pas car manque un param. effectif
      
      /*
      System.out.println("debut");
      sautLignes (24);
      System.out.println("fin");
      */
      
      //lancerDe (nbr);  	 //short compatible par affectation a un int

      //lancerDe (nbrReel); //ne compile pas, un double n'est pas compatible 
                            //par affectation a un int
      
      //lancerDe ('!');     //parametre legal ?
      
      /*****************************************
       * Appel de methodes avec valeur de retour
       *****************************************/

      /*
      int somme = sommeUnADix (); 
      System.out.println("Somme : " + somme);
      */
      
      //System.out.println(sommeUnADix());

      /*
      nombre = sommeUnADix() * lancerDe();
      System.out.println(nombre);
      */
      
      /*
      while (lancerDe() <= 5) {
         System.out.println("Plus petit ou egal a cinq.");
      }
      */

      /*
      bissex = estBissextile (2012);
      if (bissex) {
         System.out.println("bissextile");
      } else {
         System.out.println("non bissextile");
      }
      */
      //OU...
      /*
      if (estBissextile(2012)) {
         System.out.println("bissextile");
      } else {
         System.out.println("non bissextile");
      }
      */
      
      //System.out.println (estBissextile (1998 + lancerDe()));

      /*
      nbrReel = perimetreRectangle (13.2, 9);
      System.out.println(nbrReel);
      */
      
      //System.out.println("Perimetre : " + perimetreRectangle(3, 6.2));
      
      /*
      choix = validerChoixMenu ("Entrez votre choix : ",
            "Erreur, vous devez entrer une valeur entre " + MIN 
            + " et " + MAX + ". Recommencez...\n", 
            MIN, MAX);
      System.out.println("Choix = " + choix);
      */
   }

}
