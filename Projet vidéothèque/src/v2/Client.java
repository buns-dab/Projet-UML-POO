package v2;

import java.util.ArrayList;
import java.awt.BorderLayout;import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class Client {
	
	private String identifiant;
	private String nom;
	private String prenom;
	private boolean fidelite;
	
	
	
	
	public Client(String identifiant, String nom, String prenom, boolean fidelite) 
	{
		super();
		this.identifiant = identifiant;
		this.nom = nom;
		this.prenom = prenom;
		this.fidelite = fidelite;
	}
	
	public String getIdentifiant()
	{
		return identifiant;
	}
	public void setIdentifiant(String identifiant)
	{
		this.identifiant = identifiant;
	}
	public String getNom()
	{
		return nom;
	}
	public void setNom(String nom)
	{
		this.nom = nom;
		
	}
	public String getPrenom() 
	{
		return prenom;
	}
	public void setPrenom(String prenom)
	{
		this.prenom = prenom;
	}
	public boolean getFidelite()
	{
		return fidelite;
	}
	public void setFidelite(boolean fidelite) 
	{
		this.fidelite = fidelite;
	}
	@Override
	public String toString() 
	{
		return "Client [identifiant = " + identifiant + ", nom = " + nom + ", prenom = " + prenom + ", fidelite = " + fidelite + "]";
	}




	




	
	
	
	

			
		
}
