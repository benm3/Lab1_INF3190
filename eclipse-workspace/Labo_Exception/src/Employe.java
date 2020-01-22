public class Employe {
	 //attribut de classe
	 private static int dernierNumero = 0;
	
	 //attributs d'instance
	 private String nomDeFamille;
	 private String prenom;
	 private int numero;
	 private int nbrAnnees;
	 private double salaire;
	 
	 public Employe(String nomDeFamille, String prenom, int nbrAnnees,
	 double salaire) throws EmployeInvalideException {
	 
		 if (prenom == null || nomDeFamille == null) {
			 
			 throw new EmployeInvalideException("Nom ou prenom null");	 
		 }
		 if (prenom.length() <2 || nomDeFamille.length() <2) {
			 throw new EmployeInvalideException("La longeur du nom ou prenom est invalide");	 
		 		 
		 }
		
		 if (nbrAnnees <= 0) {
			 
			 throw new EmployeInvalideException("Nombre annees invalide");	 

		 }
		 
		 if (salaire <= 0) {
			 
			 throw new EmployeInvalideException("Le salaire est invalide");	 
		 }
		 
		 this.nomDeFamille = nomDeFamille;
		 this.prenom = prenom;
		 this.nbrAnnees = nbrAnnees;
		 this.salaire = salaire;
		 dernierNumero = dernierNumero + 1;
		 numero = dernierNumero;
	 }
	 public String getNomDeFamille() {
	 return nomDeFamille;
	 }
	 
	 public String getPrenom() {
	 return prenom;
	 }
	
	 public int getNbrAnnees() {
	 return nbrAnnees;
	 }
	 
	 public int getNumero() {
	 return numero;
	 }
	
	 public double getSalaire() {
	 return salaire;
	 }
	 
	 public void setNomDeFamille(String nomDeFamille) throws EmployeInvalideException {
		 
		 if (nomDeFamille == null || nomDeFamille.length() < 2 ) {
			 
			 throw new EmployeInvalideException("Nom de famille invalide");
		 }
		 
	 this.nomDeFamille = nomDeFamille;
	 }
	 
	 public void setPrenom(String prenom) throws EmployeInvalideException {
	 
		 if (nomDeFamille == null || nomDeFamille.length() < 2 ) {

			 throw new EmployeInvalideException("Prenom invalide");
		 }
	this.prenom = prenom;
	 }
	
	 public void setNbrAnnees(int nbrAnnees)  throws EmployeInvalideException {
		 
		 if (nbrAnnees <= 0) {
			 
			 throw new EmployeInvalideException("Nombre annees invalide");
		 }
		 
	 this.nbrAnnees = nbrAnnees;
	 }
	 
	 public void setSalaire(double salaire)  throws EmployeInvalideException {
		 
		 if (salaire <= 0) {

			 throw new EmployeInvalideException("Salaire invalide");
		 }
		 
	this.salaire = salaire;
	 }
	}