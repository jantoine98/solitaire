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
		
		//Création de piles
		ArrayList<Pile> piles = new ArrayList<Pile>();
		
		for(int i = 0; i < 4; i++)
		{
			piles.add(new Pile(ReferentielCarte.getSymbolescartes()[i]));
		}
		
		//on parcourt les colonnes
		for(int i = 0; i < 7; i++)
		{
			Colonne colonne = colonnes.get(i);
			ArrayList<Carte> cartesVisibles = colonne.getCartesVisible();
			
			for(int j = 0; j < cartesVisibles.size(); j++)
			{
				Carte carte = cartesVisibles.get(j);
				int numPile = ReferentielCarte.getIndexInSymbolesCartes(carte.getSymbole());
				Pile pile = piles.get(0);
				//si la pile du symbole est vide, et que la carte est un As
				//Donc on peut déplacer la carte de la colonne vers la pile
				if(pile.getCartes().size() == 0 && carte.getSymbole() == "As")
				{
					//On ajoute la carte à la pile
					pile.getCartes().add(carte);
					//il faut la retirer ensuite de la colonne
					colonne.getCartesVisible().remove(carte);
					//il faut mettre la première carte de la colonne en visible, si elle n'est pas vide
					if(colonne.getCartesVisible().size() > 0)
					{
						colonne.getCartesVisible().get(0).setVisible(true);
					}
				}
			}
		}
		
		for(int i = 0; i < 4; i++)
		{
			System.out.println(piles.get(i).afficherCartes());
		}
		
	}
}
