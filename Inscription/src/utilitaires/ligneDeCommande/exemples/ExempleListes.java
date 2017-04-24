package utilitaires.ligneDeCommande.exemples;

import java.util.ArrayList;
import java.util.List;
import utilitaires.ActionListe;
import utilitaires.Liste;
import utilitaires.Liste.ToString;

public class ExempleListes
{
	public static void main(String[] args)
	{
		// Cr�ation d'une liste contenant les trois cha�nes "Ginette", "Marcel" et "Gis�le"
		final ArrayList<String> personnes = new ArrayList<>();
		personnes.add("Ginette");
		personnes.add("Marcel");
		personnes.add("Gis�le");
		// Cr�ation d'un menu proposant une option par personne
		Liste<String> menu = new Liste<String>("Liste des Personnes", 
				new ActionListe<String>()
		{
			// Retourne la liste des personnes formant le menu
			public List<String> getListe()
			{
				return personnes;
			}

			// Ex�cut�e automatiquement lorsqu'un �l�ment de liste est s�lectionn�
			public void elementSelectionne(int indice, String element)
			{
				System.out.println("Vous avez s�lectionn� "+ element+ ", qui a l'indice " + indice);
			}
		});
		// Ajoute une option quitter � la fin de la liste
		menu.ajouteQuitter("q");
		// Lancement du menu
		menu.start();
	}
}
