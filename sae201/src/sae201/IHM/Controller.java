package IHM;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import AffectationBinomes.Vivier;
import ModelisationEtudiants.Candidat;
import ModelisationEtudiants.GroupeTutore;
import ModelisationEtudiants.Tuteur;
import fr.ulille.but.sae2_02.graphes.Arete;
import fr.ulille.but.sae2_02.graphes.CalculAffectation;
import fr.ulille.but.sae2_02.graphes.GrapheNonOrienteValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;

public class Controller {
	private int indexList;
	class TutoreInfoListener implements ListChangeListener<String> {
	    public void onChanged(Change<? extends String> report) {
	    	ArrayList<GroupeTutore > g ;
	    	String verif;
	    	if (!matiere.getValue().equals(null) && matiere.getValue().equals("POO")) {
				g=gt2;
			}
			else if (matiere.getValue().equals("IHM")) {
				g=gt3;
			}
			else if (matiere.getValue().equals("BDD")) {
				g=gt4;
			}
			else if (matiere.getValue().equals("WEB")) {
				g=gt1;
			}
			else if (matiere.getValue().equals("GRAPHES")) {
				g=gt5;
			}
			else if (matiere.getValue().equals("BAS_NIVEAU")) {
				g=gt6;
			}
			else  {
				g=gt7;
			}
	    	indexList = l_tutore.getSelectionModel().getSelectedIndex();
	    	verif = l_tutore.getSelectionModel().getSelectedItem();
	    	GroupeTutore groupe = g.get(0);
	    	for (GroupeTutore gr : g) {
	    		if (gr.getEleve().toString().equals(verif) && gr.getTuteur().toString().equals(l_tuteur.getItems().get(indexList))) {
	    			groupe=gr;
	    			break;
	    		}
	    	}
	    	String res = "ID : "+groupe.getTuteur().getId()+"\n"+"Nom : "+groupe.getTuteur().getNom()+"\n"+"Prénom :"+groupe.getTuteur().getPrenom()+"\n"+"Moyenne "+groupe.getTuteur().getMoyenne();
	      infos_tuteur.setText(res );
	      res="ID : "+groupe.getEleve().getId()+"\n"+"Nom : "+groupe.getEleve().getNom()+"\n"+"Prénom :"+groupe.getEleve().getPrenom()+"\n"+"Moyenne "+groupe.getEleve().getMoyenne();
	      info_tutore.setText(res);
	    }
	  }
	class TuteurInfoListener implements ListChangeListener<String> {
	    public void onChanged(Change<? extends String> report) {
	    	ArrayList<GroupeTutore > g ;
	    	String verif;
	    	if (!matiere.getValue().equals(null) && matiere.getValue().equals("POO")) {
				g=gt2;
			}
			else if (matiere.getValue().equals("IHM")) {
				g=gt3;
			}
			else if (matiere.getValue().equals("BDD")) {
				g=gt4;
			}
			else if (matiere.getValue().equals("WEB")) {
				g=gt1;
			}
			else if (matiere.getValue().equals("GRAPHES")) {
				g=gt5;
			}
			else if (matiere.getValue().equals("BAS_NIVEAU")) {
				g=gt6;
			}
			else  {
				g=gt7;
			}
	    	indexList = l_tuteur.getSelectionModel().getSelectedIndex();
	    	verif = l_tuteur.getSelectionModel().getSelectedItem();
	    	GroupeTutore groupe = g.get(0);
	    	for (GroupeTutore gr : g) {
	    		if (gr.getTuteur().toString().equals(verif) && gr.getEleve().toString().equals(l_tutore.getItems().get(indexList))) {
	    			groupe=gr;
	    			break;
	    		}
	    	}
	    	String res = "ID : "+groupe.getTuteur().getId()+"\n"+"Nom : "+groupe.getTuteur().getNom()+"\n"+"Prénom :"+groupe.getTuteur().getPrenom()+"\n"+"Moyenne "+groupe.getTuteur().getMoyenne();
	      infos_tuteur.setText(res );
	      res="ID : "+groupe.getEleve().getId()+"\n"+"Nom : "+groupe.getEleve().getNom()+"\n"+"Prénom :"+groupe.getEleve().getPrenom()+"\n"+"Moyenne "+groupe.getEleve().getMoyenne();
	      info_tutore.setText(res);
	    }
	  }

