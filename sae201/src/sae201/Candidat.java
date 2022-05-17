package sae201;

public class Candidat extends Etudiant {
	private boolean motivation;

	public Candidat(String nom, String prenom, int annee, double moyenne,boolean motivation) {
		super(nom, prenom, annee, moyenne);
		this.motivation=motivation;
		// TODO Auto-generated constructor stub
	}
	
	public Candidat(String nom, String prenom,double moyenne,int annee) {
		super(nom, prenom, annee, moyenne);
		this.motivation = true;
		// TODO Auto-generated constructor stub
	}

	public boolean isMotivation() {
		return motivation;
	}

	public void setMotivation(boolean motivation) {
		this.motivation = motivation;
	}

	public String toString() {
		return "Candidat [" +super.toString().substring(10,super.toString().length()) + ", motivation=" + motivation + ", id ="+getId()+ "]";
	}

}
