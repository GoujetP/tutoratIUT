package sae201;

import java.util.ArrayList;

public class Vivier {
	private ArrayList<Tuteur> tuteurs;
	private ArrayList<Candidat> candidats;

	Vivier(){
		this.tuteurs=new ArrayList<Tuteur>();
		this.candidats=new ArrayList<Candidat>();
	}
<<<<<<< HEAD
	
=======
	public void setTuteurs(ArrayList<Tuteur> tuteurs) {
		this.tuteurs = tuteurs;
	}
	public void setCandidats(ArrayList<Candidat> candidats) {
		this.candidats = candidats;
	}
>>>>>>> a84992042fc6d54eb4c24cdba0b7beebf3ebf2eb
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
	
<<<<<<< HEAD
	public Tuteur getTuteur(int i) {
=======
	
	public ArrayList<Tuteur> getTuteurs() {
		return tuteurs;
	}
	public ArrayList<Candidat> getCandidats() {
		return candidats;
	}
	public Tuteur getTuteurI(int i) {
>>>>>>> a84992042fc6d54eb4c24cdba0b7beebf3ebf2eb
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
<<<<<<< HEAD
=======
	
	public  void triSuppression() {
		if (getCandidats().size()!=getTuteurs().size()) {
			System.out.println("dans le if");
			
	          int taille = getCandidats().size();  
	          
	          for (int i = 1; i < taille; i++)
	          { 
	               double index = getCandidatI(i).getMoyenne();  
	               Candidat c = getCandidatI(i);  
	               int j = i-1;  
	            
	               while(j >= 0 && getCandidatI(j).getMoyenne() > index)  
	               {
	            	   getCandidats().set(j+1,getCandidatI(j));  
	                    j--;  
	               }  
	               getCandidats().set(j+1, c); 
	          }
	          
	        for (int i = getCandidats().size()-1; i>getTuteurs().size()-1; i--) {
	        	removeCandidat(i); 
	        }
	        //jusque la avec supression du surplus
	          
	        System.out.println(getCandidats().size());
	        System.out.println(getTuteurs().size());
		}
		
	}
	
	
>>>>>>> a84992042fc6d54eb4c24cdba0b7beebf3ebf2eb
}
