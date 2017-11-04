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
	
	//Cette fonction retourne l'indice d'un symbole dans le tableau symbolesCartes
	public static int getIndexInSymbolesCartes (String symbole) 
	{
		for(int i = 0; i < 4; i++)
		{
			if(ReferentielCarte.symbolesCartes[i] == symbole)
			{
				return i;
			}
		}
		
		return -1;
	}
	
	//Cette fonction retourne l'indice d'une valeur dans le tableau valeursCartes
		public static int getIndexInValeursCartes (String valeur) 
		{
			for(int i = 0; i < 13; i++)
			{
				if(ReferentielCarte.valeursCartes[i] == valeur)
				{
					return i;
				}
			}
			
			return -1;
		}
}
