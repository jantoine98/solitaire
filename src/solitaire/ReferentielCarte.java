package solitaire;

/**
 * Cette classe sert à définir les symoles et les valeurs possibles des cartes
 * @author Antoine
 *
 */
public class ReferentielCarte 
{
	private static final String[] symbolesCartes = {"pique","coeur","carreau","trefle"};
	private static final String[] valeursCartes = {"As","2","3","4","5","6","7","8","9","10","V","D","R"};
	
	
	public static String[] getSymbolescartes() {
		return symbolesCartes;
	}

	public static String[] getValeurscartes() {
		return valeursCartes;
	}
	
	
}
