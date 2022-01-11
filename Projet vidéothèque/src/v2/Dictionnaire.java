package v2;

import java.util.ArrayList;

public class Dictionnaire extends Document{
	String langue;
	private ArrayList<Dictionnaire> listeDictionnaire;
	

	public Dictionnaire(String identifiant, String titre, double tarifJournalier, String langue) {
		super(identifiant, titre, tarifJournalier);
		this.langue = langue;
	}

	public String getLangue() {
		return langue;
	}

	public void setLangue(String langue) {
		this.langue = langue;
	}

	@Override
	public String toString() {
		return "Dictionnaire [langue=" + langue + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dictionnaire other = (Dictionnaire) obj;
		if (langue == null) {
			if (other.langue != null)
				return false;
		} else if (!langue.equals(other.langue))
			return false;
		return true;
	}
	
	public void AjouterDictionnaire(Dictionnaire dico) 
	{
		listeDictionnaire.add(dico);
	}
	public void SupprimerDictionnaire(Dictionnaire dico) 
	{
		listeDictionnaire.remove(dico);
	}
	
	
	
	

}
