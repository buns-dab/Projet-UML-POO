package v2;

import java.sql.Date;
import java.util.ArrayList;

public class Commande 
{
	String identifiant;
	Date dateDeCreation;
	double reduction;
	private ArrayList<Commande> listeCmd;
	
	public Commande(String identifiant, Date dateDeCreation, double reduction) {
		super();
		this.identifiant = identifiant;
		this.dateDeCreation = dateDeCreation;
		this.reduction = reduction;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public Date getDateDeCreation() {
		return dateDeCreation;
	}

	public void setDateDeCreation(Date dateDeCreation) {
		this.dateDeCreation = dateDeCreation;
	}

	public double getReduction() {
		return reduction;
	}

	public void setReduction(double reduction) {
		this.reduction = reduction;
	}

	@Override
	public String toString() {
		return "Commande [identifiant=" + identifiant + ", dateDeCreation=" + dateDeCreation + ", reduction="
				+ reduction + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Commande other = (Commande) obj;
		if (dateDeCreation == null) {
			if (other.dateDeCreation != null)
				return false;
		} else if (!dateDeCreation.equals(other.dateDeCreation))
			return false;
		if (identifiant == null) {
			if (other.identifiant != null)
				return false;
		} else if (!identifiant.equals(other.identifiant))
			return false;
		if (Double.doubleToLongBits(reduction) != Double.doubleToLongBits(other.reduction))
			return false;
		return true;
	}
	
	public void AjouterCommande(Commande cmd) 
	{
		listeCmd.add(cmd);
	}
	public void SupprimerCommande(Commande cmd) 
	{
		listeCmd.remove(cmd);
	}
	
	
	
	
}
