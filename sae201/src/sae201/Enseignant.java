package sae201;

public class Enseignant {
    //attributes
    private String name; 
    private String prenom;
    private String matiere;
    //constructor
    public Enseignant(String name, String prenom, String matiere){
        this.name = name;
        this.prenom = prenom;
        this.matiere = matiere;
    }
    //methods
    String getName(){
        return this.name;
    }
    String getPrenom(){
        return this.prenom;
    }
    String getMatiere(){
        return this.matiere;
    }
    public static void main(String[] args){
        //Enseignant enseignant = new Enseignant();
        //String res = enseignant.name+" "+enseignant.prenom+ " : "+enseignant.matiere;
        //System.out.println(res);
    }
}