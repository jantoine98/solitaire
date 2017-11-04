package solitaire;

import java.util.ArrayList;

public class Pile 
{
	private String symbole;
	private ArrayList<Carte> cartes;
	
	//constructeur
	public Pile(String symbole, ArrayList<Carte> cartes) {
		this.symbole = symbole;
		this.cartes = new ArrayList<Carte>();
	}

	public String getSymbole() {
		return symbole;
	}

	public void setSymbole(String symbole) {
		this.symbole = symbole;
	}

	public ArrayList<Carte> getCartes() {
		return cartes;
	}

	public void setCartes(ArrayList<Carte> cartes) {
		this.cartes = cartes;
	}
	
	

}
