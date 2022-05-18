package sae201;

public class Tuteur extends Etudiant{
	

	public Tuteur(String nom, String prenom,double moyenne, int annee) {
		super(nom, prenom, annee, moyenne);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
<<<<<<< HEAD
		return "Tuteur ["+super.toString().substring(10);
=======
		return "Tuteur ["+super.toString().substring(10)+getId();
>>>>>>> a84992042fc6d54eb4c24cdba0b7beebf3ebf2eb
	}
}
<<<<<<< HEAD

=======
	
>>>>>>> a84992042fc6d54eb4c24cdba0b7beebf3ebf2eb
	
	
	
	

