package IHM;

import AffectationBinomes.Vivier;
import ModelisationEtudiants.Tuteur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class Controller {
	@FXML private ListView<Tuteur> l_tuteur;
	@FXML private Button auto_aff;
	@FXML private Label infos_tuteur;
	
	
	
	
	
	private Vivier vivier = new Vivier();
	public void remplir(ActionEvent event) {
		vivier.remplirTuteurCandidat();
		ObservableList<Tuteur> tuteur= FXCollections.observableArrayList(vivier.getTuteurs());
		l_tuteur=new ListView<Tuteur>(tuteur);
		l_tuteur.getFocusModel().focus(1);
		l_tuteur.setItems(tuteur);
		System.out.println(l_tuteur.getItems().get(0));
		
	 
		
		
	}
}
