package utilitaires.ligneDeCommande.exemples;

import utilitaires.Action;
import utilitaires.Menu;
import utilitaires.Option;

class ExempleMenus
{
	public static void main(String[] args)
	{
		// Cr�ation du menu racine de l'application.
		Menu menuPrincipal = new Menu("Menu Principal");
		// Cr�ation de deux options
		Option calculatrice = new Option("Calculatrice", "c");
		Menu direBonjour = new Menu("Menu bonjour", "Bonjour", "b");
		// Imbrication des deux options dans le menu
		menuPrincipal.ajoute(calculatrice);
		// Vous remarquez que comme Menu h�rite de Option, on peut mettre un menu dans un menu
		menuPrincipal.ajoute(direBonjour);
		menuPrincipal.ajouteQuitter("q");
		// D�finition de l'action pour la calculatrice
		calculatrice.setAction(new Action()
		{
			// M�thode ex�cut�e lorsque l'option calculatrice est s�lectionn�e.
			public void optionSelectionnee()
			{
				int a = utilitaires.EntreesSorties.getInt("Saisissez la premi�re op�rande : "),
						b = utilitaires.EntreesSorties.getInt("Saisissez la deuxi�me op�rande : ");
				System.out.println("" + a + " + " + b + " = " + (a+b));
			}
		});
		// Il est possible de passer l'action en param�tre directement dans le constructeur.
		direBonjour.ajoute(new Option("Dire bonjour", "b", new Action()
		{
			public void optionSelectionnee()
			{
				System.out.println("Bonjour !");
			}
		}));
		// Ajout d'une option permettant de revenir au menu parent
		direBonjour.ajouteRevenir("r");;
		// Retour automatique au menu parent si une option est ex�cut�e.
		direBonjour.setRetourAuto(true);
		// Lancement du menu
		menuPrincipal.start();
	}
}