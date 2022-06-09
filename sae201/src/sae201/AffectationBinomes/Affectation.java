package AffectationBinomes;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ModelisationEtudiants.Candidat;
import ModelisationEtudiants.GroupeTutore;
import ModelisationEtudiants.Tuteur;
import fr.ulille.but.sae2_02.graphes.Arete;
import fr.ulille.but.sae2_02.graphes.CalculAffectation;
import fr.ulille.but.sae2_02.graphes.GrapheNonOrienteValue;

public class Affectation {
	public static void AddSommetAffectation(GrapheNonOrienteValue<String> g1 , ArrayList<Tuteur> tuteur , ArrayList<Candidat> tutore, String ponderation) {
		for(int i = 0 ; i < tuteur.size() ; i++) {
			Tuteur  t =tuteur.get(i);
			g1.ajouterSommet(t.initiale());
			for(int j = 0 ; j < tutore.size() ; j++) {

				g1.ajouterSommet(tutore.get(j).initiale());
				if(ponderation.equals("moyenne tuteur")) {
					g1.ajouterArete(tuteur.get(i).initiale(), tutore.get(j).initiale(), (((20-tuteur.get(i).getMoyenne())*3)/tuteur.get(i).getAnnee()+tutore.get(j).getMoyenne()));
				}else if(ponderation.equals("annee")) {
					g1.ajouterArete(tuteur.get(i).initiale(), tutore.get(j).initiale(), ((20-tuteur.get(i).getMoyenne())/(tuteur.get(i).getAnnee()*0.5)+tutore.get(j).getMoyenne()));
				}else if(ponderation.equals("moyenne tutore")) {
					g1.ajouterArete(tuteur.get(i).initiale(), tutore.get(j).initiale(), (((20-tuteur.get(i).getMoyenne()))/tuteur.get(i).getAnnee()+(tutore.get(j).getMoyenne()*3)));
				}else {
					g1.ajouterArete(tuteur.get(i).initiale(), tutore.get(j).initiale(), ((20-tuteur.get(i).getMoyenne())/tuteur.get(i).getAnnee()+tutore.get(j).getMoyenne()));
				}

			}

		}
	}

	public static ArrayList<String> tuteurMatriceAdj(ArrayList<Tuteur> tuteur ) {
		ArrayList<String> l1 = new ArrayList<String>();
		for(int i = 0 ; i < tuteur.size() ; i++){
			Tuteur  t = tuteur.get(i);
			l1.add(t.initiale());
		}
		return l1;
	}

	public static ArrayList<String> tutoreMatriceAdj(ArrayList<Candidat> tutore ) {
		ArrayList<String> l1 = new ArrayList<String>();
		for(int i = 0 ; i < tutore.size(); i++){
			l1.add(tutore.get(i).initiale());
		}
		return l1;
	}

	public static int moinsBonTuteur(ArrayList<Tuteur> tuteur) {
		double tmp = 20;
		int cpt = -1;
		int pos = 0;
		for(Tuteur t: tuteur) {
			cpt++;
			if(t.getMoyenne()<tmp) {
				tmp = t.getMoyenne();
				pos=cpt;
			}
		}
		
		return pos;
	}

	public static int meilleurCandidat(ArrayList<Candidat> tutore) {
		double tmp = 0;
		int cpt = -1;
		int pos = 0;
		for(Candidat c: tutore) {
			cpt++;
			if(c.getMoyenne()>tmp) {
				tmp = c.getMoyenne();
				pos=cpt;
			}
		}
		return pos;
	}

	public static void filtrage(ArrayList<Tuteur> tuteur, ArrayList<Candidat> tutore) {
		if(tuteur.size() != tutore.size()) {
			if(tuteur.size() > tutore.size()) {
				while(!(tuteur.size() == tutore.size())) {
					tuteur.remove(moinsBonTuteur(tuteur));
				}
			}else if(tuteur.size() < tutore.size()) {
				while(!(tuteur.size() == tutore.size())) {
					tuteur.remove(meilleurCandidat(tutore));
				}
			}
		}

	}

