package utilitaires.ligneDeCommande.exemples;

import utilitaires.Action;
import utilitaires.Menu;
import utilitaires.Option;

class Bonjour
{
	public static void main(String[] args)
	{
		// Cr�ation d'un menu dont le titre est "Menu Bonjour"
		Menu menu = new Menu("Menu bonjour");
		// Cr�ation d'une option de menu dont le titre est "Dire bonjour"
		// et dont le raccourci clavier est "b"
		Option direBonjour = new Option("Dire Bonjour", "b");
		// Ajout de l'option au menu
		menu.ajoute(direBonjour);
		// Ajout d'une option permettant de quitter l'application
		menu.ajouteQuitter("q");
		// Sp�cifation de l'action � effectuer lorsqu'une option est s�lection�e
		Action action = new Action()
		{
			// M�thode appel�e automatiquement lorsqu'une option 
			// est s�lectionn�e
			@Override
			public void optionSelectionnee()
			{
				System.out.println("Bonjour !");
			}
		};
		// Affectation d'une action � l'option direBonjour
		direBonjour.setAction(action);
		// Lancement du menu
		menu.start();
	}
}

