package v2;

import java.util.ArrayList;

public class CD extends SupportNumerique{
	private int anneeSortie;
	private ArrayList<CD> listeCD;

	public CD(String identifiant, String titre, double tarifJournalier, int anneeSortie)
	{
		super(identifiant, titre, tarifJournalier);
		this.anneeSortie = anneeSortie;
	}

	public int getAnneeSortie() 
	{
		return anneeSortie;
	}

	public void setAnneeSortie(int anneeSortie) 
	{
		this.anneeSortie = anneeSortie;
	}
	
	

	@Override
	public String toString() 
	{
		return "Cd ["+super.toString()+" anneeSortie = " + anneeSortie + "]";
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CD other = (CD) obj;
		if (anneeSortie != other.anneeSortie)
			return false;
		return true;
	}
	
	public void AjouterCD(CD cd) 
	{
		listeCD.add(cd);
	}
	public void SupprimerCD(CD cd) 
	{
		listeCD.remove(cd);
	}

}
