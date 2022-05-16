package sae201;

import java.util.ArrayList;

public class Vivier {
	private ArrayList<Tuteur> tuteurs;
	private ArrayList<Candidat> candidats;
	
	Vivier(){
		this.tuteurs=new ArrayList<Tuteur>();
		this.candidats=new ArrayList<Candidat>();
	}
	public void setTuteurs(ArrayList<Tuteur> tuteurs) {
		this.tuteurs = tuteurs;
	}
	public void setCandidats(ArrayList<Candidat> candidats) {
		this.candidats = candidats;
	}
	void addTuteur(Tuteur t) {
		this.tuteurs.add(t);
	}
	
	void removeTuteur(Tuteur t) {
		this.tuteurs.remove(t);
	}
	
	void removeTuteur(int index) {
		this.tuteurs.remove(index);
	}
	
	void addCandidat(Candidat c) {
		this.candidats.add(c);
	}
	
	
	public ArrayList<Tuteur> getTuteurs() {
		return tuteurs;
	}
	public ArrayList<Candidat> getCandidats() {
		return candidats;
	}
	public Tuteur getTuteurI(int i) {
		return this.tuteurs.get(i);
	}
	
	public Candidat getCandidatI(int i) {
		return this.candidats.get(i);
	}
	
	void removeCandidat(Candidat c) {
		this.candidats.remove(c);
	}
	void removeCandidat(int index) {
		this.candidats.remove(index);
	}
	
	
}
