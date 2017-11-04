package solitaire;

import java.util.ArrayList;

/**
 * @author Antoine
 *
 */
public class Colonne 
{
	private int numeroOrdre;
	private int nbCartes;
	private ArrayList<Carte> listeCartes;
	
	// Constructeur
	public Colonne(int numeroOrdre, int nbCartes) {
		this.numeroOrdre = numeroOrdre;
		this.nbCartes = nbCartes;
		this.listeCartes = new ArrayList<Carte>();
	}

	public int getNumeroOrdre() {
		return numeroOrdre;
	}

	public void setNumeroOrdre(int numeroOrdre) {
		this.numeroOrdre = numeroOrdre;
	}

	public int getNbCartes() {
		return nbCartes;
	}

	public void setNbCartes(int nbCartes) {
		this.nbCartes = nbCartes;
	}

	public ArrayList<Carte> getListeCartes() {
		return listeCartes;
	}

	public void setListeCartes(ArrayList<Carte> listeCartes) {
		this.listeCartes = listeCartes;
	}
	
	// Cette fonction affiche les cartes d'une colonne
	public String afficherColonne() 
	{
		String colonne = "";
		for (int i = 0; i < this.nbCartes; i++)
		{
			colonne += this.listeCartes.get(i).toString() + "\n";
		}
		return colonne;
	}
	
}
