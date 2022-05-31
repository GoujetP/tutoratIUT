package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ModelisationEtudiants.Candidat;
import ModelisationEtudiants.Etudiant;
import ModelisationEtudiants.Matiere;
import ModelisationEtudiants.Motivation;
import ModelisationEtudiants.Tuteur;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
	}
	
	@Test 
	void testToString() {
		assertEquals("Etudiant [Marie Lecocq:12.7 de moyenne en 1e annee]",etu1.toString());
		assertEquals("Candidat [Claude Allard:9.8 de moyenne en 1e annee, motivation:TRES_MOTIVE, matière:POO, id:1]",cand1.toString());
		assertEquals("Candidat [Émile Guerin:4.8 de moyenne en 1e annee, motivation:TRES_MOTIVE, matière:IHM, id:2]",cand2.toString());
		assertEquals("Tuteur [Paul Sanchez:15.8 de moyenne en 2e annee, matière:POO, id:3]",tut1.toString());
		assertEquals("Tuteur [Quentin Letellier:14.5 de moyenne en 3e annee, matière:IHM, id:4]",tut2.toString());
	}
}
