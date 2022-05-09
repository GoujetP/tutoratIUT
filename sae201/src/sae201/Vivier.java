package sae201;

import java.util.ArrayList;

public class Vivier {
	private ArrayList<Tuteur> tuteurs;
	private ArrayList<Candidat> candidats;
	
	Vivier(){
		this.tuteurs=new ArrayList<Tuteur>();
		this.candidats=new ArrayList<Candidat>();
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
	
	
	public Tuteur getTuteur(int i) {
		return this.tuteurs.get(i);
	}
	
	public Candidat getCandidat(int i) {
		return this.candidats.get(i);
	}
	
	void removeCandidat(Candidat c) {
		this.candidats.remove(c);
	}
	void removeCandidat(int index) {
		this.candidats.remove(index);
	}
	
	
}
