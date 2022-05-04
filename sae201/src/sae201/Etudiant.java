package sae201;

public class Etudiant {
	private String nom;
	private String prenom;
	private int annee;
	private double moyenne;
	public Etudiant(String nom, String prenom, int annee, double moyenne) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.annee = annee;
		this.moyenne = moyenne;
	}
	@Override
	public String toString() {
		return "Etudiant [nom=" + nom + ", prenom=" + prenom + ", annee=" + annee + ", moyenne=" + moyenne + "]";
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	public double getMoyenne() {
		return moyenne;
	}
	public void setMoyenne(double moyenne) {
		this.moyenne = moyenne;
	}
	public String initiale() {
		return "" + this.getPrenom().substring(0, 1) + this.getNom().substring(0, 1); 	
	}


}
