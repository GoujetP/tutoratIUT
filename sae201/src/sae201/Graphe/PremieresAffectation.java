package Graphe;
import java.util.ArrayList;
import java.util.List;

import ModelisationEtudiants.Candidat;
import ModelisationEtudiants.Tuteur;
import fr.ulille.but.sae2_02.donnees.DonneesPourTester;
import fr.ulille.but.sae2_02.graphes.CalculAffectation;
import fr.ulille.but.sae2_02.graphes.GrapheNonOrienteValue;
import fr.ulille.but.sae2_02.graphes.CalculAffectation;
import fr.ulille.but.sae2_02.graphes.GrapheNonOrienteValue;

import java.util.ArrayList;
import java.util.List;

public class PremieresAffectation {
	
	public static void main(String[] args) {
		
		// La classe DonneesPourTester nous donne une liste d'étudiants exemple, qui nous serviront à faire nos tests d'affectations
		DonneesPourTester donnees = new DonneesPourTester();
		
		//Tableau de tuteur et de tutoré de taille prédefini
		String[][] tutore = new String[5][4];
		String[][] tuteur = new String[6][4];

		//On parcourt parmis les premiers de la liste pour choisir nos "candidats" en première année
		for(int i = 0 ; i < 5 ; i++) {
			for(int j = 0 ; j < 4 ; j++ ) {
				tutore[i][j] = donnees.studentData[i][j] ;
			}
		}

		//On parcourt parmis les derniers de la liste pour choisir nos "tutorants" en seconde et troisième années
		int cpt = 0;
		for(int i = 45 ; i < 51 ; i++) {
			for(int j = 0 ; j < 4 ; j++ ) {
				tuteur[cpt][j] = donnees.studentData[i][j] ;
			}
			cpt++;
		}

		//Instanciation de notre Graphe g1, où l'on ajoutera nos candidats et tutorants en sommets
		GrapheNonOrienteValue<String> g1 = new GrapheNonOrienteValue(); 
		
		//Des ArrayLists avec nos classes, plus pratique pour utiliser les méthodes
		ArrayList<Candidat> cand = new ArrayList<Candidat>();
		ArrayList<Tuteur> tut = new ArrayList<Tuteur>();
		
		//Les futurs abscisses et ordonnées de notre matrice d'adjacence
		ArrayList<String> l1 = new ArrayList();
		ArrayList<String> l2 = new ArrayList();

		//On remplit nos listes
		for(int i = 0 ; i < 5; i++){
			Candidat  c = new Candidat(tutore[i][1],tutore[i][0],Double.parseDouble(tutore[i][2]),Integer.parseInt(tutore[i][3]));
			g1.ajouterSommet(c.initiale());
			l1.add(c.initiale());
			cand.add(c);
			System.out.println(c.toString());
		}
		for(int i = 0 ; i < 5 ; i++){
			if(Integer.parseInt(tuteur[i][3]) > 1) {
				Tuteur  t = new Tuteur(tuteur[i][1],tuteur[i][0],Double.parseDouble(tuteur[i][2]),Integer.parseInt(tuteur[i][3]));
				g1.ajouterSommet(t.initiale());
				l2.add(t.initiale());
				tut.add(t);	
				System.out.println(t.toString());
			}
		}

		//Ici, à l'aide d'un double for, nous affectons les poids sur chaques arêtes grâce à notre fonction, pour ensuite faire une affectation de coût minimale
		for(int i = 0 ; i < tut.size() ; i++) {
			for(int j = 0 ; j < cand.size() ; j++) {
				g1.ajouterArete(tut.get(i).initiale(), cand.get(j).initiale() , ((20-tut.get(i).getMoyenne())/tut.get(i).getAnnee()+cand.get(j).getMoyenne()));
			}
		}

		
		CalculAffectation ca = new CalculAffectation(g1, l1, l2);
		List res = ca.getAffectation();
		
		System.out.println("\nCouple tuteurs/tutorés");
		System.out.println(res);
		System.out.println("Résultat: " + ca.getCout());
		System.out.println(g1);
	}
}
