package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ModelisationEtudiants.Candidat;
import ModelisationEtudiants.Etudiant;
import ModelisationEtudiants.Matiere;
import ModelisationEtudiants.Motivation;
import ModelisationEtudiants.Tuteur;
import AffectationBinomes.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

public class EtudiantTest {
	public Etudiant etu1;
	public Candidat cand1;
	public Candidat cand2;
	public Tuteur tut1;
	public Tuteur tut2;
	public Tuteur tut3;

	@BeforeEach
	public void avantTest() {
		etu1 = new Etudiant("Lecocq","Marie",1,12.7);
		cand1 = new Candidat("Allard","Claude",1,9.8,Motivation.TRES_MOTIVE,Matiere.POO);
		cand2 = new Candidat("Guerin","Émile",1,4.8,Motivation.TRES_MOTIVE,Matiere.IHM);
		tut1 = new Tuteur("Sanchez","Paul",15.8,2,Matiere.POO);
		tut2 = new Tuteur("Letellier","Quentin",14.5,3,Matiere.IHM);
		tut3 = new Tuteur("Fanion","Daniel",9.1,2,Matiere.BAS_NIVEAU);
	}
	
	@Test 
	void testToString() {
		assertEquals("Etudiant [Marie Lecocq:12.7 de moyenne en 1e annee]",etu1.toString());
		assertEquals("Allard Claude",cand1.toString());
		assertEquals("Guerin Émile",cand2.toString());
		assertEquals("Sanchez Paul",tut1.toString());
		assertEquals("Letellier Quentin",tut2.toString());
	}
	
	//Test de la classe Affectation
	void testTriTuteur() {
		ArrayList<Tuteur> tuteur = new ArrayList<Tuteur>();
		ArrayList<Candidat> candidat = new ArrayList<Candidat>();
		ArrayList<Tuteur> tuteur2 = new ArrayList<Tuteur>();
		
		candidat.add(cand1);
		candidat.add(cand1);
		tuteur.add(tut1);
		tuteur.add(tut2);
		tuteur.add(tut3);
		tuteur2.add(tut1);
		tuteur2.add(tut2);
		
		
		filtrage(tuteur,candidat);
		assertEquals(tuteur,tuteur2);
		
	}

	private void filtrage(ArrayList<Tuteur> tuteur, ArrayList<Candidat> candidat) {
		// TODO Auto-generated method stub
		
	}
}
