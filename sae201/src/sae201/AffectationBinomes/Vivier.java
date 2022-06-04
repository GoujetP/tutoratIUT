package AffectationBinomes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import ModelisationEtudiants.Candidat;
import ModelisationEtudiants.Matiere;
import ModelisationEtudiants.Motivation;
import ModelisationEtudiants.Tuteur;

public class Vivier {
	
	private ArrayList<Tuteur> tuteurs;
	private ArrayList<Candidat> candidats;
	
	private ArrayList<Tuteur> tuteursPOO;
	private ArrayList<Tuteur> tuteursIHM;
	private ArrayList<Tuteur> tuteursBDD;
	private ArrayList<Tuteur> tuteursGRAPHES;
	private ArrayList<Tuteur> tuteursWEB;
	private ArrayList<Tuteur> tuteursBAS_NIVEAU;
	private ArrayList<Tuteur> tuteursSYSTEME;

	private ArrayList<Candidat> candidatsPOO;
	private ArrayList<Candidat> candidatsIHM;
	private ArrayList<Candidat> candidatsBDD;
	private ArrayList<Candidat> candidatsGRAPHES;
	private ArrayList<Candidat> candidatsWEB;
	private ArrayList<Candidat> candidatsBAS_NIVEAU;
	private ArrayList<Candidat> candidatsSYSTEME;
	
	

	Vivier(){
		this.candidats=new ArrayList<Candidat>();
		this.tuteurs=new ArrayList<Tuteur>();

		this.tuteursPOO=new ArrayList<Tuteur>();
		this.tuteursIHM=new ArrayList<Tuteur>();
		this.tuteursBDD=new ArrayList<Tuteur>();
		this.tuteursGRAPHES=new ArrayList<Tuteur>();
		this.tuteursWEB=new ArrayList<Tuteur>();
		this.tuteursBAS_NIVEAU=new ArrayList<Tuteur>();
		this.tuteursSYSTEME=new ArrayList<Tuteur>();

		this.candidatsPOO=new ArrayList<Candidat>();
		this.candidatsIHM=new ArrayList<Candidat>();
		this.candidatsBDD=new ArrayList<Candidat>();
		this.candidatsGRAPHES=new ArrayList<Candidat>();
		this.candidatsWEB=new ArrayList<Candidat>();
		this.candidatsBAS_NIVEAU=new ArrayList<Candidat>();
		this.candidatsSYSTEME=new ArrayList<Candidat>();
	}

	void addTuteur(Tuteur t) {
		if(t.getMatiere().equals(Matiere.POO)) {
			this.tuteursPOO.add(t);
		}else if(t.getMatiere().equals(Matiere.IHM)) {
			this.tuteursIHM.add(t);
		}else if(t.getMatiere().equals(Matiere.BDD)) {
			this.tuteursBDD.add(t);
		}else if(t.getMatiere().equals(Matiere.GRAPHES)) {
			this.tuteursGRAPHES.add(t);
		}else if(t.getMatiere().equals(Matiere.WEB)) {
			this.tuteursWEB.add(t);
		}else if(t.getMatiere().equals(Matiere.BAS_NIVEAU)) {
			this.tuteursBAS_NIVEAU.add(t);
		}else if(t.getMatiere().equals(Matiere.SYSTEME)) {
			this.tuteursSYSTEME.add(t);
		}

	}

	void removeTuteur(Tuteur t) {
		if(t.getMatiere().equals(Matiere.POO)) {
			this.tuteursPOO.remove(t);
		}else if(t.getMatiere().equals(Matiere.IHM)) {
			this.tuteursIHM.remove(t);
		}else if(t.getMatiere().equals(Matiere.BDD)) {
			this.tuteursBDD.remove(t);
		}else if(t.getMatiere().equals(Matiere.GRAPHES)) {
			this.tuteursGRAPHES.remove(t);
		}else if(t.getMatiere().equals(Matiere.WEB)) {
			this.tuteursWEB.add(t);
		}else if(t.getMatiere().equals(Matiere.BAS_NIVEAU)) {
			this.tuteursBAS_NIVEAU.remove(t);
		}else if(t.getMatiere().equals(Matiere.SYSTEME)) {
			this.tuteursSYSTEME.remove(t);
		}

	}

