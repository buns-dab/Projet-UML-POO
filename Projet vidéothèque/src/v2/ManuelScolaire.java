package v2;

import java.util.ArrayList;

public class ManuelScolaire extends Livre{
	
	private ArrayList<ManuelScolaire> listeManuelSco;

	public ManuelScolaire(String identifiant, String titre, double tarifJournalier, String auteur)
	{
		super(identifiant, titre, tarifJournalier, auteur);
	}
	
	public void AjouterClient(ManuelScolaire manSco) 
	{
		listeManuelSco.add(manSco);
	}
	public void SupprimerClient(ManuelScolaire manSco) 
	{
		listeManuelSco.remove(manSco);
	}

}
