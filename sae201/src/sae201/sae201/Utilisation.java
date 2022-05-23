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
	
	
	public static void AddSommetAffectation(GrapheNonOrienteValue<String> g1 , Vivier vivier) {
		for(int i = 0 ; i < vivier.getTuteurs().size() ; i++) {
			Tuteur  t = vivier.getTuteurI(i);
			g1.ajouterSommet(t.initiale());
			for(int j = 0 ; j < vivier.getCandidats().size() ; j++) {
				
				g1.ajouterSommet(vivier.getCandidatI(j).initiale());
				//System.out.println(vivier.getTuteurI(i).initiale()+"     "+vivier.getCandidatI(j).initiale()+"     "+((20-vivier.getTuteurI(i).getMoyenne())/vivier.getTuteurI(i).getAnnee()+vivier.getCandidatI(j).getMoyenne()));
				g1.ajouterArete(vivier.getTuteurI(i).initiale(), vivier.getCandidatI(j).initiale(), ((20-vivier.getTuteurI(i).getMoyenne())/vivier.getTuteurI(i).getAnnee()+vivier.getCandidatI(j).getMoyenne()));
			}
			
		}
	}
	
	public static void tuteurMatriceAdj(ArrayList<Tuteur> tuteur , ArrayList<String> l2) {
		for(int i = 0 ; i < tuteur.size() ; i++){
			Tuteur  t = tuteur.get(i);
			l2.add(t.initiale());
		}
	}
	
	public static void tutoreMatriceAdj(ArrayList<Candidat> tutore , ArrayList<String> l1) {
		for(int i = 0 ; i < tutore.size(); i++){
			l1.add(tutore.get(i).initiale());
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
		vivier.remplirTuteurCandidat();
		ArrayList<GroupeTutore> groupe_tutore = new ArrayList<GroupeTutore>();
		//Instanciation de notre Graphe g1, où l'on ajoutera nos candidats et tutorants en sommets
		GrapheNonOrienteValue<String> g1 = new GrapheNonOrienteValue(); 
		//Les futurs abscisses et ordonnées de notre matrice d'adjacence
		ArrayList<String> l1 = new ArrayList<String>();
		ArrayList<String> l2 = new ArrayList<String>();
		//On remplit nos liste
		// tri par ordre croissant
		vivier.triSuppression();
		tuteurMatriceAdj(vivier.getTuteurs(),l1);
		tutoreMatriceAdj(vivier.getCandidats(),l2);
		//Ici, à l'aide d'un double for, nous affectons les poids sur chaques arêtes grâce à notre fonction, pour ensuite faire une affectation de coût minimale
		AddSommetAffectation(g1,vivier);
		CalculAffectation ca = new CalculAffectation(g1, l1, l2);
		List<Arete> res = ca.getAffectation();
		Tuteur t = vivier.getTuteurI(0);
		Candidat c = vivier.getCandidatI(0);
		res.get(0).getExtremite1().toString().substring(2);
		for(int i = 0 ; i < res.size() ; i++ ) {
			for (int j = 0 ;j < vivier.getTuteurs().size() ; j++) {
				if (vivier.getTuteurI(j).getId()==Integer.parseInt(res.get(i).getExtremite1().toString().substring(2))){
					 t = vivier.getTuteurI(j);
				}
				if (vivier.getCandidatI(j).getId()==Integer.parseInt(res.get(i).getExtremite2().toString().substring(2))){
					 c = vivier.getCandidatI(j);
				}
			}
			groupe_tutore.add(new GroupeTutore(t,c));
			
				
		}
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("/home/infoetu/pierre.goujet.etu/sae201/resultatgroupe.txt"))){
			for (GroupeTutore s : groupe_tutore) {
				
				bw.write(s.toString());
				bw.newLine();
			}
		}
		catch (IOException ioe) {
			System.err.println("Erreur ecriture");
		}
		System.out.println("\nCouple tuteurs/tutorés");
		System.out.println(res);
		System.out.println("Résultat: " + ca.getCout());
		System.out.println(g1);
		System.out.println(groupe_tutore);
		
	}
}