	public static void ExportGroupeTutoreMatiere(List<Arete> res , ArrayList<Tuteur> tuteur , ArrayList<Candidat> tutore ) {
		ArrayList<GroupeTutore> groupe_tutore = new ArrayList<GroupeTutore>();
		Tuteur t = tuteur.get(0);
		Candidat c = tutore.get(0);
		res.get(0).getExtremite1().toString().substring(2);
		for(int i = 0 ; i < res.size() ; i++ ) {
			for (int j = 0 ;j < tuteur.size() ; j++) {
				if (tuteur.get(j).getId()==Integer.parseInt(res.get(i).getExtremite1().toString().substring(2))){
					t = tuteur.get(j);
				}
				if (tutore.get(j).getId()==Integer.parseInt(res.get(i).getExtremite2().toString().substring(2))){
					c = tutore.get(j);
				}
			}
			groupe_tutore.add(new GroupeTutore(t,c));


		}

		try (BufferedWriter bw = new BufferedWriter(new FileWriter("./res/groupe"+tuteur.get(0).getMatiere()+".txt"))){
			for (GroupeTutore s : groupe_tutore) {

				bw.write(s.toString());
				bw.newLine();
			}
			bw.close();
		}
		catch (IOException ioe) {
			System.err.println("Erreur ecriture");
		}
	}




