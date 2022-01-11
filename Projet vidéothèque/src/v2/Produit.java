package v2;

import java.util.ArrayList;

public abstract class Produit {
	
	String identifiant;
	String titre;
	double TarifJournalier;
	
	public Produit(String identifiant, String titre, double tarifJournalier) 
	{
		super();
		this.identifiant = identifiant;
		this.titre = titre;
		TarifJournalier = tarifJournalier;
	}

	public String getIdentifiant() 
	{
		return identifiant;
	}

	public void setIdentifiant(String identifiant) 
	{
		this.identifiant = identifiant;
	}

	public String getTitre() 
	{
		return titre;
	}

	public void setTitre(String titre) 
	{
		this.titre = titre;
	}

	public double getTarifJournalier()
	{
		return TarifJournalier;
	}

	public void setTarifJournalier(double tarifJournalier) 
	{
		TarifJournalier = tarifJournalier;
	}

	@Override
	public String toString() 
	{
		return "Produit [identifiant = " + identifiant + ", titre = " + titre + ", TarifJournalier = " + TarifJournalier + "]";
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produit other = (Produit) obj;
		if (Double.doubleToLongBits(TarifJournalier) != Double.doubleToLongBits(other.TarifJournalier))
			return false;
		if (identifiant == null) {
			if (other.identifiant != null)
				return false;
		} else if (!identifiant.equals(other.identifiant))
			return false;
		if (titre == null) {
			if (other.titre != null)
				return false;
		} else if (!titre.equals(other.titre))
			return false;
		return true;
	}

}
