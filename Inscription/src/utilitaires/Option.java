package utilitaires;

/**
 * Option figurant dans un menu.
 */

public class Option
{
	protected String raccourci;
	private String titre;
	protected Action action;

	public Option(String titre, String raccourci, Action action)
	{
		this.titre = titre;
		this.raccourci = raccourci;
		this.action = action;
	}
	
	/**
	 * Cr��e une option.
	 * @param titre titre de l'option.
	 * @param raccourci raccourci � saisir pour activer l'option.
	 */
	
	public Option(String titre, String raccourci)
	{
		this.titre = titre;
		this.raccourci = raccourci;
	}
	
	/**
	 * Retourne le raccourci permettant de s�lectioner cette option.
	 */
	
	public String getRaccourci()
	{
		return raccourci;
	}

	/**
	 * Retourne le libell� de l'option.
	 */
	
	public String getTitre()
	{
		return titre;
	}

	/**
	 * Affecte une action � la s�lection de l'option.
	 * @param action l'objet dont la m�thode optionSelectionnee() sera 
	 * appel� une fois une option choisie.
	 */
	
	public void setAction(Action action)
	{
		this.action = action;
	}
	
	/**
	 * Retourne l'action associ� � la s�lection de l'option.
	 * @return l'objet dont la m�thode optionSelectionnee() sera 
	 * appel� une fois une option choisie.
	 */
	
	public Action getAction()
	{
		return action;
	}
	
	void optionSelectionnee()
	{
		if (action != null)
			action.optionSelectionnee();
	}
	
	public String stringOfOption()
	{
		return raccourci + " : " + titre;
	}
}