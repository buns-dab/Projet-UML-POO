package v2;
import java.util.ArrayList;
import java.util.Iterator;

public class BD extends Livre{
	private ArrayList<BD> listeBD;

	public BD(String identifiant, String titre, double tarifJournalier, String auteur)
	{
		super(identifiant, titre, tarifJournalier, auteur);
	}

	public void AjouterBD(BD bd) 
	{
		listeBD.add(bd);
	}
	public void SupprimerClient(BD bd) 
	{
		listeBD.remove(bd);
	}
}
