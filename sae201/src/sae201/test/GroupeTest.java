package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ModelisationEtudiants.Candidat;
import ModelisationEtudiants.GroupeTutore;
import ModelisationEtudiants.Matiere;
import ModelisationEtudiants.Tuteur;

public class GroupeTest {
	
	@Test 
	void testToString() {
		Tuteur tuteur1 = new Tuteur("Sanchez","Paul",15,3,Matiere.POO);
		Candidat eleve1 = new Candidat("Lecocq","Marie",8,1,Matiere.POO);
		GroupeTutore groupe1 = new GroupeTutore(tuteur1,eleve1);
		
		Tuteur tuteur2 = new Tuteur("Letellier","Quentin",14.5,3,Matiere.IHM);
		Candidat eleve2 = new Candidat("Guerin","Émile",5,4.8,Matiere.IHM);
		GroupeTutore groupe2 = new GroupeTutore(tuteur2,eleve2);
		assertEquals("Le groupe : 1, tuteur= Paul Sanchez, eleve= Marie Lecocq",groupe1.toString());
		assertEquals("Le groupe : 5, tuteur= Quentin Letellier, eleve= Emile Guerin",groupe2.toString());
	}
}
