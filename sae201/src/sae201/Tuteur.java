package sae201;

public class Tuteur extends Etudiant{
	
	private Matiere matiere;
	
	public Tuteur(String nom, String prenom,double moyenne, int annee, Matiere matiere) {
		super(nom, prenom, annee, moyenne);
		// TODO Auto-generated constructor stub
		this.matiere=matiere;
	}

	@Override
	public String toString() {
		return "Tuteur ["+super.toString().substring(10,super.toString().length()-2)+", matiere :"+matiere+", id :"+getId();

	}
}

	
	
	
	

