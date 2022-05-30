

/**
 * @author daniel.fanion.etu
 *
 */
public class GroupeTutore {
	private int id ; 
	private static int cpt = 0;
	private Tuteur tuteur;
	private Candidat eleve;
	
	public GroupeTutore(Tuteur tuteur, Candidat eleve) {
		this.id = cpt;
		this.tuteur = tuteur;
		this.eleve = eleve;
		cpt+=1;
		
	}
	
	@Override
	public String toString() {
		return "Le groupe : " +id + ", tuteur= " + tuteur + ", eleve= " + eleve;
	}

	public GroupeTutore() {
		this.id=cpt;
		cpt+=1;
	}

	public Tuteur getTuteur() {
		return tuteur;
	}

	public void setTuteur(Tuteur tuteur) {
		this.tuteur = tuteur;
	}

	public Candidat getEleve() {
		return eleve;
	}

	public void setEleve(Candidat eleve) {
		this.eleve = eleve;
	}

	public int getId() {
		return id;
	}
	
	
	
	
	
	
	
	
	
}
