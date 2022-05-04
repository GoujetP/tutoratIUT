package sae201;

import fr.ulille.but.sae2_02.donnees.DonneesPourTester;
import fr.ulille.but.sae2_02.graphes.CalculAffectation;
import fr.ulille.but.sae2_02.graphes.GrapheNonOrienteValue;

import java.util.ArrayList;
import java.util.List;

public class testAffectation {
	public static void main(String[] args) {
		DonneesPourTester donnees = new DonneesPourTester();
		String[][] tutore = new String[6][4];
		String[][] tuteur = new String[5][4];

		for(int i = 0 ; i < 6 ; i++) {
			for(int j = 0 ; j < 4 ; j++ ) {
				//System.out.print(donnees.studentData[i][j].toString() + " ");
				tutore[i][j] = donnees.studentData[i][j] ;
			}
			System.out.print("\n");
		}

		System.out.print("\n");

		int cpt = 0;
		for(int i = 45 ; i < 50 ; i++) {
			for(int j = 0 ; j < 4 ; j++ ) {
				//System.out.print(donnees.studentData[i][j].toString() + " ");
				tuteur[cpt][j] = donnees.studentData[i][j] ;
			}
			cpt++;
			System.out.print("\n");
		}

		GrapheNonOrienteValue<String> g1 = new GrapheNonOrienteValue(); 
		ArrayList<Candidat> cand = new ArrayList<Candidat>();
		ArrayList<Tuteur> tut = new ArrayList<Tuteur>();

		for(int i = 0 ; i < 5 ; i++){
			Candidat  c = new Candidat(tutore[i][1],tutore[i][0],Integer.parseInt(tutore[i][3]),Double.parseDouble(tutore[i][2]));
			g1.ajouterSommet(c.initiale());
			cand.add(c);
		}

		for(int i = 0 ; i < 5 ; i++){
			if(Integer.parseInt(tuteur[i][3]) > 1) {
				Tuteur  t = new Tuteur(tuteur[i][1],tuteur[i][0],Integer.parseInt(tuteur[i][3]),Double.parseDouble(tuteur[i][2]));
				g1.ajouterSommet(t.initiale());
				tut.add(t);	
			}
		}

		for(int i = 0 ; i < tut.size() ; i++) {
			for(int j = 0 ; j < cand.size() ; j++) {
				g1.ajouterArete(tut.get(i).initiale(), cand.get(j).initiale() , ((20-tut.get(i).getMoyenne())/tut.get(i).getAnnee()+cand.get(j).getMoyenne()));
			}
		}

		CalculAffectation ca = new CalculAffectation(g1, cand, tut);
		List res = ca.getAffectation();
		
		System.out.println(res);
		System.out.println("Résultat: " + ca.getCout());
		System.out.println(g1);

		/*
		for(int i = 0 ; i < 6 ; i++) {
			for(int j = 0 ; j < 4 ; j++ ) {
				System.out.print(tutore[i][j] + " ");
			}
			System.out.print("\n");
		}
		for(int i = 0 ; i < 5 ; i++) {
			for(int j = 0 ; j < 4 ; j++ ) {
				System.out.print(tuteur[i][j] + " ");
			}
			System.out.print("\n");
		}*/





		/*g1.ajouterSommet("CA");
		g1.ajouterSommet("MB");
		g1.ajouterSommet("SB");
		g1.ajouterSommet("HB");
		g1.ajouterSommet("LB");
		g1.ajouterSommet("AB");
		g1.ajouterSommet("NR");
		g1.ajouterSommet("JT");
		g1.ajouterSommet("SV");
		g1.ajouterSommet("EA");
		g1.ajouterSommet("OG");
		 */
		//(20-moytut)/anneetut + moyennecand


	}
}