	public static void main(String[] args) {
		String ponderation = "null"; // � g�rer avec l'ihm
		Vivier vivier = new Vivier();
		vivier.remplirTuteurCandidatParMatiere();
		//Instanciation de notre Graphe g1, où l'on ajoutera nos candidats et tutorants en sommets
		GrapheNonOrienteValue<String> g1 = new GrapheNonOrienteValue();
		GrapheNonOrienteValue<String> g2 = new GrapheNonOrienteValue(); 
		GrapheNonOrienteValue<String> g3 = new GrapheNonOrienteValue(); 
		GrapheNonOrienteValue<String> g4 = new GrapheNonOrienteValue(); 
		GrapheNonOrienteValue<String> g5 = new GrapheNonOrienteValue(); 
		GrapheNonOrienteValue<String> g6 = new GrapheNonOrienteValue(); 
		GrapheNonOrienteValue<String> g7 = new GrapheNonOrienteValue(); 
		//filtrage, g�re si il y a trop d'�tudiants dans une des deux listes
		filtrage(vivier.getTuteursBAS_NIVEAU(),vivier.getCandidatsBAS_NIVEAU());
		filtrage(vivier.getTuteursBDD(),vivier.getCandidatsBDD());
		filtrage(vivier.getTuteursGRAPHES(),vivier.getCandidatsGRAPHES());
		filtrage(vivier.getTuteursIHM(),vivier.getCandidatsIHM());
		filtrage(vivier.getTuteursPOO(),vivier.getCandidatsPOO());
		filtrage(vivier.getTuteursSYSTEME(),vivier.getCandidatsSYSTEME());
		filtrage(vivier.getTuteursWEB(),vivier.getCandidatsWEB());
		// Les futurs abscisses et ordonnées de notre matrice d'adjacence
		// On remplit nos liste
		// tri par ordre croissant
		ArrayList<String> lTPOO = tuteurMatriceAdj(vivier.getTuteursPOO());
		ArrayList<String> lCPOO = tutoreMatriceAdj(vivier.getCandidatsPOO());
		ArrayList<String> lTIHM = tuteurMatriceAdj(vivier.getTuteursIHM());
		ArrayList<String> lCIHM = tutoreMatriceAdj(vivier.getCandidatsIHM());
		ArrayList<String> lTBDD = tuteurMatriceAdj(vivier.getTuteursBDD());
		ArrayList<String> lCBDD = tutoreMatriceAdj(vivier.getCandidatsBDD());
		ArrayList<String> lTGRAPHES = tuteurMatriceAdj(vivier.getTuteursGRAPHES());
		ArrayList<String> lCGRAPHES = tutoreMatriceAdj(vivier.getCandidatsGRAPHES());
		ArrayList<String> lTWEB = tuteurMatriceAdj(vivier.getTuteursWEB());
		ArrayList<String> lCWEB = tutoreMatriceAdj(vivier.getCandidatsWEB());
		ArrayList<String> lTBASNIVEAU = tuteurMatriceAdj(vivier.getTuteursBAS_NIVEAU());
		ArrayList<String> lCBASNIVEAU = tutoreMatriceAdj(vivier.getCandidatsBAS_NIVEAU());
		ArrayList<String> lTSYSTEME = tuteurMatriceAdj(vivier.getTuteursSYSTEME());
		ArrayList<String> lCSYSTEME = tutoreMatriceAdj(vivier.getCandidatsSYSTEME());
		//Ici, à l'aide d'un double for, nous affectons les poids sur chaques arêtes grâce à notre fonction, pour ensuite faire une affectation de coût minimale
		AddSommetAffectation(g1,vivier.getTuteursPOO(),vivier.getCandidatsPOO(),ponderation);
		AddSommetAffectation(g3,vivier.getTuteursBDD(),vivier.getCandidatsBDD(),ponderation);
		AddSommetAffectation(g4,vivier.getTuteursGRAPHES(),vivier.getCandidatsGRAPHES(),ponderation);
		AddSommetAffectation(g5,vivier.getTuteursWEB(),vivier.getCandidatsWEB(),ponderation);
		AddSommetAffectation(g2,vivier.getTuteursIHM(),vivier.getCandidatsIHM(),ponderation);
		AddSommetAffectation(g6,vivier.getTuteursBAS_NIVEAU(),vivier.getCandidatsBAS_NIVEAU(),ponderation);
		AddSommetAffectation(g7,vivier.getTuteursSYSTEME(),vivier.getCandidatsSYSTEME(),ponderation);
		CalculAffectation caPOO = new CalculAffectation(g1, lTPOO, lCPOO);
		CalculAffectation caIHM = new CalculAffectation(g2, lTIHM, lCIHM);
		CalculAffectation caBDD = new CalculAffectation(g3,lTBDD, lCBDD);
		CalculAffectation caGRAPHES = new CalculAffectation(g4, lTGRAPHES, lCGRAPHES);
		CalculAffectation caWEB = new CalculAffectation(g5, lTWEB, lCWEB);
		CalculAffectation caBASNIVEAU = new CalculAffectation(g6,lTBASNIVEAU, lCBASNIVEAU);
		CalculAffectation caSYSTEME = new CalculAffectation(g7, lTSYSTEME, lCSYSTEME);
		List<Arete> resPOO = caPOO.getAffectation();
		List<Arete> resIHM = caIHM.getAffectation();
		List<Arete> resBDD = caBDD.getAffectation();
		List<Arete> resGRAPHES = caGRAPHES.getAffectation();
		List<Arete> resWEB = caWEB.getAffectation();
		List<Arete> resBASNIVEAU = caBASNIVEAU.getAffectation();
		List<Arete> resSYSTEME = caSYSTEME.getAffectation();
		ExportGroupeTutoreMatiere(resWEB,vivier.getTuteursWEB(),vivier.getCandidatsWEB());
		ExportGroupeTutoreMatiere(resPOO,vivier.getTuteursPOO(),vivier.getCandidatsPOO());
		ExportGroupeTutoreMatiere(resIHM,vivier.getTuteursIHM(),vivier.getCandidatsIHM());
		ExportGroupeTutoreMatiere(resBDD,vivier.getTuteursBDD(),vivier.getCandidatsBDD());
		ExportGroupeTutoreMatiere(resGRAPHES,vivier.getTuteursGRAPHES(),vivier.getCandidatsGRAPHES());
		ExportGroupeTutoreMatiere(resBASNIVEAU,vivier.getTuteursBAS_NIVEAU(),vivier.getCandidatsBAS_NIVEAU());
		ExportGroupeTutoreMatiere(resSYSTEME,vivier.getTuteursSYSTEME(),vivier.getCandidatsSYSTEME());
		System.out.println("Les résultats sont dans le fichier res.");


	}
}

