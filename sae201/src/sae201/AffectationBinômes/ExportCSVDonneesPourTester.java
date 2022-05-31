package AffectationBinômes;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fr.ulille.but.sae2_02.donnees.DonneesPourTester;

public class ExportCSVDonneesPourTester {
	public static void main(String[] args) {
		DonneesPourTester donnees = new DonneesPourTester();
		final String DELIMITER = ",";
		final String SEPARATOR = "\n";

		final String HEADER = "Prénom,Nom,Moyenne,Année";

		String[][] etudiants = new String[57][4];
		
		for(int i = 0 ; i < donnees.studentData.length ; i++) {
			for(int j = 0 ; j < 4 ; j++ ) {
				etudiants[i][j] = donnees.studentData[i][j] ;
			}
		}
		
		FileWriter file = null;
		
		try{
			file = new FileWriter("Etudiant.csv");
			file.append(HEADER);
			file.append(SEPARATOR);
			int cpt = 0;
			while(cpt < 57)
			{
				file.append(etudiants[cpt][0]);
				file.append(DELIMITER);
				file.append(etudiants[cpt][1]);
				file.append(DELIMITER);
				file.append(etudiants[cpt][2]);
				file.append(DELIMITER);
				file.append(etudiants[cpt][3]);
				file.append(SEPARATOR);
				cpt++;
			}

			file.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

