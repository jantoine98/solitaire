package solitaire;

import java.util.ArrayList;
import java.util.Random;


/**
 * @author Antoine
 *
 */
public class Jeu 
{
	private final int nbCartes = 52; // toute partie solitaire est composée de 52 cartes : constante
	private ArrayList<Carte> cartesRestantes;
	private ArrayList<Colonne> colonnes;
	private ArrayList<Pile> piles;
	
	//Constructeur
	public Jeu() {
		this.cartesRestantes = new ArrayList<Carte>();
		this.colonnes = new ArrayList<Colonne>();
		this.piles = new ArrayList<Pile>();
	}

	public ArrayList<Carte> getCartesRestantes() {
		return cartesRestantes;
	}

	public void setCartesRestantes(ArrayList<Carte> cartesRestantes) {
		this.cartesRestantes = cartesRestantes;
	}

	public int getNbCartes() {
		return nbCartes;
	}
	
	public ArrayList<Colonne> getColonnes() {
		return colonnes;
	}

	public void setColonnes(ArrayList<Colonne> colonnes) {
		this.colonnes = colonnes;
	}

	public ArrayList<Pile> getPiles() {
		return piles;
	}

	public void setPiles(ArrayList<Pile> piles) {
		this.piles = piles;
	}
	
	public void initialiser() 
	{
		// On parcourt les valeurs qui sont dans ReferentielCarte
		for(int i = 0; i < 13; i++)
		{
			// On parcourt les symboles qui sont dans ReferentielCarte
			for(int j = 0; j < 4; j++)
			{
				String symbole = ReferentielCarte.getSymbolescartes()[j];
				String valeur = ReferentielCarte.getValeurscartes()[i];
				this.cartesRestantes.add(new Carte(symbole, valeur , false));
			}
		}
		
		// Création des colonnes
		for(int i = 1; i < 8; i++)
		{
			Colonne colonne = new Colonne(i, i);
			ArrayList<Carte> listeCartesAleatoires = this.recupererPlusieursCartes(i);
			colonne.setListeCartes(listeCartesAleatoires);
			this.colonnes.add(colonne);
		}
		
		//Création de piles
		for(int i = 0; i < 4; i++)
		{
			piles.add(new Pile(ReferentielCarte.getSymbolescartes()[i]));
		}
		
	}
	
	/**
	 * Cette fonction récupère une carte aléatoire 
	 * @return Carte
	 */
	public Carte recupererCarteAleatoire()
	{
		Random random = new Random	();
		// Récupérer un nombre aléatoire entre 0 et le nombre de carte restantes
		int nbCartesRestantes = this.cartesRestantes.size();
		int  nombreAleatoire = random.nextInt(nbCartesRestantes - 1) + 1;
		
		Carte carteAleatoire = this.cartesRestantes.get(nombreAleatoire);
		
		//Une fois la carte est récupérée, on la retire de la liste
		this.cartesRestantes.remove(nombreAleatoire);
		
		return carteAleatoire;
	}
	
	/**
	 * Cette fonction récupère plusieurs cartes aléatoires et retourne une liste
	 * @param nbCartesARecuperer
	 * @return cartes
	 */
	public ArrayList<Carte> recupererPlusieursCartes(int nbCartesARecuperer) 
	{
		ArrayList<Carte> cartes = new ArrayList<Carte>();
		
		for(int i = 0; i < nbCartesARecuperer; i++)
		{
			Carte carteAleatoire = this.recupererCarteAleatoire();
			cartes.add(carteAleatoire);
		}
		
		//on rend visible la première carte de chaque colonne
		cartes.get(0).setVisible(true);
		return cartes;
	}
	
	//Cette fonction affiche les cartes d'un jeu
	public String afficherCartes() 
	{
		String cartes = "";
		for (int i = 0; i < this.cartesRestantes.size(); i++)
		{
			cartes += this.cartesRestantes.get(i).toString() + "\n";
		}
		return cartes;
	}
	
	public String afficherPiles()
	{
		String piles = "";
		for(int i = 0; i < 4; i++)
		{
			piles += "Pile : " + this.piles.get(i).getSymbole() + "\n";
			piles += this.piles.get(i).afficherCartes()+ "\n";
		}
		return piles;
	}
	
	public boolean isColonnesEmpty()
	{
		for(int i = 0; i < 7; i++)
		{
			if(!this.colonnes.get(i).getCartesVisible().isEmpty())
			{
				return false;
			}
		}
		return true;
	}
		

}
