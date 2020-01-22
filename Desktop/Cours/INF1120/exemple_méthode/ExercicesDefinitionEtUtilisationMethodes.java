
/**
 * INF1120 : Exercices conception et utilisation de methodes.
 * @author Melanie Lord
 * @version octobre 2015
 */
public class ExercicesDefinitionEtUtilisationMethodes {

   /**
    * Cette methode affiche la presentation de ce programme.
    */
   public static void presenterLogiciel() {
      System.out.print("ce programme vous demandera de saisir un caractere minuscule\n"
              + "et transformera celui-ci en majuscule.\n\n");
   }

   /**
    * Cette methode affiche un message disant a l'utilisateur d'appuyer sur
    * ENTREE pour continuer.
    */
   public static void pause() {
      System.out.print("Appuyer sur <ENTREE> pour continuer...\n\n");
      Clavier.lireFinLigne();
   }

   /**
    * Cette methode affiche un message de fin du programme.
    */
   public static void finProgramme() {
      System.out.print("\n\nFin normale du programme!!!\n\n");
   }

   /**
    * Cette methode transforme carMin en majuscule, si carMin est une lettre
    * minuscule, et affiche la majuscule correspondante. Sinon, la methode
    * affiche un message d'erreur.
    *
    * @param carMin le caractere a transformer en majuscule (si possible).
    */
   public static void afficherMajuscule(char carMin) {
      char carMaj;    //le caractere transforme en majuscule
      int unicode;

      //Verifier que le parametre carMin contient bien une lettre minuscule
      if (carMin >= 'a' && carMin <= 'z') {
         //transformation du caractere en majuscule
         unicode = (int)carMin - 32;
         carMaj = (char)unicode;
         System.out.print("\n\nLa lettre " + carMin 
                 + " transformee en majuscule est: " + carMaj);
         
      //afficher message d'erreur du parametre
      } else {
         System.out.println("Erreur. le caractere donne n'est pas une "
                 + "lettre minuscule.");
      }
   }
   
   /**
    * Saisit et valide un caractere entre min et max inclusivement.
    * @param msgSoll le message de sollicitation du caractere.
    * @param msgErr le message d'erreur lorque le caractere n'est pas 
    *               entre min et max.
    * @param min la borne inferieure valide pour le caractere saisi.
    * @param max la borne superieure valide pour le caractere saisi.
    * @return le caractere saisi qui est entre min et max inclusivement.
    */
   public static char validerCaractere(String msgSoll, String msgErr, 
           char min, char max) {
      char c;
      System.out.print(msgSoll);
      c = Clavier.lireCharLn();
      while (c < min || c > max) {
         System.out.println(msgErr);
         System.out.print(msgSoll);
         c = Clavier.lireCharLn();
      }
      return c;
   }

   public static void main (String [] args) {
      
      char lettreMin;   //caractere lu
      char continuer;   //'o' pour continuer, 'n' pour arreter

      //afficher presentation logiciel
      presenterLogiciel();

      //attendre un "ENTREE" au clavier pour continuer le programme
      pause();

      //tant que l'utilisateur ne quitte pas
      do {
         //validation que le caractere est bien une lettre minuscule
         lettreMin = validerCaractere("Entrez une lettre minuscule : ",
                 "Erreur, le caractere doit etre une lettre minuscule. Recommencez !",
                 'a', 'z');
         
         //afficher le caractere en majuscule
         afficherMajuscule(lettreMin);

         //validation reponse continuer (o ou n)
         continuer = validerCaractere("\n\nRecommencez ? (o/n) : ", 
                 "Erreur! Entrez (o)ui ou (n)on...", 'n', 'o');

      } while (continuer == 'o');
      
      //affiche la fin du programme
      finProgramme();
   }
}
