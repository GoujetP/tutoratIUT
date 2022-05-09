package sae201;

import fr.ulille.but.sae2_02.donnees.DonneesPourTester;
import fr.ulille.but.sae2_02.graphes.GrapheNonOrienteValue;

import java.util.ArrayList;

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
		}

		GrapheNonOrienteValue<String> g1 = new GrapheNonOrienteValue(); 
		
		g1.ajouterSommet("CA");
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


	}
}
