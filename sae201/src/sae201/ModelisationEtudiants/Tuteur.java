package ModelisationEtudiants;

public class Tuteur extends Etudiant{
	
	private Matiere matiere;
	
	public Tuteur(String nom, String prenom,double moyenne, int annee, Matiere matiere) {
		super(nom, prenom, annee, moyenne);
		// TODO Auto-generated constructor stub
		this.matiere=matiere;
	}
	
	
	public Tuteur(String nom, String prenom,double moyenne, int annee) {
		super(nom, prenom, annee, moyenne);
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	@Override
	public String toString() {
		return "Tuteur ["+super.toString().substring(10,super.toString().length()-1)+", matière:"+matiere+", id:"+getId() + "]";
	}




	public Matiere getMatiere() {
		return matiere;
	}




	
}

	
	
	
	

