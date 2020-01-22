
public class Test {
	
	public static void main ( String [] args ){

		try {
		Employe e1 = new Employe("Nico","Maxime", 200, 1);	
		Employe e2 = new Employe("","", -1, -1);	
	
		}catch (EmployeInvalideException e) {
			
			System.out.println(e.getMessage());
		}	
	}
}
