package sae201;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fr.ulille.but.sae2_02.graphes.Arete;
import fr.ulille.but.sae2_02.graphes.CalculAffectation;
import fr.ulille.but.sae2_02.graphes.GrapheNonOrienteValue;

public class Utilisation {
	
	
	public static void AddSommetAffectation(GrapheNonOrienteValue<String> g1 , ArrayList<Tuteur> tuteur , ArrayList<Candidat> tutore) {
		for(int i = 0 ; i < tuteur.size() ; i++) {
			Tuteur  t =tuteur.get(i);
			g1.ajouterSommet(t.initiale());
			for(int j = 0 ; j < tutore.size() ; j++) {
				
				g1.ajouterSommet(tutore.get(j).initiale());
				//System.out.println(vivier.getTuteurI(i).initiale()+"     "+vivier.getCandidatI(j).initiale()+"     "+((20-vivier.getTuteurI(i).getMoyenne())/vivier.getTuteurI(i).getAnnee()+vivier.getCandidatI(j).getMoyenne()));
				g1.ajouterArete(tuteur.get(i).initiale(), tutore.get(j).initiale(), ((20-tuteur.get(i).getMoyenne())/tuteur.get(i).getAnnee()+tutore.get(j).getMoyenne()));
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
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("./resultatgroupe"+tuteur.get(0).getMatiere()+".txt"))){
			for (GroupeTutore s : groupe_tutore) {
				
				bw.write(s.toString());
				bw.newLine();
			}
		}
		catch (IOException ioe) {
			System.err.println("Erreur ecriture");
		}
	}
	
	/*vivier.remplirTuteurCandidat();
	ArrayList<GroupeTutore> groupe_tutore = new ArrayList<GroupeTutore>();
	//Instanciation de notre Graphe g1, où l'on ajoutera nos candidats et tutorants en sommets
	GrapheNonOrienteValue<String> g1 = new GrapheNonOrienteValue(); 
	//Les futurs abscisses et ordonnées de notre matrice d'adjacence
	ArrayList<String> l1 = new ArrayList<String>();
	ArrayList<String> l2 = new ArrayList<String>();
	//On remplit nos liste
	// tri par ordre croissant
	vivier.triSuppression();
	tuteurMatriceAdj(vivier.getTuteurs(),l2);
	tutoreMatriceAdj(vivier.getCandidats(),l1);
	//Ici, à l'aide d'un double for, nous affectons les poids sur chaques arêtes grâce à notre fonction, pour ensuite faire une affectation de coût minimale
	AddSommetAffectation(g1,vivier);
	CalculAffectation ca = new CalculAffectation(g1, l1, l2);
	List res = ca.getAffectation();
	System.out.println("\nCouple tuteurs/tutorés");
	System.out.println(res);
	System.out.println("Résultat: " + ca.getCout());
<<<<<<< HEAD
	System.out.println(g1);
	*/
	
	
	public static void main(String[] args) {
		Vivier vivier = new Vivier();
		/*Vivier vivierPOO = new Vivier();
		Vivier vivierIHM = new Vivier();
		Vivier vivierBDD = new Vivier();
		Vivier vivierGRAPHES = new Vivier();
		Vivier vivierWEB = new Vivier();
		Vivier vivierBAS_NIVEAU = new Vivier();
		Vivier vivierSYSTEME = new Vivier();*/
		vivier.remplirTuteurCandidatParMatiere();
		//Instanciation de notre Graphe g1, où l'on ajoutera nos candidats et tutorants en sommets
		GrapheNonOrienteValue<String> g1 = new GrapheNonOrienteValue();
		GrapheNonOrienteValue<String> g2 = new GrapheNonOrienteValue(); 
		GrapheNonOrienteValue<String> g3 = new GrapheNonOrienteValue(); 
		GrapheNonOrienteValue<String> g4 = new GrapheNonOrienteValue(); 
		GrapheNonOrienteValue<String> g5 = new GrapheNonOrienteValue(); 
		GrapheNonOrienteValue<String> g6 = new GrapheNonOrienteValue(); 
		GrapheNonOrienteValue<String> g7 = new GrapheNonOrienteValue(); 
		//Les futurs abscisses et ordonnées de notre matrice d'adjacence
		
		//On remplit nos liste
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
		AddSommetAffectation(g1,vivier.getTuteursPOO(),vivier.getCandidatsPOO());
		AddSommetAffectation(g3,vivier.getTuteursBDD(),vivier.getCandidatsBDD());
		AddSommetAffectation(g4,vivier.getTuteursGRAPHES(),vivier.getCandidatsGRAPHES());
		AddSommetAffectation(g5,vivier.getTuteursWEB(),vivier.getCandidatsWEB());
		AddSommetAffectation(g2,vivier.getTuteursIHM(),vivier.getCandidatsIHM());
		AddSommetAffectation(g6,vivier.getTuteursBAS_NIVEAU(),vivier.getCandidatsBAS_NIVEAU());
		AddSommetAffectation(g7,vivier.getTuteursSYSTEME(),vivier.getCandidatsSYSTEME());
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
		ExportGroupeTutoreMatiere(resPOO,vivier.getTuteursPOO(),vivier.getCandidatsPOO());
		ExportGroupeTutoreMatiere(resIHM,vivier.getTuteursIHM(),vivier.getCandidatsIHM());
		ExportGroupeTutoreMatiere(resBDD,vivier.getTuteursBDD(),vivier.getCandidatsBDD());
		ExportGroupeTutoreMatiere(resGRAPHES,vivier.getTuteursGRAPHES(),vivier.getCandidatsGRAPHES());
		ExportGroupeTutoreMatiere(resWEB,vivier.getTuteursWEB(),vivier.getCandidatsWEB());
		ExportGroupeTutoreMatiere(resBASNIVEAU,vivier.getTuteursBAS_NIVEAU(),vivier.getCandidatsBAS_NIVEAU());
		ExportGroupeTutoreMatiere(resSYSTEME,vivier.getTuteursSYSTEME(),vivier.getCandidatsSYSTEME());
		System.out.println("Les résultats sont dans le fichier courant.");
		
	}
}

