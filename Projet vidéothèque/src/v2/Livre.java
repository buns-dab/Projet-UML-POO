package v2;

public abstract class Livre extends Produit{
	
	private String auteur;

	public Livre(String identifiant, String titre, double tarifJournalier, String auteur) 
	{
		super(identifiant, titre, tarifJournalier);
		this.auteur = auteur;
	}

	public String getAuteur() 
	{
		return auteur;
	}

	public void setAuteur(String auteur)
	{
		this.auteur = auteur;
	}

	@Override
	public String toString() 
	{
		return "Livre ["+super.toString()+" auteur = " + auteur + "]";
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
		Livre other = (Livre) obj;
		if (auteur == null) {
			if (other.auteur != null)
				return false;
		} else if (!auteur.equals(other.auteur))
			return false;
		return true;
	}

}