	public static ArrayList<GroupeTutore> ExportGroupeTutoreMatiere(List<Arete> res , ArrayList<Tuteur> tuteur , ArrayList<Candidat> tutore ) {
		ArrayList<GroupeTutore> groupe_tutore = new ArrayList<GroupeTutore>();
		Tuteur t = tuteur.get(0);
		Candidat c = tutore.get(0);
		for(int i = 0 ; i < res.size() ; i++ ) {
			for (int j = 0 ;j < tuteur.size() ; j++) {
				if (tuteur.get(j).getId()==Integer.parseInt(res.get(i).getExtremite1().toString().substring(2))){
					 t = tuteur.get(j);
				}
				if (tutore.get(j).getId()==Integer.parseInt(res.get(i).getExtremite2().toString().substring(2))){
					 c = tutore.get(j);
				}
			}
			groupe_tutore.add(new GroupeTutore(t,c));
			
				
		}
		return groupe_tutore;
		
	}
	
	public static void AddSommetAffectation(GrapheNonOrienteValue<String> g1 , ArrayList<Tuteur> tuteur , ArrayList<Candidat> tutore) {
		for(int i = 0 ; i < tuteur.size() ; i++) {
			Tuteur  t =tuteur.get(i);
			g1.ajouterSommet(t.initiale());
			for(int j = 0 ; j < tutore.size() ; j++) {
				
				g1.ajouterSommet(tutore.get(j).initiale());
				g1.ajouterArete(tuteur.get(i).initiale(), tutore.get(j).initiale(), ((20-tuteur.get(i).getMoyenne())/tuteur.get(i).getAnnee()+tutore.get(j).getMoyenne()));
			}
			
		}
	}
	
	public static ArrayList<String> tuteurMatriceAdj(ArrayList<Tuteur> tuteur ) {
		ArrayList<String> l1 = new ArrayList<String>();
		for(int i = 0 ; i < tuteur.size() ; i++){
			Tuteur  t = tuteur.get(i);
			l1.add(t.initiale());
		}
		return l1;
	}
	
	public static ArrayList<String> tutoreMatriceAdj(ArrayList<Candidat> tutore ) {
		ArrayList<String> l1 = new ArrayList<String>();
		for(int i = 0 ; i < tutore.size(); i++){
			l1.add(tutore.get(i).initiale());
		}
		return l1;
	}

    @FXML
    private Button add_aff;
    @FXML
    private Button valider;
    @FXML
    private Button auto_aff;

    @FXML
    private Button bsupp_couple;

    @FXML
    private Button bsupp_tutore;

    @FXML
    private Label info_tutore;

    @FXML
    private Label infos_tuteur;

    @FXML
    private ListView<String> l_tuteur;

    @FXML
    private ListView<String> l_tutore;

    @FXML
    private ComboBox<String> matiere;

    @FXML
    private RadioButton pond_2a;

    @FXML
    private RadioButton pond_3a;
    
    ArrayList<GroupeTutore> gt1 ;
	ArrayList<GroupeTutore> gt2 ;
	ArrayList<GroupeTutore> gt3;
	ArrayList<GroupeTutore> gt4 ;
	ArrayList<GroupeTutore> gt5 ;
	ArrayList<GroupeTutore> gt6 ;
	ArrayList<GroupeTutore> gt7;
    private int cpt;
    void addListe(ArrayList<GroupeTutore> g) {
    	cpt=0;
    	ArrayList<String> doublon = new ArrayList<String>();
    	for (GroupeTutore gr : g) {
    		if (!doublon.contains(gr.getEleve().toString()) && !doublon.contains(gr.getTuteur().toString())){
    		l_tutore.getItems().add(cpt, gr.getEleve().toString());
    		l_tuteur.getItems().add(cpt, gr.getTuteur().toString());
    		cpt++;
    		doublon.add( gr.getEleve().toString());
    		doublon.add( gr.getTuteur().toString());}
    	}
    }
    
