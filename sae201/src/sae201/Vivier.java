package sae201;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
	
	public void remplirTuteurCandidat() {
		ArrayList<Candidat> tutore = new ArrayList<Candidat>();
		ArrayList<Tuteur> tuteur= new ArrayList<Tuteur>();
		int cpt =0;
		int cpt_candidat=0;
		String line;
        final String delimiter = ",";
        try
        {
            String filePath = "Etudiant.csv";
            FileReader fileReader = new FileReader(filePath);
            BufferedReader reader = new BufferedReader(fileReader);
            while ((line = reader.readLine()) != null)   //jusque la ligne n'est pas à null
            {
            	String[] token = line.split(delimiter);    // separer par le delimiteur
            	if (Integer.parseInt(token[3])== 1) {
            		cpt_candidat ++;
            	}
            }
            fileReader.close();
            fileReader= new FileReader(filePath);
            reader = new BufferedReader(fileReader);
            while ((line = reader.readLine()) != null){
            	String[] token = line.split(delimiter);
            	
            	if (cpt<cpt_candidat) {
                	Candidat c = new Candidat(token[1],token[0],Integer.parseInt(token[3]), Double.parseDouble(token[2]),Motivation.valueOf(token[5]),Matiere.valueOf(token[4]));
                	tutore.add(c);
                	
            	}
            	else {
                	Tuteur t = new Tuteur(token[1],token[0], Double.parseDouble(token[2]),Integer.parseInt(token[3]),Matiere.valueOf(token[4]));
                	tuteur.add(t);
            	}
            	cpt++;
            }    
            fileReader.close();
        } 
        catch (IOException e)
        {
            e.printStackTrace();
        }
        this.setCandidats(tutore);
        this.setTuteurs(tuteur);
	}

	public  void triSuppression() {
		if (getCandidats().size()!=getTuteurs().size()) {			
			
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
	          
		}
		
	}
	
	

}
