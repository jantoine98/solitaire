package solitaire;

import java.util.ArrayList;

public class MainTest {

	public static void main(String[] args) 
	{
		Jeu jeu = new Jeu();
		jeu.creerCartes();
		
		//System.out.println(jeu.afficherCartes());
		//System.out.println("Nombre de cartes : " + jeu.getCartesRestantes().size());
		
		// Création des colonnes
		ArrayList<Colonne> colonnes = new ArrayList<Colonne>();
		
		for(int i = 1; i < 8; i++)
		{
			Colonne colonne = new Colonne(i, i);
			ArrayList<Carte> listeCartesAleatoires = jeu.recupererPlusieursCartes(i);
			colonne.setListeCartes(listeCartesAleatoires);
			colonnes.add(colonne);
		}
		
		//affichage de colonnes
		for(int i = 0; i < 7; i++)
		{
			System.out.println("colonne n° " + colonnes.get(i).getNumeroOrdre());
			//affichage de chaque carte d'une colonne
			System.out.println(colonnes.get(i).afficherColonne());
			System.out.println("/*****************************/");
		}
		
	}
}