    void affectation(Vivier vivier) {
    	GrapheNonOrienteValue<String> g1 = new GrapheNonOrienteValue();
		GrapheNonOrienteValue<String> g2 = new GrapheNonOrienteValue(); 
		GrapheNonOrienteValue<String> g3 = new GrapheNonOrienteValue(); 
		GrapheNonOrienteValue<String> g4 = new GrapheNonOrienteValue(); 
		GrapheNonOrienteValue<String> g5 = new GrapheNonOrienteValue(); 
		GrapheNonOrienteValue<String> g6 = new GrapheNonOrienteValue(); 
		GrapheNonOrienteValue<String> g7 = new GrapheNonOrienteValue(); 
		//Les futurs abscisses et ordonnÃ©es de notre matrice d'adjacence
		//On remplit nos liste
		// tri par ordre croissant
		ArrayList<String> lTPOO = tuteurMatriceAdj(vivier.getTuteursPOO());
		ArrayList<String> lCPOO = tutoreMatriceAdj(vivier.getCandidatsPOO());
		ArrayList<String> lTIHM = tuteurMatriceAdj(vivier.getTuteursIHM());
		ArrayList<String> lCIHM = tutoreMatriceAdj(vivier.getCandidatsIHM());
		ArrayList<String> lTBDD = tuteurMatriceAdj(vivier.getTuteursBDD());
		ArrayList<String> lCBDD = tutoreMatriceAdj(vivier.getCandidatsBDD());
		ArrayList<String> lTGRAPHES = tuteurMatriceAdj(vivier.getTuteursGRAPHES());
		ArrayList<String> lCGRAPHES = tutoreMatriceAdj(vivier.getCandidatsGRAPHES());
		ArrayList<String> lTWEB = tuteurMatriceAdj(vivier.getTuteursWEB());
		ArrayList<String> lCWEB = tutoreMatriceAdj(vivier.getCandidatsWEB());
		ArrayList<String> lTBASNIVEAU = tuteurMatriceAdj(vivier.getTuteursBAS_NIVEAU());
		ArrayList<String> lCBASNIVEAU = tutoreMatriceAdj(vivier.getCandidatsBAS_NIVEAU());
		ArrayList<String> lTSYSTEME = tuteurMatriceAdj(vivier.getTuteursSYSTEME());
		ArrayList<String> lCSYSTEME = tutoreMatriceAdj(vivier.getCandidatsSYSTEME());
		//Ici, Ã  l'aide d'un double for, nous affectons les poids sur chaques arÃªtes grÃ¢ce Ã  notre fonction, pour ensuite faire une affectation de coÃ»t minimale
		AddSommetAffectation(g1,vivier.getTuteursPOO(),vivier.getCandidatsPOO());
		AddSommetAffectation(g3,vivier.getTuteursBDD(),vivier.getCandidatsBDD());
		AddSommetAffectation(g4,vivier.getTuteursGRAPHES(),vivier.getCandidatsGRAPHES());
		AddSommetAffectation(g5,vivier.getTuteursWEB(),vivier.getCandidatsWEB());
		AddSommetAffectation(g2,vivier.getTuteursIHM(),vivier.getCandidatsIHM());
		AddSommetAffectation(g6,vivier.getTuteursBAS_NIVEAU(),vivier.getCandidatsBAS_NIVEAU());
		AddSommetAffectation(g7,vivier.getTuteursSYSTEME(),vivier.getCandidatsSYSTEME());
		CalculAffectation caPOO = new CalculAffectation(g1, lTPOO, lCPOO);
		CalculAffectation caIHM = new CalculAffectation(g2, lTIHM, lCIHM);
		CalculAffectation caBDD = new CalculAffectation(g3,lTBDD, lCBDD);
		CalculAffectation caGRAPHES = new CalculAffectation(g4, lTGRAPHES, lCGRAPHES);
		CalculAffectation caWEB = new CalculAffectation(g5, lTWEB, lCWEB);
		CalculAffectation caBASNIVEAU = new CalculAffectation(g6,lTBASNIVEAU, lCBASNIVEAU);
		CalculAffectation caSYSTEME = new CalculAffectation(g7, lTSYSTEME, lCSYSTEME);
		List<Arete> resPOO = caPOO.getAffectation();
		List<Arete> resIHM = caIHM.getAffectation();
		List<Arete> resBDD = caBDD.getAffectation();
		List<Arete> resGRAPHES = caGRAPHES.getAffectation();
		List<Arete> resWEB = caWEB.getAffectation();
		List<Arete> resBASNIVEAU = caBASNIVEAU.getAffectation();
		List<Arete> resSYSTEME = caSYSTEME.getAffectation();
		 gt1 = ExportGroupeTutoreMatiere(resWEB,vivier.getTuteursWEB(),vivier.getCandidatsWEB());
		 gt2 =ExportGroupeTutoreMatiere(resPOO,vivier.getTuteursPOO(),vivier.getCandidatsPOO());
		 gt3 =ExportGroupeTutoreMatiere(resIHM,vivier.getTuteursIHM(),vivier.getCandidatsIHM());
		 gt4 =ExportGroupeTutoreMatiere(resBDD,vivier.getTuteursBDD(),vivier.getCandidatsBDD());
		 gt5 =ExportGroupeTutoreMatiere(resGRAPHES,vivier.getTuteursGRAPHES(),vivier.getCandidatsGRAPHES());
		 gt6 =ExportGroupeTutoreMatiere(resBASNIVEAU,vivier.getTuteursBAS_NIVEAU(),vivier.getCandidatsBAS_NIVEAU());
		 gt7 =ExportGroupeTutoreMatiere(resSYSTEME,vivier.getTuteursSYSTEME(),vivier.getCandidatsSYSTEME());
		addListe(gt1);
		addListe(gt2);
		addListe(gt3);
		addListe(gt4);
		addListe(gt5);
		addListe(gt6);
		addListe(gt7);
    }
    private Vivier vivier;
    