	void addCandidat(Candidat c) {
		if(c.getMatiere().equals(Matiere.POO)) {
			this.candidatsPOO.add(c);
		}else if(c.getMatiere().equals(Matiere.IHM)) {
			this.candidatsIHM.add(c);
		}else if(c.getMatiere().equals(Matiere.BDD)) {
			this.candidatsBDD.add(c);
		}else if(c.getMatiere().equals(Matiere.GRAPHES)) {
			this.candidatsGRAPHES.add(c);
		}else if(c.getMatiere().equals(Matiere.WEB)) {
			this.candidatsWEB.add(c);
		}else if(c.getMatiere().equals(Matiere.BAS_NIVEAU)) {
			this.candidatsBAS_NIVEAU.add(c);
		}else if(c.getMatiere().equals(Matiere.SYSTEME)) {
			this.candidatsSYSTEME.add(c);
		}

	}

	void removeCandidat(Candidat c) {
		this.candidats.remove(c);
		if(c.getMatiere().equals(Matiere.POO)) {
			this.candidatsPOO.remove(c);
		}else if(c.getMatiere().equals(Matiere.IHM)) {
			this.candidatsIHM.remove(c);
		}else if(c.getMatiere().equals(Matiere.BDD)) {
			this.candidatsBDD.remove(c);
		}else if(c.getMatiere().equals(Matiere.GRAPHES)) {
			this.candidatsGRAPHES.remove(c);
		}else if(c.getMatiere().equals(Matiere.WEB)) {
			this.candidatsWEB.remove(c);
		}else if(c.getMatiere().equals(Matiere.BAS_NIVEAU)) {
			this.candidatsBAS_NIVEAU.remove(c);
		}else if(c.getMatiere().equals(Matiere.SYSTEME)) {
			this.candidatsSYSTEME.remove (c);
		}

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

	void removeCandidat(int index) {
		this.candidats.remove(index);
	}
	
	public void remplirTuteurCandidat() {
		int cpt =0;
		int cpt_candidat=0;
		String line;
		final String delimiter = ",";
		
		try
		{
			
			String filePath = "Etudiant.csv";
			FileReader fileReader = new FileReader(filePath);
			
			BufferedReader reader = new BufferedReader(fileReader);
			
			while ((line = reader.readLine()) != null)   //jusque la ligne n'est pas � null
			{
				String[] token = line.split(delimiter);    // separer par le delimiteur
				if (Integer.parseInt(token[3])== 1) {
					cpt_candidat ++;
				}
			}
			fileReader.close();
			fileReader= new FileReader(filePath);
			reader = new BufferedReader(fileReader);
			while ((line = reader.readLine()) != null ){
				String[] token = line.split(delimiter);
				if (cpt<cpt_candidat) {
					Candidat c = new Candidat(token[1],token[0],Integer.parseInt(token[3]), Double.parseDouble(token[2]),Motivation.valueOf(token[5]),Matiere.valueOf(token[4]));
					this.candidats.add(c);
				}

				else {
					Tuteur t = new Tuteur(token[1],token[0], Double.parseDouble(token[2]),Integer.parseInt(token[3]),Matiere.valueOf(token[4]));
					this.tuteurs.add(t);
				}
				cpt++;
			}    
			fileReader.close();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}

	public void remplirTuteurCandidatParMatiere() {
			remplirTuteurCandidat();
			triSuppression();
			
			
			for (Candidat c : this.candidats)
					if(c.getMatiere().equals(Matiere.POO)) {
						candidatsPOO.add(c);
					}
					else if(c.getMatiere().equals(Matiere.IHM) ) {
						candidatsIHM.add(c);
					}
					else if(c.getMatiere().equals(Matiere.BDD) ) {
						candidatsBDD.add(c);
					}
					else if(c.getMatiere().equals(Matiere.GRAPHES) ) {
						candidatsGRAPHES.add(c);
					}
					else if(c.getMatiere().equals(Matiere.WEB) ) {
						candidatsWEB.add(c);
					}
					else if(c.getMatiere().equals(Matiere.BAS_NIVEAU) ) {
						candidatsBAS_NIVEAU.add(c);
					}
					else if(c.getMatiere().equals(Matiere.SYSTEME)) {
						candidatsSYSTEME.add(c);
					}
			for (Tuteur t : this.tuteurs)
					if(t.getMatiere().equals(Matiere.POO) ) {
						tuteursPOO.add(t);
					}
					else if(t.getMatiere().equals(Matiere.IHM)) {
						tuteursIHM.add(t);
					}
					else if(t.getMatiere().equals(Matiere.BDD) ) {
						tuteursBDD.add(t);
					}
					else if(t.getMatiere().equals(Matiere.GRAPHES) ) {
						tuteursGRAPHES.add(t);
					}
					else if(t.getMatiere().equals(Matiere.WEB) ) {
						tuteursWEB.add(t);
					}
					else if(t.getMatiere().equals(Matiere.BAS_NIVEAU) ) {
						tuteursBAS_NIVEAU.add(t);
					}
					else if(t.getMatiere().equals(Matiere.SYSTEME)) {
						tuteursSYSTEME.add(t);
					}
				}
	// A UTLISER SIL Y A UN CANDIDAT EN PLUS PAR RAPPORT AU NOMBRE DE TUTEUR
	public  void triDupplication(ArrayList<Tuteur> tuteur) {
					
		if (tuteur.size()>0) {
			int taille = tuteur.size();  

			for (int i = 1; i < taille; i++)
			{ 
				double index = tuteur.get(i).getMoyenne();  
				Tuteur t = tuteur.get(i);  
				int j = i-1;  

				while(j >= 0 && tuteur.get(j).getMoyenne() > index)  
				{
					tuteur.set(j+1,tuteur.get(j));  
					j--;  
				}  
				tuteur.set(j+1, t); 
			}
			tuteur.add(tuteur.get(tuteur.size()-1));
			//jusque la avec supression du surplus
		}

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




	public ArrayList<Tuteur> getTuteursPOO() {
		return tuteursPOO;
	}




	public void setTuteursPOO(ArrayList<Tuteur> tuteursPOO) {
		this.tuteursPOO = tuteursPOO;
	}




	public ArrayList<Tuteur> getTuteursIHM() {
		return tuteursIHM;
	}




	public void setTuteursIHM(ArrayList<Tuteur> tuteursIHM) {
		this.tuteursIHM = tuteursIHM;
	}




	public ArrayList<Tuteur> getTuteursBDD() {
		return tuteursBDD;
	}




	public void setTuteursBDD(ArrayList<Tuteur> tuteursBDD) {
		this.tuteursBDD = tuteursBDD;
	}




	public ArrayList<Tuteur> getTuteursGRAPHES() {
		return tuteursGRAPHES;
	}




	public void setTuteursGRAPHES(ArrayList<Tuteur> tuteursGRAPHES) {
		this.tuteursGRAPHES = tuteursGRAPHES;
	}




	public ArrayList<Tuteur> getTuteursWEB() {
		return tuteursWEB;
	}




	public void setTuteursWEB(ArrayList<Tuteur> tuteursWEB) {
		this.tuteursWEB = tuteursWEB;
	}




	public ArrayList<Tuteur> getTuteursBAS_NIVEAU() {
		return tuteursBAS_NIVEAU;
	}




	public void setTuteursBAS_NIVEAU(ArrayList<Tuteur> tuteursBAS_NIVEAU) {
		this.tuteursBAS_NIVEAU = tuteursBAS_NIVEAU;
	}




	public ArrayList<Tuteur> getTuteursSYSTEME() {
		return tuteursSYSTEME;
	}




	public void setTuteursSYSTEME(ArrayList<Tuteur> tuteursSYSTEME) {
		this.tuteursSYSTEME = tuteursSYSTEME;
	}




	public ArrayList<Candidat> getCandidatsPOO() {
		return candidatsPOO;
	}




	public void setCandidatsPOO(ArrayList<Candidat> candidatsPOO) {
		this.candidatsPOO = candidatsPOO;
	}




	public ArrayList<Candidat> getCandidatsIHM() {
		return candidatsIHM;
	}




	public void setCandidatsIHM(ArrayList<Candidat> candidatsIHM) {
		this.candidatsIHM = candidatsIHM;
	}




	public ArrayList<Candidat> getCandidatsBDD() {
		return candidatsBDD;
	}




	public void setCandidatsBDD(ArrayList<Candidat> candidatsBDD) {
		this.candidatsBDD = candidatsBDD;
	}




	public ArrayList<Candidat> getCandidatsGRAPHES() {
		return candidatsGRAPHES;
	}




	public void setCandidatsGRAPHES(ArrayList<Candidat> candidatsGRAPHES) {
		this.candidatsGRAPHES = candidatsGRAPHES;
	}




	public ArrayList<Candidat> getCandidatsWEB() {
		return candidatsWEB;
	}




	public void setCandidatsWEB(ArrayList<Candidat> candidatsWEB) {
		this.candidatsWEB = candidatsWEB;
	}




	public ArrayList<Candidat> getCandidatsBAS_NIVEAU() {
		return candidatsBAS_NIVEAU;
	}




	public void setCandidatsBAS_NIVEAU(ArrayList<Candidat> candidatsBAS_NIVEAU) {
		this.candidatsBAS_NIVEAU = candidatsBAS_NIVEAU;
	}




	public ArrayList<Candidat> getCandidatsSYSTEME() {
		return candidatsSYSTEME;
	}




	public void setCandidatsSYSTEME(ArrayList<Candidat> candidatsSYSTEME) {
		this.candidatsSYSTEME = candidatsSYSTEME;
	}



}
