package sae201;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Vivier {
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

	void removeTuteur(int index) {
		this.tuteurs.remove(index);
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
			String filePath = "src/Etudiant.csv";
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
			while ((line = reader.readLine()) != null){
				String[] token = line.split(delimiter);

				if (cpt<cpt_candidat) {
					Candidat c = new Candidat(token[1],token[0],Integer.parseInt(token[3]), Double.parseDouble(token[2]),Motivation.valueOf(token[5]),Matiere.valueOf(token[4]));
					if(c.getMatiere().equals("POO")) {
						candidatsPOO.add(c);
					}
					else if(c.getMatiere().equals("IHM")) {
						candidatsIHM.add(c);
					}
					else if(c.getMatiere().equals("BDD")) {
						candidatsBDD.add(c);
					}
					else if(c.getMatiere().equals("GRAPHES")) {
						candidatsGRAPHES.add(c);
					}
					else if(c.getMatiere().equals("WEB")) {
						candidatsWEB.add(c);
					}
					else if(c.getMatiere().equals("BAS_NIVEAU")) {
						candidatsBAS_NIVEAU.add(c);
					}
					else if(c.getMatiere().equals("SYSTEME")) {
						candidatsSYSTEME.add(c);
					}
				}

				else {
					Tuteur t = new Tuteur(token[1],token[0], Double.parseDouble(token[2]),Integer.parseInt(token[3]),Matiere.valueOf(token[4]));
					if(t.getMatiere().equals("POO")) {
						tuteursPOO.add(t);
					}
					else if(t.getMatiere().equals("IHM")) {
						tuteursIHM.add(t);
					}
					else if(t.getMatiere().equals("BDD")) {
						tuteursBDD.add(t);
					}
					else if(t.getMatiere().equals("GRAPHES")) {
						tuteursGRAPHES.add(t);
					}
					else if(t.getMatiere().equals("WEB")) {
						tuteursWEB.add(t);
					}
					else if(t.getMatiere().equals("BAS_NIVEAU")) {
						tuteursBAS_NIVEAU.add(t);
					}
					else if(t.getMatiere().equals("SYSTEME")) {
						tuteursSYSTEME.add(t);
					}
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
