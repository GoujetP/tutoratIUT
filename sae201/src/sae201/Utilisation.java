package sae201;

import java.util.ArrayList;
import java.util.List;

import fr.ulille.but.sae2_02.donnees.DonneesPourTester;
import fr.ulille.but.sae2_02.graphes.CalculAffectation;
import fr.ulille.but.sae2_02.graphes.GrapheNonOrienteValue;

public class Utilisation {
	public static void main(String[] args) {
			
			// La classe DonneesPourTester nous donne une liste d'étudiants exemple, qui nous serviront à faire nos tests d'affectations
			DonneesPourTester donnees = new DonneesPourTester();
			
			//Tableau de tuteur et de tutoré de taille prédefini
			ArrayList<Candidat> tutore = new ArrayList<Candidat>();
			ArrayList<Tuteur> tuteur= new ArrayList<Tuteur>();
			Vivier vivier = new Vivier();
			
			//On parcourt parmis les premiers de la liste pour choisir nos "candidats" en première année
			for(int i = 0 ; i < donnees.studentData.length ; i++) {
				if (Integer.parseInt(donnees.studentData[i][3])==1){
					tutore.add(new Candidat(donnees.studentData[i][0],donnees.studentData[i][1],Double.parseDouble(donnees.studentData[i][2]),Integer.parseInt(donnees.studentData[i][3])));
				}
			}
			
			//On parcourt parmis les derniers de la liste pour choisir nos "tutorants" en seconde et troisième années
			int cpt = 0;
			for(int i = 0 ; i < donnees.studentData.length  ; i++) {
				if (Integer.parseInt(donnees.studentData[i][3])>1) {
					tuteur.add(new Tuteur(donnees.studentData[i][0],donnees.studentData[i][1],Double.parseDouble(donnees.studentData[i][2]),Integer.parseInt(donnees.studentData[i][3])));
				}
			}
			vivier.setCandidats(tutore);
			vivier.setTuteurs(tuteur);
			ArrayList<GroupeTutore> groupe_tutore = new ArrayList<GroupeTutore>();
			//Instanciation de notre Graphe g1, où l'on ajoutera nos candidats et tutorants en sommets
			GrapheNonOrienteValue<String> g1 = new GrapheNonOrienteValue(); 
			
	
			
			//Les futurs abscisses et ordonnées de notre matrice d'adjacence
			ArrayList<String> l1 = new ArrayList();
			ArrayList<String> l2 = new ArrayList();
	
			//On remplit nos listes
			for(int i = 0 ; i < tutore.size(); i++){
				
				g1.ajouterSommet(tutore.get(i).initiale());
				l1.add(tutore.get(i).initiale());
				System.out.println(tutore.get(i).toString());
			}
			for(int i = 0 ; i < tuteur.size() ; i++){
					Tuteur  t = tuteur.get(i);
					g1.ajouterSommet(t.initiale());
					l2.add(t.initiale());
					System.out.println(t.toString());
				
			}
			//Ici, à l'aide d'un double for, nous affectons les poids sur chaques arêtes grâce à notre fonction, pour ensuite faire une affectation de coût minimale
			for(int i = 0 ; i < vivier.getTuteurs().size() ; i++) {
				for(int j = 0 ; j < vivier.getCandidats().size() ; j++) {
					g1.ajouterArete(vivier.getTuteurI(i).initiale()+i, vivier.getCandidatI(i).initiale()+j, ((20-vivier.getTuteurI(i).getMoyenne())/vivier.getTuteurI(i).getAnnee()+vivier.getCandidatI(i).getMoyenne()));
				}
			}
	
			
			CalculAffectation ca = new CalculAffectation(g1, l1, l2);
			List res = ca.getAffectation();
			
			System.out.println("\nCouple tuteurs/tutorés");
			System.out.println(res);
			System.out.println("Résulta: " + ca.getCout());
			System.out.println(g1);
		}
	}
