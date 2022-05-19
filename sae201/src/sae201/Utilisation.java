package sae201;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fr.ulille.but.sae2_02.donnees.DonneesPourTester;
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
	
	
	
	public static void main(String[] args) {
		
		Vivier vivier = new Vivier();
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
			tuteurMatriceAdj(vivier.getTuteurs(),l2);
			tutoreMatriceAdj(vivier.getCandidats(),l1);
			//Ici, à l'aide d'un double for, nous affectons les poids sur chaques arêtes grâce à notre fonction, pour ensuite faire une affectation de coût minimale
			AddSommetAffectation(g1,vivier);
			CalculAffectation ca = new CalculAffectation(g1, l1, l2);
			List res = ca.getAffectation();
			System.out.println("\nCouple tuteurs/tutorés");
			System.out.println(res);
			System.out.println("Résultat: " + ca.getCout());
			System.out.println(g1);
		}
	}
