package sae201;

public class Tuteur extends Etudiant{
	

	public Tuteur(String nom, String prenom,double moyenne, int annee) {
		super(nom, prenom, annee, moyenne);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Tuteur ["+super.toString().substring(10)+ ", id : " + getId();

	}
}

	
	
	
	

