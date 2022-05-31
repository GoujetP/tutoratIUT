package sae201;

public class Etudiant {
	private static int cpt = 0;
	private String nom;
	private String prenom;
	private int annee;
	private double moyenne;
	private int id;
	
	public Etudiant(String nom, String prenom, int annee, double moyenne) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.annee = annee;
		this.moyenne = moyenne;
		this.id=cpt++;
	}
	@Override
	public String toString() {
		return "Etudiant [" + prenom + " " + nom + ":" + moyenne + " de moyenne en " + annee + "e annee" + "]";
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
	
	public int getId() {
		return this.id;
	}
	public String initiale() {
		return "" + this.getPrenom().substring(0, 1) + this.getNom().substring(0, 1)+id; 	
	}


}
