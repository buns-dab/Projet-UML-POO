package v2;

import java.util.ArrayList;
import java.util.Iterator;

public class Roman extends Livre{
		private ArrayList<Roman> listeRoman;

		public Roman(String identifiant, String titre, double tarifJournalier, String auteur)
		{
			super(identifiant, titre, tarifJournalier, auteur);
		}
		
		public void AjouterRoman(Roman rmn) 
		{
			listeRoman.add(rmn);
		}
		public void SupprimerRoman(Roman rmn) 
		{
			listeRoman.remove(rmn);
		}

}
