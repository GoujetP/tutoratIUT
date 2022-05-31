package sae201;

public class Candidat extends Etudiant {
	private Motivation motivation;
	private Matiere matiere;

	public Candidat(String nom, String prenom, int annee, double moyenne,Motivation motivation,Matiere matiere) {
		super(nom, prenom, annee, moyenne);
		this.motivation=motivation;
		// TODO Auto-generated constructor stub
		this.matiere=matiere;
	}
	
	public Candidat(String nom, String prenom,int annee,double moyenne,Matiere matiere) {
		super(nom, prenom, annee, moyenne);
		this.motivation = Motivation.PEU_MOTIVE;
		// TODO Auto-generated constructor stub
		this.matiere=matiere;
	}

	public Motivation isMotivation() {
		return motivation;
	}

	public void setMotivation(Motivation motivation) {
		this.motivation = motivation;
	}

	public String toString() {
		return "Candidat [" +super.toString().substring(10,super.toString().length()-1) + ", motivation:" + motivation + ", matière:"+getMatiere()+ ", id:" + getId() + "]";
	}
	
	public Matiere getMatiere() {
		return this.matiere;
	}



}