    boolean deja_fait=false;
    
    
    @FXML
     
     void remplir(ActionEvent event) {
    	if (deja_fait) {
    		cpt=0;
    		l_tuteur.getItems().removeAll();
    		l_tutore.getItems().removeAll();
    		l_tuteur.getItems().clear();
    		l_tutore.getItems().clear();
    	}
    	vivier=new Vivier();
    	vivier.remplirTuteurCandidat();
    	vivier.remplirTuteurCandidatParMatiere();
    	affectation(vivier);
		deja_fait=true;
    }
    
    
    public void initialize() {
    	matiere.setItems(FXCollections.observableArrayList("POO","IHM","BDD","GRAPHES","WEB","BAS_NIVEAU","SYSTEME"));
    	l_tutore.getSelectionModel().getSelectedItems().addListener( new TutoreInfoListener() );
    	l_tuteur.getSelectionModel().getSelectedItems().addListener(new	 TuteurInfoListener());
    }
    
    
    public void affParMatiere() {
    	vivier = new Vivier();
    	vivier.remplirTuteurCandidat();
    	vivier.remplirTuteurCandidatParMatiere();
    	affectation(vivier);
    	l_tuteur.getItems().removeAll();
		l_tutore.getItems().removeAll();
		l_tuteur.getItems().clear();
		l_tutore.getItems().clear();
		
		if (!matiere.getValue().equals(null) && matiere.getValue().equals("POO")) {
			addListe(gt2);
		}
		else if (matiere.getValue().equals("IHM")) {
			addListe(gt3);
		}
		else if (matiere.getValue().equals("BDD")) {
			addListe(gt4);
		}
		else if (matiere.getValue().equals("WEB")) {
			addListe(gt1);
		}
		else if (matiere.getValue().equals("GRAPHES")) {
			addListe(gt5);
		}
		else if (matiere.getValue().equals("BAS_NIVEAU")) {
			addListe(gt6);
		}
		else if (matiere.getValue().equals("SYSTEME")) {
			addListe(gt7);
		}
		
    }

}

