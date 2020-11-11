
public class Methode_Char {

	public static char validerChoixMenu (String msgSoll, String msgErr,
			 char borneInf, char borneSup) {
			 char choixMenu;
			 System.out.print ("\n" + msgSoll);
			 choixMenu = Clavier.lireCharLn();

			 while (choixMenu < borneInf || choixMenu > borneSup) {
			 System.out.println(msgErr);
			 System.out.print (msgSoll);
			 choixMenu = Clavier.lireCharLn();
			 }

			 return choixMenu;
			}
	
	
	public static void main(String[] args) {
		
		char lettre = validerChoixMenu("Veuillez saisir une lettre entre a et v : ",
				"Erreur! Veuillez saisir une lettre valide", 'a', 'v');
		
		System.out.println("\nLe choix des menus est : " +lettre);
	}

}
