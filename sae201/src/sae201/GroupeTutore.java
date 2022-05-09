package sae201;

import java.util.ArrayList;

public class GroupeTutore {
	private int id ; 
	private static int cpt = 0;
	private Vivier vivier;
	private Tuteur tuteur;
	private ArrayList<Candidat> eleve;
	
	public GroupeTutore(Tuteur tuteur, ArrayList<Candidat> eleve,Vivier vivier) {
		super();
		this.id = cpt++;
		this.tuteur = tuteur;
		this.eleve = eleve;
		this.vivier=vivier;
	}
	
	public GroupeTutore() {
		super();
		this.id = cpt++;
		this.eleve = new ArrayList<Candidat>();
		this.vivier=new Vivier();
	}

	public Tuteur getTuteur() {
		return tuteur;
	}

	public void setTuteur(Tuteur tuteur) {
		this.tuteur = tuteur;
	}

	public ArrayList<Candidat> getEleve() {
		return eleve;
	}

	public void setEleve(ArrayList<Candidat> eleve) {
		this.eleve = eleve;
	}

	public int getId() {
		return id;
	}
	
	
	
	
	
	
	
}
