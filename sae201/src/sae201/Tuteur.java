package sae201;

public class Tuteur extends Etudiant{
	private String matiere;

	public Tuteur(String nom, String prenom, int annee, double moyenne) {
		super(nom, prenom, annee, moyenne);
		// TODO Auto-generated constructor stub
	}

	public String getMatiere() {
		return matiere;
	}

	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}

	@Override
	public String toString() {
		return "Tuteur [matiere=" + matiere + ", "+super.toString().substring(10);
	}
	
	

	
	
	
	
}
