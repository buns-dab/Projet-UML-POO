package v2;

import java.util.ArrayList;

public class DVD extends SupportNumerique{
	
	private String realisateur;
	private ArrayList<DVD> listeDVD;

	public DVD(String identifiant, String titre, double tarifJournalier, String realisateur)
	{
		super(identifiant, titre, tarifJournalier);
		this.realisateur = realisateur;
	}

	public String getRealisateur() 
	{
		return realisateur;
	}

	public void setRealisateur(String realisateur)
	{
		this.realisateur = realisateur;
	}
	
	@Override
	public String toString() 
	{
		return "Dvd ["+super.toString()+" realisateur = " + realisateur + "]";

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		DVD other = (DVD) obj;
		if (realisateur == null) {
			if (other.realisateur != null)
				return false;
		} else if (!realisateur.equals(other.realisateur))
			return false;
		return true;
	}
	
	public void AjouterDVD(DVD dvd) 
	{
		listeDVD.add(dvd);
	}
	public void SupprimerClient(DVD dvd) 
	{
		listeDVD.remove(dvd);
	}

}
