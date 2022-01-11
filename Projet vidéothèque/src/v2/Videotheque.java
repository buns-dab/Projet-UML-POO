package v2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.*;
//import javax.swing.ImageIcon;      en cas d'importation d'image 


public class Videotheque {
	
	protected static final AbstractButton tfRealisateurAjout = null;
	private static JFrame fenetre;
	public int idcl=0;
	public int numemp=0;
	public int idprod=0;
	public int idemp=0;
	public int numEmpreunt=0;
	public Object [][] listClient = new Object[1000][4] ;
	public Object [][] listProduit = new Object[1000][9] ;
	public Object [][] listEmprunt = new Object[500][5] ;
	public Object [][] listEmpruntEC = new Object[500][6];
	public Object [][] listEmpruntTout = new Object[1000][6];
	public int trfObjEmp=0;
	public int idclemp;
	public int idProdEmp=0;
	/*Declaration de variable de fenetre*/
	public JMenu menuClient,menuQuitter,menuAcceuil, menuCommande,menuEmprunt,menuProduit,menuDeco;
	public JMenuItem cl1, cl2,art1,art2,mq,acc,em1,em2,em3,em4,prd1,prd2,md;
	public JPanel pnlAcceuil,pnlClient,pnlListClient,pnlBas,pnlLogin,pnlListProduit, pnlListEmpruntEC,pnlRetourEmprunt;
	public JMenuBar mb = new JMenuBar();
	public String IdentLog = "";
	public String IdentMdp = "";


	/*Constructeur*/
	public Videotheque(){
		fenetre = new JFrame("Gestion de videotheque");
		fenetre.setSize(850,550);
		fenetre.setLocation (100,100);
		fenetre.setResizable(false);  /*a voir pour une minimum size*/
		fenetre.setLayout(new BorderLayout());
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		
		
		
		
			/*Menu acceuil*/
		menuAcceuil = new JMenu("Accueil");
		mb.add(menuAcceuil);
		acc = new JMenuItem("Accueil");
		menuAcceuil.add(acc);
		
			/*Menu client*/
		menuClient = new JMenu("Client");
		cl1 = new JMenuItem("Nouveau");
		cl2 = new JMenuItem("Liste");
		menuClient.add(cl1);
		menuClient.add(cl2);
		mb.add(menuClient);
		
			/*Menu Produit*/
		menuProduit = new JMenu("Produit");
		prd1 = new JMenuItem("Nouveau");
		prd2 = new JMenuItem("Liste");
		menuProduit.add(prd1);
		menuProduit.add(prd2);
		mb.add(menuProduit);
		
		
			/*Menu Emprunt*/
		menuEmprunt = new JMenu("Emprunt");
		em1 = new JMenuItem("Ajout");
		em2 = new JMenuItem("Retour emprunt");
		em3 = new JMenuItem("Liste (en cours)");
		em4 = new JMenuItem("Liste (tout)");
		menuEmprunt.add(em1);
		menuEmprunt.add(em2);
		menuEmprunt.add(em3);
		menuEmprunt.add(em4);
		mb.add(menuEmprunt);
		
			/*Menu D�connexion*/
		menuDeco = new JMenu("Déconnexion");
		md = new JMenuItem("Déconnexion");
		menuDeco.add(md);
		mb.add(menuDeco);
		
			/*Menu Quitter*/
		menuQuitter = new JMenu("Quitter");
		mq = new JMenuItem("Quitter");
		menuQuitter.add(mq);
		mb.add(menuQuitter);
		
		
		
		
		
		/*---------PANEL----------*/
			/*Panel Login*/
		ImageIcon iconlog = new ImageIcon("F:\\IUT\\S2\\PROJET_POO_COO\\V2 modif\\v2\\icon_log.png");
		pnlLogin = new JPanel();
		pnlLogin.setLayout(null);
		JLabel lblIdLog,lblMdpLog;
		JTextField tfIdLog;
		JPasswordField tfMdpLog;
		JButton btnAnnulerLog, btnConnecterLog;
		JLabel image=new JLabel(iconlog);
		lblIdLog = new JLabel("Identifiant : ");
		lblMdpLog = new JLabel("Mot de passe : ");
		tfIdLog = new JTextField();
		tfMdpLog = new JPasswordField();
		btnAnnulerLog = new JButton("Quitter");
		btnConnecterLog = new JButton("Valider");
		pnlLogin.add(lblIdLog);
		pnlLogin.add(lblMdpLog);
		pnlLogin.add(tfIdLog);
		pnlLogin.add(tfMdpLog);
		pnlLogin.add(btnAnnulerLog);
		pnlLogin.add(btnConnecterLog);
		pnlLogin.add(image);
		lblIdLog.setBounds(250, 250, 100, 25);
		lblMdpLog.setBounds(250, 290, 100, 25);
		tfIdLog.setBounds(350, 250, 150, 25);
		tfMdpLog.setBounds(350, 290, 150, 25);
		btnAnnulerLog.setBounds(300, 360, 80, 25);
		btnAnnulerLog.setBackground(Color.decode("#ff7f7f"));
		btnConnecterLog.setBounds(420,360,80,25);
		btnConnecterLog.setBackground(Color.decode("#7FFF94"));
		image.setBounds(350,40,150,150);
		
		
		
			/*Panel Acceuil*/
		
				/*Variable acceuil*/
		JLabel welcome;
		ImageIcon logoUniv = new ImageIcon("F:\\IUT\\S2\\PROJET_POO_COO\\V2 modif\\v2\\univ-lor.png");
		JTextArea textCenterAcceuil;
		JLabel logoUL=new JLabel(logoUniv);
		textCenterAcceuil = new JTextArea();
		pnlAcceuil = new JPanel();
		pnlAcceuil.setLayout(null);
		pnlAcceuil.add(logoUL);
		welcome = new JLabel("Projet POO-COO 2020-2021 | Département informatique IUT Metz");
		welcome.setFont(new Font("Calibri",Font.ITALIC,25));
		pnlAcceuil.add(welcome);
		welcome.setBounds(100,20,700,40);
		logoUL.setBounds(210,50,400,400);
		//pnlAcceuil.add(textCenterAcceuil);
		//textCenterAcceuil.setBounds(100,100,630,300);
		
		
		
		
		/*PanelAddClient*/
			/*Variable Client*/
		JLabel lblCl,lblIdCl,lblNomCl,lblPrenomCl,lblCivilite,lblTypeCl;
		JTextField tfIdCl,tfNomCl,tfPrenomCl;
		JButton btnValiderAjoutClient, btnAnnulerAjoutClient;
		String sexe[]={"","Monsieur","Madame"};
		String fidelite[]= {"","Fidele","Occasionnel"};
		JComboBox<String> cboCivilite = new JComboBox(sexe);
		JComboBox<String> cboFidelite = new JComboBox(fidelite);
			/*Declaration*/
		pnlClient = new JPanel();
		pnlClient.setLayout(new BorderLayout());
		pnlClient.setLayout(null);
		lblCl = new JLabel("Ajouter un client");
		lblCl.setFont(new Font("Calibri",Font.ITALIC,30));
		lblIdCl = new JLabel("Identifiant : ");
		lblCivilite = new JLabel("Civilité : ");
		lblNomCl = new JLabel("Nom : ");
		lblPrenomCl = new JLabel("Prénom : ");
		lblTypeCl = new JLabel("Type : ");
		tfIdCl = new JTextField();
		tfNomCl = new JTextField();
		tfPrenomCl = new JTextField();
		btnValiderAjoutClient = new JButton("Valider");
		btnAnnulerAjoutClient = new JButton("Annuler");
		pnlClient.add(lblCl);
		pnlClient.add(lblCivilite);
		pnlClient.add(cboCivilite);
		pnlClient.add(lblNomCl);
		pnlClient.add(lblPrenomCl);
		pnlClient.add(tfNomCl);
		pnlClient.add(tfPrenomCl);
		pnlClient.add(lblTypeCl);
		pnlClient.add(cboFidelite);
		pnlClient.add(btnAnnulerAjoutClient);
		pnlClient.add(btnValiderAjoutClient);
		lblCl.setBounds(300, 30, 300, 30);
		lblIdCl.setBounds(500, 60, 90, 50);
		lblCivilite.setBounds(300,100,90,50);
		lblNomCl.setBounds(300, 140, 90, 50);
		lblPrenomCl.setBounds(300, 180, 90, 50);
		lblTypeCl.setBounds(300,220,90,50);
		tfIdCl.setBounds(370, 75, 120, 25);
		tfNomCl.setBounds(370,155,120,25);
		tfPrenomCl.setBounds(370,195,120,25);
		cboCivilite.setBounds(370, 115, 120, 25);
		cboFidelite.setBounds(370, 235, 120, 25);
		btnAnnulerAjoutClient.setBounds(300, 300, 80, 25);
		btnValiderAjoutClient.setBounds(410,300,80,25);
			//Panel liste Client
		JPanel pnlBouton;
		JButton btnAnnulerListeClient, btnValierListeClient, btnNouveauListeClient;
		JScrollPane scListClient;
		String[] columns= {"Id","Nom","Prenom","Fidélité"};
		JTable tblListClient = new JTable(listClient, columns);
		//Table
		pnlListClient = new JPanel();
		pnlListClient.setLayout(new BorderLayout());
		scListClient = new JScrollPane(tblListClient);
		//panel bouton de droite
		pnlBouton = new JPanel();
		pnlBouton.setLayout(null);
		btnAnnulerListeClient = new JButton("Annuler");
		btnValierListeClient = new JButton("Valider");
		btnNouveauListeClient = new JButton("Nouveau Client");
		pnlBouton.add(btnAnnulerListeClient);
		pnlBouton.add(btnValierListeClient);
		pnlBouton.add(btnNouveauListeClient);
		btnAnnulerListeClient.setBounds(20, 70, 100, 25);
		btnValierListeClient.setBounds(20, 20, 100, 25);
		btnNouveauListeClient.setBounds(20, 120, 150, 25);
		pnlListClient.add(scListClient, BorderLayout.WEST);
		pnlListClient.add(pnlBouton);
		
		
			/*Panel d'ajout d'un produit*/
		JPanel pnlAjoutProduit = new JPanel();
		pnlAjoutProduit.setLayout(null);
		JLabel lblAjout,lblTypeAjout,lblTitreAjout, lblTarifAjout, lblIdAjout,lblAnneeSortieAjout,lblRealisateurAjout,lblLangueAjout,lblAuteurAjout,lblQuantiteAjout;
		String type[]= {"CD","DVD","Dictionnaire","BD","Manuel","Roman"};
		String langue[]= {"","Francais","Allemand","Anglais","Italien","Espagnol","Polonais","Russe","Arabe"};
		String idProduit;
		JComboBox<String> cboTypeAjout = new JComboBox(type);
		JComboBox<String> cboLangueAjout = new JComboBox(langue);
		JTextField tfTarifAjout,tfIdAjout, tfTitreAjout,tfAnneeSortieAjout,tfRealisateurAjout, tfAuteurAjout, tfQuantiteAjout;
		JButton btnAnnulerAjoutProduit = new JButton("Annuler");
		JButton btnValiderAjoutProduit = new JButton("Valider");
		int idproduit;
		lblAjout = new JLabel("Ajout d'un produit");
		lblAjout.setFont(new Font("Calibri",Font.ITALIC,30));
		lblTypeAjout= new JLabel("Type");
		lblTitreAjout= new JLabel("Titre");
		lblTarifAjout= new JLabel("Tarif");
		lblIdAjout= new JLabel("ID");
		lblAnneeSortieAjout= new JLabel("Année de sortie");
		lblRealisateurAjout= new JLabel("Realisateur");
		lblLangueAjout= new JLabel("Langue");
		lblAuteurAjout= new JLabel("Auteur");
		lblQuantiteAjout= new JLabel("Quantité");
		tfTarifAjout = new JTextField();
		tfIdAjout = new JTextField();
		tfTitreAjout = new JTextField();
		tfAnneeSortieAjout = new JTextField();
		tfRealisateurAjout = new JTextField();
		tfAuteurAjout = new JTextField();
		tfQuantiteAjout = new JTextField();
		pnlAjoutProduit.add(lblAjout);
		pnlAjoutProduit.add(lblTypeAjout);
		pnlAjoutProduit.add(lblTitreAjout);
		pnlAjoutProduit.add(lblTarifAjout);
		pnlAjoutProduit.add(lblAnneeSortieAjout);
		pnlAjoutProduit.add(lblRealisateurAjout);
		pnlAjoutProduit.add(lblLangueAjout);
		pnlAjoutProduit.add(lblAuteurAjout);
		pnlAjoutProduit.add(lblQuantiteAjout);
		pnlAjoutProduit.add(lblRealisateurAjout);
		pnlAjoutProduit.add(tfTitreAjout);
		pnlAjoutProduit.add(tfAnneeSortieAjout);
		pnlAjoutProduit.add(tfRealisateurAjout);
		pnlAjoutProduit.add(tfTarifAjout);
		pnlAjoutProduit.add(tfAuteurAjout);
		pnlAjoutProduit.add(tfQuantiteAjout);
		pnlAjoutProduit.add(cboTypeAjout);
		pnlAjoutProduit.add(cboLangueAjout);
		pnlAjoutProduit.add(btnAnnulerAjoutProduit);
		pnlAjoutProduit.add(btnValiderAjoutProduit);
		lblAjout.setBounds(300,30,300,35);
		lblTypeAjout.setBounds(150,100,100,25);
		cboTypeAjout.setBounds(280,100,100,25);
		lblTitreAjout.setBounds(150, 140, 150, 25);
		tfTitreAjout.setBounds(280, 140, 200, 25);
		lblTarifAjout.setBounds(150,180,80,25);
		tfTarifAjout.setBounds(280,180,80,25);
		lblAnneeSortieAjout.setBounds(150,220,150,25);
		tfAnneeSortieAjout.setBounds(280,220,80,25);
		lblRealisateurAjout.setBounds(150,260,150,25);
		tfRealisateurAjout.setBounds(280,260,200,25);
		lblLangueAjout.setBounds(150,300,100,25);
		cboLangueAjout.setBounds(280,300,100,25);
		lblAuteurAjout.setBounds(150,340,100,25);
		tfAuteurAjout.setBounds(280,340,205,25);
		lblQuantiteAjout.setBounds(150,380,100,25);
		tfQuantiteAjout.setBounds(280,380,80,25);
		btnAnnulerAjoutProduit.setBounds(400,430,100,25);
		btnValiderAjoutProduit.setBounds(510,430,100,25);
		tfIdAjout.setEnabled(false);
		tfIdAjout.setText("1");
		tfIdAjout.setEnabled(false);
		lblAnneeSortieAjout.setEnabled(true);
		tfAnneeSortieAjout.setEnabled(true);
		lblRealisateurAjout.setEnabled(false);
		tfRealisateurAjout.setEnabled(false);
		lblLangueAjout.setEnabled(false);
		cboLangueAjout.setEnabled(false);
		lblAuteurAjout.setEnabled(false);
		tfAuteurAjout.setEnabled(false);
		lblQuantiteAjout.setEnabled(true);
		tfQuantiteAjout.setEnabled(true);
		btnAnnulerAjoutProduit.setEnabled(true);
		btnValiderAjoutProduit.setEnabled(true);

		/*panel liste produit*/

		JButton btnNouveauProduit;
		JScrollPane scListProduit;
		JLabel titreListProduit = new JLabel("Liste de produit(s)");
		titreListProduit.setFont(new Font("Calibri",Font.ITALIC,20));
		String[] columnsListProduit= {"Id","Type","Quantité","Titre","Tarif","Realisateur","Annee sortie", "Auteur", "Langue"};				//a voir
		JTable tblListProduit= new JTable(listProduit, columnsListProduit);
		//Table
		pnlListProduit = new JPanel();
		pnlListProduit.setLayout(null);
		scListProduit = new JScrollPane(tblListProduit);
		btnNouveauProduit = new JButton("Nouveau Produit");
		pnlListProduit.add(btnNouveauProduit);
		pnlListProduit.add(scListProduit);
		pnlListProduit.add(titreListProduit);
		titreListProduit.setBounds(350,30,300,30);
		scListProduit.setBounds(10,75,810,360);
		btnNouveauProduit.setBounds(340, 445, 150, 30);



		
		
		
		/*panel Emprunt*/
		JPanel pnlEmprunt = new JPanel();
		pnlEmprunt.setLayout(null);
		JLabel lblTitreEmprunt,lblClientEmprunt,lblProduitEmprunt,lblDateDebutEmprunt, lblDateFinEmprunt, lblInfoClientEmprunt;
		JTextField tfDateDeb,tfDateFin,tfIdClientEmprunt,tfProduitEmprunt;
		JButton okClientEmprunt, ajouterEmprunt,validerEmprunt,annulerEmprunt,validerProd;
		JScrollPane scListEmprunt;
		String[] cListEmprunt= {"Id","Titre","Date Début","Date Fin","Prix" };

		JTable tblListEmpunt = new JTable(listEmprunt, cListEmprunt);
		scListEmprunt = new JScrollPane(tblListEmpunt);
		tfIdClientEmprunt = new JTextField();
		lblTitreEmprunt=new JLabel("Nouvel Emprunt");
		lblTitreEmprunt.setFont(new Font("Calibri",Font.ITALIC,30));
		lblClientEmprunt = new JLabel("Client");
		okClientEmprunt = new JButton("OK");
		lblDateDebutEmprunt = new JLabel("Date de Debut");
		lblDateFinEmprunt = new JLabel("Date de Fin");
		lblProduitEmprunt = new JLabel("Produit");
		tfProduitEmprunt = new JTextField();
		lblInfoClientEmprunt = new JLabel();
		validerProd = new JButton("Ok");
		ajouterEmprunt = new JButton("Ajouter");
		validerEmprunt = new JButton("Valider");
		annulerEmprunt = new JButton("Annuler");
		tfDateDeb = new JTextField();
		tfDateFin = new JTextField();
		pnlEmprunt.add(lblTitreEmprunt);
		pnlEmprunt.add(lblClientEmprunt);
		pnlEmprunt.add(tfIdClientEmprunt);
		pnlEmprunt.add(scListEmprunt);
		pnlEmprunt.add(okClientEmprunt);
		pnlEmprunt.add(tfProduitEmprunt);
		pnlEmprunt.add(lblProduitEmprunt);
		pnlEmprunt.add(ajouterEmprunt);
		pnlEmprunt.add(validerEmprunt);
		pnlEmprunt.add(annulerEmprunt);
		pnlEmprunt.add(lblDateDebutEmprunt);
		pnlEmprunt.add(lblDateFinEmprunt);
		pnlEmprunt.add(tfDateFin);
		pnlEmprunt.add(tfDateDeb);
		pnlEmprunt.add(validerProd);
		pnlEmprunt.add(lblInfoClientEmprunt);
		lblTitreEmprunt.setBounds(325,30,250,30);
		lblClientEmprunt.setBounds(50,80,50,25);
		tfIdClientEmprunt.setBounds(110,80,150,25);
		okClientEmprunt.setBounds(275,80,80,25);
		lblInfoClientEmprunt.setBounds(370,80,450,25);
		scListEmprunt.setBounds(370,105,450,300);
		lblProduitEmprunt.setBounds(50,260,50,25);
		lblDateDebutEmprunt.setBounds(50,150,150,25);
		tfDateDeb.setBounds(170,150,165,25);
		lblDateFinEmprunt.setBounds(50,180,150,25);
		tfDateFin.setBounds(170,180,165,25);
		tfProduitEmprunt.setBounds(110,260,245,25);
		ajouterEmprunt.setBounds(165,350,80,25);
		validerProd.setBounds(165,310,80,25);
		validerEmprunt.setBounds(50,405,110,25);
		annulerEmprunt.setBounds(245,405,110,25);



		/*panel retour Emprunt*/
		pnlRetourEmprunt = new JPanel();
		pnlRetourEmprunt.setLayout(null);
		JLabel titreRetourEmprunt=new JLabel("Retour emprunt");
		titreRetourEmprunt.setFont(new Font("Calibri",Font.ITALIC,30));
		JLabel lblIdRetourEmprunt = new JLabel("ID Commande : ");
		JTextField tfIdRetourEmprunt = new JTextField();
		JButton annulerRetourEmprunt = new JButton("Annuler");
		JButton validerRetourEmprunt = new JButton("Valider");
		pnlRetourEmprunt.add(titreRetourEmprunt);
		pnlRetourEmprunt.add(lblIdRetourEmprunt);
		pnlRetourEmprunt.add(tfIdRetourEmprunt);
		pnlRetourEmprunt.add(annulerRetourEmprunt);
		pnlRetourEmprunt.add(validerRetourEmprunt);
		titreRetourEmprunt.setBounds(350,30,300,30);
		lblIdRetourEmprunt.setBounds(300,120,200,25);
		tfIdRetourEmprunt.setBounds(400,120,50,25);
		annulerRetourEmprunt.setBounds(280,220,100,25);
		validerRetourEmprunt.setBounds(420,220,100,25);


		/*panel liste emprunt*/

		JScrollPane scListEmpruntEC;
		String[] columnsListEmprunt= {"Id","Client","Date de Debut","Date de fin","Produit","Prix"};				//a voir
		JTable tblListEmprunt= new JTable(listEmpruntEC, columnsListEmprunt);
		JLabel jlEmpruntEC = new JLabel("Emprunt(s) en cours");
		jlEmpruntEC.setFont(new Font("Calibri",Font.ITALIC,20));
		//Table

		pnlListEmpruntEC = new JPanel();
		pnlListEmpruntEC.setLayout(null);
		scListEmpruntEC = new JScrollPane(tblListEmprunt);
		pnlListEmpruntEC.add(scListEmpruntEC);
		pnlListEmpruntEC.add(jlEmpruntEC);
		scListEmpruntEC.setBounds(10,50,810,360);
		jlEmpruntEC.setBounds(300,10,300,30);


		/*panel liste emprunt TOUT*/

		JScrollPane scListEmpruntTout;
		String[] columnsListEmpruntTout= {"Id","Client","Date de Debut","Date de fin","Produit","Prix"};				//a voir
		JTable tblListEmpruntTout= new JTable(listEmpruntTout, columnsListEmpruntTout);
		JLabel jlEmpruntTout = new JLabel("Tous les emprunts");
		jlEmpruntTout.setFont(new Font("Calibri",Font.ITALIC,20));
		//Table
		JPanel pnlListEmprunTout = new JPanel();
		pnlListEmprunTout.setLayout(null);
		scListEmpruntTout = new JScrollPane(tblListEmpruntTout);
		pnlListEmprunTout.add(scListEmpruntTout);
		pnlListEmprunTout.add(jlEmpruntTout);
		scListEmpruntTout.setBounds(10,50,810,360);
		jlEmpruntTout.setBounds(300,10,300,30);

		
		
		
		/*Panel de fin Copyright*/
		JLabel copyright;
		pnlBas = new JPanel();
		copyright = new JLabel("CRIQUELION Julien, WAJDA Adrien | IUT Informatique Metz 2020-2021 ©");
		pnlBas.add(copyright);
		
		
		
		
		
		
				//Login
		btnConnecterLog.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String userId = tfIdLog.getText().toString();
				String userMdp = tfMdpLog.getText().toString();
				
				if(userId.equals(IdentLog) && userMdp.equals(IdentMdp)) {
					System.out.println("Ok");
					tfIdLog.setText("");
					tfMdpLog.setText("");
					pnlLogin.setVisible(false);
					pnlBas.setVisible(true);
					fenetre.add(pnlAcceuil);
					pnlAcceuil.setVisible(true);
					fenetre.add(mb, BorderLayout.NORTH);
					mb.setVisible(true);
					creerJeuDEssais();
					//JOptionPane.showMessageDialog(null, "Bienvenue "+userId+" dans la gestion de la Videoth�que");
					
				}
				else {
					JOptionPane.showMessageDialog(null,"Identifiant ou mot de passe invalide !"); 
					String text = tfIdLog.getText().toString();
					tfIdLog.setText("");
					tfMdpLog.setText("");
					System.out.println("log : "+text);
					System.out.println("mdp : "+tfMdpLog.getText());
					
				}
				
					
			}
		});
		btnAnnulerLog.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
				quitterApplication();
			}
		});


		//Bonton du Menu Bar
		md.addActionListener(new ActionListener()//Deconnexion
		{
			public void actionPerformed(ActionEvent e)
			{

				int reponse = JOptionPane.showConfirmDialog(null,
						"Voulez-vous vraiment vous déconnecter ?", "Confirmation",
						JOptionPane.YES_NO_OPTION);

				// traitement de la réponse
				switch (reponse) {
					case JOptionPane.YES_OPTION:
						pnlAcceuil.setVisible(false);
						pnlClient.setVisible(false);
						pnlAjoutProduit.setVisible(false);
						pnlListClient.setVisible(false);
						pnlBas.setVisible(false);
						pnlLogin.setVisible(false);
						pnlEmprunt.setVisible(false);
						pnlListProduit.setVisible(false);
						pnlListEmpruntEC.setVisible(false);
						pnlRetourEmprunt.setVisible(false);
						pnlListEmprunTout.setVisible(false);
						mb.setVisible(false);
						fenetre.add(pnlLogin);
						pnlLogin.setVisible(true);
						fenetre.add(mb, BorderLayout.NORTH);;
						break;
					case JOptionPane.NO_OPTION:
						// ...
						break;
					case JOptionPane.CLOSED_OPTION:
						// ...
						break;
				}
			

			}
		});

		acc.addActionListener(new ActionListener() //Menu acceuil
		{
			public void actionPerformed(ActionEvent e)
			{

				pnlAcceuil.setVisible(true);
				pnlClient.setVisible(false);
				pnlAjoutProduit.setVisible(false);
				pnlListClient.setVisible(false);
				pnlBas.setVisible(true);
				pnlLogin.setVisible(false);
				pnlEmprunt.setVisible(false);
				pnlListProduit.setVisible(false);
				pnlListEmpruntEC.setVisible(false);
				pnlRetourEmprunt.setVisible(false);
				pnlListEmprunTout.setVisible(false);
				fenetre.add(pnlAcceuil);
				pnlAcceuil.setVisible(true);
			}
		});

		cl1.addActionListener(new ActionListener()//Ajout de client
		{
			public void actionPerformed(ActionEvent e)
			{
				pnlAcceuil.setVisible(false);
				pnlClient.setVisible(false);
				pnlAjoutProduit.setVisible(false);
				pnlListClient.setVisible(false);
				pnlEmprunt.setVisible(false);
				pnlBas.setVisible(true);
				pnlLogin.setVisible(false);
				pnlListProduit.setVisible(false);
				pnlListEmpruntEC.setVisible(false);
				pnlRetourEmprunt.setVisible(false);
				pnlListEmprunTout.setVisible(false);
				fenetre.add(pnlClient);
				pnlClient.setVisible(true);
				
			}
		});
		cl2.addActionListener(new ActionListener() // Liste de CLient
		{
			public void actionPerformed(ActionEvent e)
			{
				pnlAcceuil.setVisible(false);
				pnlClient.setVisible(false);
				pnlAjoutProduit.setVisible(false);
				pnlEmprunt.setVisible(false);
				pnlListClient.setVisible(false);
				pnlBas.setVisible(false);
				pnlLogin.setVisible(false);
				pnlListProduit.setVisible(false);
				pnlListEmpruntEC.setVisible(false);
				pnlRetourEmprunt.setVisible(false);
				pnlListEmprunTout.setVisible(false);
				fenetre.add(pnlListClient);
				pnlListClient.setVisible(true);
				
			}
		});
		
		prd1.addActionListener(new ActionListener() //Ajout de produit
		{
			public void actionPerformed(ActionEvent e)
			{
				pnlAcceuil.setVisible(false);
				pnlClient.setVisible(false);
				pnlAjoutProduit.setVisible(false);
				pnlListClient.setVisible(false);
				pnlEmprunt.setVisible(false);
				pnlBas.setVisible(true);
				pnlLogin.setVisible(false);
				pnlListProduit.setVisible(false);
				pnlListEmpruntEC.setVisible(false);
				pnlRetourEmprunt.setVisible(false);
				pnlListEmprunTout.setVisible(false);
				fenetre.add(pnlAjoutProduit);
				pnlAjoutProduit.setVisible(true);
				
				
			}
		});
		prd2.addActionListener(new ActionListener() //Liste de produit
		{
			public void actionPerformed(ActionEvent e) {
				pnlAcceuil.setVisible(false);
				pnlClient.setVisible(false);
				pnlAjoutProduit.setVisible(false);
				pnlListClient.setVisible(false);
				pnlBas.setVisible(false);
				pnlEmprunt.setVisible(false);
				pnlLogin.setVisible(false);
				pnlListProduit.setVisible(false);
				pnlListEmpruntEC.setVisible(false);
				pnlRetourEmprunt.setVisible(false);
				pnlListEmprunTout.setVisible(false);
				fenetre.add(pnlListProduit);
				pnlListProduit.setVisible(true);
			}
		});


		em1.addActionListener(new ActionListener() // Ajout d'emprunt
		{
			public void actionPerformed(ActionEvent e)
			{
				pnlAcceuil.setVisible(false);
				pnlClient.setVisible(false);
				pnlAjoutProduit.setVisible(false);
				pnlListClient.setVisible(false);
				pnlBas.setVisible(true);
				pnlEmprunt.setVisible(false);
				pnlLogin.setVisible(false);
				pnlListProduit.setVisible(false);
				pnlListEmpruntEC.setVisible(false);
				pnlRetourEmprunt.setVisible(false);
				pnlListEmprunTout.setVisible(false);
				fenetre.add(pnlEmprunt);
				pnlEmprunt.setVisible(true);
				tfDateDeb.setEnabled(false);
				lblDateDebutEmprunt.setEnabled(false);
				tfDateFin.setEnabled(false);
				lblDateFinEmprunt.setEnabled(false);
				tfProduitEmprunt.setEnabled(false);
				lblProduitEmprunt.setEnabled(false);
				ajouterEmprunt.setEnabled(false);
				validerProd.setEnabled(false);
				validerEmprunt.setEnabled(false);
				
			}
		});
		em2.addActionListener(new ActionListener() // Retour d'emprunt
		{
			public void actionPerformed(ActionEvent e)
			{
				pnlAcceuil.setVisible(false);
				pnlClient.setVisible(false);
				pnlAjoutProduit.setVisible(false);
				pnlEmprunt.setVisible(false);
				pnlListClient.setVisible(false);
				pnlBas.setVisible(true);
				pnlLogin.setVisible(false);
				pnlListProduit.setVisible(false);
				pnlListEmpruntEC.setVisible(false);
				pnlRetourEmprunt.setVisible(false);
				pnlListEmprunTout.setVisible(false);
				fenetre.add(pnlRetourEmprunt);
				pnlRetourEmprunt.setVisible(true);

			}
		});
		em3.addActionListener(new ActionListener() // Liste des emprunt en cours
		{
			public void actionPerformed(ActionEvent e)
			{
				pnlAcceuil.setVisible(false);
				pnlClient.setVisible(false);
				pnlEmprunt.setVisible(false);
				pnlAjoutProduit.setVisible(false);
				pnlListClient.setVisible(false);
				pnlBas.setVisible(true);
				pnlLogin.setVisible(false);
				pnlListProduit.setVisible(false);
				pnlListEmpruntEC.setVisible(false);
				pnlRetourEmprunt.setVisible(false);
				pnlListEmprunTout.setVisible(false);
				fenetre.add(pnlListEmpruntEC);
				pnlListEmpruntEC.setVisible(true);

			}
		});
		em4.addActionListener(new ActionListener() // Liste de tout les emprunt
		{
			public void actionPerformed(ActionEvent e)
			{
				pnlAcceuil.setVisible(false);
				pnlClient.setVisible(false);
				pnlEmprunt.setVisible(false);
				pnlAjoutProduit.setVisible(false);
				pnlListClient.setVisible(false);
				pnlBas.setVisible(true);
				pnlLogin.setVisible(false);
				pnlListProduit.setVisible(false);
				pnlListEmpruntEC.setVisible(false);
				pnlRetourEmprunt.setVisible(false);
				pnlListEmprunTout.setVisible(false);
				fenetre.add(pnlListEmprunTout);
				pnlListEmprunTout.setVisible(true);



			}
		});

		/*Bouton du panel Client*/
		//ajout de client
		btnValiderAjoutClient.addActionListener(new ActionListener() // Ajoute le client
		{
			public void actionPerformed(ActionEvent e)
			{
				//boolean fidele;
				String isFidele;

				if(tfPrenomCl.getText().isEmpty()||tfNomCl.getText().isEmpty()||cboCivilite.getSelectedItem()==""|cboFidelite.getSelectedItem()==""){
					JOptionPane.showMessageDialog(null,"Veuillez remplir tout les champs");
				}
				else {
					if(cboFidelite.getSelectedItem()=="Fidele") {
						//fidele=true;
						isFidele="Fidele";
					}
					else {
						//fidele=false;
						isFidele="Occasionnel";
					}
					listClient[idcl][0] = idcl;
					listClient[idcl][1] = tfNomCl.getText().toUpperCase();
					listClient[idcl][2] = tfPrenomCl.getText();
					listClient[idcl][3] = isFidele;

					JOptionPane.showMessageDialog(null, "Client : " + idcl + " : " + tfPrenomCl.getText() + " " + tfNomCl.getText().toUpperCase() + ", " + isFidele);
					cboFidelite.setSelectedItem("");
					cboFidelite.setSelectedItem("");
					tfNomCl.setText("");
					tfPrenomCl.setText("");
					idcl++;
				}

			}
		});

		btnAnnulerAjoutClient.addActionListener(new ActionListener() // Annule l'ajout du client
		{
			public void actionPerformed(ActionEvent e)
			{
				pnlAcceuil.setVisible(false);
				pnlListClient.setVisible(false);
				pnlLogin.setVisible(false);
				pnlBas.setVisible(true);
				pnlAjoutProduit.setVisible(false);
				pnlClient.setVisible(false);
				fenetre.add(pnlAcceuil);
				pnlAcceuil.setVisible(true);

			}
		});

		//Liste Cleint
		btnAnnulerListeClient.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				pnlAcceuil.setVisible(false);
				pnlListClient.setVisible(false);
				pnlLogin.setVisible(false);
				pnlBas.setVisible(true);
				pnlAjoutProduit.setVisible(false);
				pnlClient.setVisible(false);
				fenetre.add(pnlAcceuil);
				pnlAcceuil.setVisible(true);

			}
		});

		btnNouveauListeClient.addActionListener(new ActionListener() // Ajout d'un client
		{
			public void actionPerformed(ActionEvent e)
			{
				pnlAcceuil.setVisible(false);
				pnlListClient.setVisible(false);
				pnlLogin.setVisible(false);
				pnlBas.setVisible(true);
				pnlAjoutProduit.setVisible(false);
				fenetre.add(pnlClient);
				pnlClient.setVisible(true);

			}
		});


		/*Bouton Produit*/
		cboTypeAjout.addActionListener(new ActionListener() // Permet d'afficehr ou non les ligne pour ajouter un produit
		{
			public void actionPerformed(ActionEvent e)
			{
				if (cboTypeAjout.getSelectedItem().toString()=="CD") {

					tfIdAjout.setEnabled(false);
					lblAnneeSortieAjout.setEnabled(true);
					tfAnneeSortieAjout.setEnabled(true);
					lblRealisateurAjout.setEnabled(false);
					tfRealisateurAjout.setEnabled(false);
					lblLangueAjout.setEnabled(false);
					cboLangueAjout.setEnabled(false);
					lblAuteurAjout.setEnabled(false);
					tfAuteurAjout.setEnabled(false);
					lblQuantiteAjout.setEnabled(true);
					tfQuantiteAjout.setEnabled(true);
					btnAnnulerAjoutProduit.setEnabled(true);
					btnValiderAjoutProduit.setEnabled(true);

				}
				else if (cboTypeAjout.getSelectedItem().toString()=="DVD") {

					tfIdAjout.setEnabled(false);
					lblAnneeSortieAjout.setEnabled(true);
					lblAnneeSortieAjout.setEnabled(false);
					tfAnneeSortieAjout.setEnabled(false);
					lblRealisateurAjout.setEnabled(true);
					tfRealisateurAjout.setEnabled(true);
					lblLangueAjout.setEnabled(false);
					cboLangueAjout.setEnabled(false);
					lblAuteurAjout.setEnabled(false);
					tfAuteurAjout.setEnabled(false);
					lblQuantiteAjout.setEnabled(true);
					tfQuantiteAjout.setEnabled(true);
					btnAnnulerAjoutProduit.setEnabled(true);
					btnValiderAjoutProduit.setEnabled(true);

				}
				else if (cboTypeAjout.getSelectedItem().toString()=="Dictionnaire") {

					tfIdAjout.setEnabled(false);
					lblAnneeSortieAjout.setEnabled(true);
					lblAnneeSortieAjout.setEnabled(false);
					tfAnneeSortieAjout.setEnabled(false);
					lblRealisateurAjout.setEnabled(false);
					tfRealisateurAjout.setEnabled(false);
					lblLangueAjout.setEnabled(true);
					cboLangueAjout.setEnabled(true);
					lblAuteurAjout.setEnabled(false);
					tfAuteurAjout.setEnabled(false);
					lblQuantiteAjout.setEnabled(true);
					tfQuantiteAjout.setEnabled(true);
					btnAnnulerAjoutProduit.setEnabled(true);
					btnValiderAjoutProduit.setEnabled(true);

				}
				else if (cboTypeAjout.getSelectedItem().toString()=="BD"||cboTypeAjout.getSelectedItem().toString()=="Manuel"||cboTypeAjout.getSelectedItem().toString()=="Roman") {

					tfIdAjout.setEnabled(false);
					lblAnneeSortieAjout.setEnabled(true);
					lblAnneeSortieAjout.setEnabled(false);
					tfAnneeSortieAjout.setEnabled(false);
					lblRealisateurAjout.setEnabled(false);
					tfRealisateurAjout.setEnabled(false);
					lblLangueAjout.setEnabled(false);
					cboLangueAjout.setEnabled(false);
					lblAuteurAjout.setEnabled(true);
					tfAuteurAjout.setEnabled(true);
					lblQuantiteAjout.setEnabled(true);
					tfQuantiteAjout.setEnabled(true);
					btnAnnulerAjoutProduit.setEnabled(true);
					btnValiderAjoutProduit.setEnabled(true);

				}

			}
		});

		/*bouton ajouter un produit avec controle de remplissage de tout les champs*/
		btnValiderAjoutProduit.addActionListener(new ActionListener() //ajouter produit
		{
			public void actionPerformed(ActionEvent e) {
				try {
					int i = Integer.parseInt(tfTarifAjout.getText());
				} catch (NumberFormatException a) {
					JOptionPane.showMessageDialog(null, "Veuillez saisir un prix.");
					tfTarifAjout.setText(null);
				}
				try {
					int i = Integer.parseInt(tfAnneeSortieAjout.getText());
				} catch (NumberFormatException a) {
					JOptionPane.showMessageDialog(null, "Veuillez saisir une année de sortie.");
					tfAnneeSortieAjout.setText(null);
				}
				try {
					int i = Integer.parseInt(tfQuantiteAjout.getText());
				} catch (NumberFormatException a) {
					JOptionPane.showMessageDialog(null, "Veuillez saisir une quantité.");
					tfQuantiteAjout.setText(null);
				}
				if(cboTypeAjout.getSelectedItem()=="CD") {
					if(tfTitreAjout.getText().isEmpty()||tfTarifAjout.getText().isEmpty()||tfAnneeSortieAjout.getText().isEmpty()||tfQuantiteAjout.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null,  "Veuillez saisir tous les champs");
					}
					else {
						JOptionPane.showMessageDialog(null,  "Vous avez ajoute "+tfQuantiteAjout.getText().toString()+" "+tfTitreAjout.getText().toString()+" a la liste de "+cboTypeAjout.getSelectedItem().toString());
						listProduit[idprod][0] = idprod;
						listProduit[idprod][1] = cboTypeAjout.getSelectedItem().toString();
						listProduit[idprod][2] = tfQuantiteAjout.getText();
						listProduit[idprod][3] = tfTitreAjout.getText();
						listProduit[idprod][4] = Integer.parseInt(tfTarifAjout.getText());
						listProduit[idprod][6] = tfAnneeSortieAjout.getText();
						tfTitreAjout.setText("");
						tfTarifAjout.setText("");;
						tfAnneeSortieAjout.setText("");
						tfRealisateurAjout.setText("");
						cboLangueAjout.setSelectedItem("");
						tfAuteurAjout.setText("");
						tfQuantiteAjout.setText("");

						idprod++;

					}
				}
				else if (cboTypeAjout.getSelectedItem()=="DVD") {
					try {
						int i = Integer.parseInt(tfTarifAjout.getText());
					} catch (NumberFormatException a) {
						JOptionPane.showMessageDialog(null, "Veuillez saisir un prix.");
						tfTarifAjout.setText(null);
					}
					try {
						int i = Integer.parseInt(tfQuantiteAjout.getText());
					} catch (NumberFormatException a) {
						JOptionPane.showMessageDialog(null, "Veuillez saisir une quantité.");
						tfQuantiteAjout.setText(null);
					}
					if(tfTitreAjout.getText().isEmpty()||tfTarifAjout.getText().isEmpty()||tfRealisateurAjout.getText().isEmpty()||tfQuantiteAjout.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null,  "Veuillez saisir tous les champs");
					}
					else {
						JOptionPane.showMessageDialog(null,  "Vous avez ajoute "+tfQuantiteAjout.getText().toString()+" "+tfTitreAjout.getText().toString()+" � la liste de "+cboTypeAjout.getSelectedItem().toString());
						listProduit[idprod][0] = idprod;
						listProduit[idprod][1] = cboTypeAjout.getSelectedItem().toString();
						listProduit[idprod][2] = tfQuantiteAjout.getText();
						listProduit[idprod][3] = tfTitreAjout.getText();
						listProduit[idprod][4] = tfTarifAjout.getText();
						listProduit[idprod][5] = tfRealisateurAjout.getText();
						tfTitreAjout.setText("");
						tfTarifAjout.setText("");;
						tfAnneeSortieAjout.setText("");
						tfRealisateurAjout.setText("");
						cboLangueAjout.setSelectedItem("");
						tfAuteurAjout.setText("");
						tfQuantiteAjout.setText("");
						idprod++;
					}
				}
				else if (cboTypeAjout.getSelectedItem()=="Dictionnaire") {
					try {
						int i = Integer.parseInt(tfTarifAjout.getText());
					} catch (NumberFormatException a) {
						JOptionPane.showMessageDialog(null, "Veuillez saisir un prix.");
						tfTarifAjout.setText(null);
					}
					try {
						int i = Integer.parseInt(tfQuantiteAjout.getText());
					} catch (NumberFormatException a) {
						JOptionPane.showMessageDialog(null, "Veuillez saisir une quantité.");
						tfQuantiteAjout.setText(null);
					}
					if(tfTitreAjout.getText().isEmpty()||tfTarifAjout.getText().isEmpty()||tfQuantiteAjout.getText().isEmpty()||cboLangueAjout.getSelectedItem()=="") {
						JOptionPane.showMessageDialog(null,  "Veuillez saisir tous les champs");
					}
					else {
						JOptionPane.showMessageDialog(null,  "Vous avez ajoute "+tfQuantiteAjout.getText().toString()+" "+tfTitreAjout.getText().toString()+" � la liste de "+cboTypeAjout.getSelectedItem().toString());
						listProduit[idprod][0] = idprod;
						listProduit[idprod][1] = cboTypeAjout.getSelectedItem().toString();
						listProduit[idprod][2] = tfQuantiteAjout.getText();
						listProduit[idprod][3] = tfTitreAjout.getText();
						listProduit[idprod][4] = tfTarifAjout.getText();
						listProduit[idprod][8] = cboLangueAjout.getSelectedItem().toString();
						tfTitreAjout.setText("");
						tfTarifAjout.setText("");;
						tfAnneeSortieAjout.setText("");
						tfRealisateurAjout.setText("");
						cboLangueAjout.setSelectedItem("");
						tfAuteurAjout.setText("");
						tfQuantiteAjout.setText("");
						idprod++;
					}
				}
				else if (cboTypeAjout.getSelectedItem()=="BD"||cboTypeAjout.getSelectedItem()=="Manuel"||cboTypeAjout.getSelectedItem()=="Roman") {
					try {
						int i = Integer.parseInt(tfTarifAjout.getText());
					} catch (NumberFormatException a) {
						JOptionPane.showMessageDialog(null, "Veuillez saisir un prix.");
						tfTarifAjout.setText(null);
					}
					try {
						int i = Integer.parseInt(tfQuantiteAjout.getText());
					} catch (NumberFormatException a) {
						JOptionPane.showMessageDialog(null, "Veuillez saisir une quantité.");
						tfQuantiteAjout.setText(null);
					}
					if(tfTitreAjout.getText().isEmpty()||tfTarifAjout.getText().isEmpty()||tfQuantiteAjout.getText().isEmpty()|| tfAuteurAjout.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null,  "Veuillez saisir tous les champs");
					}
					else {
						JOptionPane.showMessageDialog(null,  "Vous avez ajoute "+tfQuantiteAjout.getText().toString()+" "+tfTitreAjout.getText().toString()+" � la liste de "+cboTypeAjout.getSelectedItem().toString());
						listProduit[idprod][0] = idprod;
						listProduit[idprod][1] = cboTypeAjout.getSelectedItem().toString();
						listProduit[idprod][2] = tfQuantiteAjout.getText();
						listProduit[idprod][3] = tfTitreAjout.getText();
						listProduit[idprod][4] = tfTarifAjout.getText();
						listProduit[idprod][7] = tfAuteurAjout.getText();
						tfTitreAjout.setText("");
						tfTarifAjout.setText("");;
						tfAnneeSortieAjout.setText("");
						tfRealisateurAjout.setText("");
						cboLangueAjout.setSelectedItem("");
						tfAuteurAjout.setText("");
						tfQuantiteAjout.setText("");
						idprod++;
					}
				}



			}
		});

		btnAnnulerAjoutProduit.addActionListener(new ActionListener() //btn Annuler Ajout Prduit panel ajout
		{
			public void actionPerformed(ActionEvent e)
			{
				pnlAcceuil.setVisible(false);
				pnlListClient.setVisible(false);
				pnlLogin.setVisible(false);
				pnlBas.setVisible(true);
				pnlAjoutProduit.setVisible(false);
				pnlClient.setVisible(false);
				fenetre.add(pnlAcceuil);
				pnlAcceuil.setVisible(true);

			}
		});

		btnNouveauProduit.addActionListener(new ActionListener()//nouveau produit de la liste des produits
		{
			public void actionPerformed(ActionEvent e)
			{
				pnlAcceuil.setVisible(false);
				pnlListClient.setVisible(false);
				pnlLogin.setVisible(false);
				pnlBas.setVisible(true);
				pnlAjoutProduit.setVisible(false);
				pnlClient.setVisible(false);
				pnlEmprunt.setVisible(false);
				pnlListProduit.setVisible(false);
				fenetre.add(pnlAjoutProduit);
				pnlAjoutProduit.setVisible(true);


			}
		});



		/*Bouton Emprunt*/
		//Ajout d'un emprunt
		okClientEmprunt.addActionListener(new ActionListener() //Focus sur le client
		{
			public void actionPerformed(ActionEvent e) {
				boolean nb = true;
				try {
					int i = Integer.parseInt(tfIdClientEmprunt.getText());
				} catch (NumberFormatException a) {
					JOptionPane.showMessageDialog(null, "Veuillez saisir un ID client.");
					tfIdClientEmprunt.setText(null);
				}

				int idClEmp = Integer.parseInt(tfIdClientEmprunt.getText());
				if (listClient[idClEmp][0] == null) {
					JOptionPane.showMessageDialog(null, "Client Inexistant");
					tfIdClientEmprunt.setText("");
				} else {
					try {
						int i = Integer.parseInt(tfIdClientEmprunt.getText());
					} catch (NumberFormatException a) {
						JOptionPane.showMessageDialog(null, "Veuillez saisir un ID client.");
					}


					String infoClient;
					infoClient = "Client : " + listClient[idClEmp][0] + ", " + listClient[idClEmp][1] + " " + listClient[idClEmp][2];
					tfIdClientEmprunt.setEnabled(false);
					lblClientEmprunt.setEnabled(false);
					lblInfoClientEmprunt.setText(infoClient);
					tfDateDeb.setEnabled(true);
					lblDateDebutEmprunt.setEnabled(true);
					tfDateFin.setEnabled(true);
					lblDateFinEmprunt.setEnabled(true);
					tfProduitEmprunt.setEnabled(true);
					lblProduitEmprunt.setEnabled(true);
					ajouterEmprunt.setEnabled(false);
					validerProd.setEnabled(true);
					validerEmprunt.setEnabled(false);
					Integer.parseInt(tfIdClientEmprunt.getText().toString());
				}


			}
		});

		validerProd.addActionListener(new ActionListener() { //Valider le produit en cours d'ajout
			public void actionPerformed(ActionEvent e) {
				try {
					int i = Integer.parseInt(tfProduitEmprunt.getText());
				} catch (NumberFormatException a) {
					JOptionPane.showMessageDialog(null, "Veuillez saisir un ID produit.");
					tfProduitEmprunt.setText(null);
				}

				int idPrdEmp = Integer.parseInt(tfProduitEmprunt.getText());
				if (listProduit[idPrdEmp][0]==null){
					JOptionPane.showMessageDialog(null, "Produit inexistant");
					tfProduitEmprunt.setText(null);
				}
				else {
					idProdEmp = Integer.parseInt(tfProduitEmprunt.getText());
					String infoPrd;
					trfObjEmp = (int) listProduit[Integer.parseInt(tfProduitEmprunt.getText().toString())][4];
					infoPrd = listProduit[idPrdEmp][0] + ", " + listProduit[idPrdEmp][1] + " " + listProduit[idPrdEmp][3];
					tfProduitEmprunt.setText(infoPrd);
					ajouterEmprunt.setEnabled(true);
				}


			}
		});

		ajouterEmprunt.addActionListener(new ActionListener() // Ajoute le produit select. a la liste de droit
		{
			public void actionPerformed(ActionEvent e)
			{
				if ((listProduit[idProdEmp][2]).toString()=="0"){
					JOptionPane.showMessageDialog(null,"Plus de produit en stock");
				}
				else {
					listEmprunt[idemp][0] = idProdEmp;
					listEmprunt[idemp][1] = tfProduitEmprunt.getText();
					listEmprunt[idemp][2] = tfDateDeb.getText();
					listEmprunt[idemp][3] = tfDateFin.getText();
					listEmprunt[idemp][4] = trfObjEmp;
					idemp++;
					scListEmprunt.setVisible(false);
					scListEmprunt.setVisible(true);
					tfProduitEmprunt.setText("");
					validerEmprunt.setEnabled(true);
					ajouterEmprunt.setEnabled(false);
				}

			}
		});

		validerEmprunt.addActionListener(new ActionListener() // Valide l'emprunt & créer la commande
		{
			public void actionPerformed(ActionEvent e)
			{
				double prixEmprunt = 0;
				String Emprunt = "";
				for(int i = 0 ; i<idemp;i++){
					prixEmprunt=prixEmprunt+Integer.parseInt(listEmprunt[i][4].toString());
					listProduit[(int) listEmprunt[i][0]][2]=((int)listProduit[i][2])-1;
				}
				if (listClient[Integer.parseInt(tfIdClientEmprunt.getText())][3].toString()=="Fidele"){
					prixEmprunt=prixEmprunt*0.9;
				}
				JOptionPane.showMessageDialog(null, "Prix : " + Math.round(prixEmprunt*1000.0)/1000.0+" €");

				for(int i=0;i<idemp;i++){
					Emprunt = Emprunt+" "+listEmprunt[i][0];

				}
				listEmpruntEC[numEmpreunt][0]=numEmpreunt;
				listEmpruntEC[numEmpreunt][1] = tfIdClientEmprunt.getText();
				listEmpruntEC[numEmpreunt][2]=tfDateDeb.getText();
				listEmpruntEC[numEmpreunt][3]=tfDateFin.getText();
				listEmpruntEC[numEmpreunt][4]=Emprunt;
				listEmpruntEC[numEmpreunt][5]=Math.round(prixEmprunt*1000.0)/1000.0;
				listEmpruntTout[numEmpreunt][0]=numEmpreunt;
				listEmpruntTout[numEmpreunt][1] = tfIdClientEmprunt.getText();
				listEmpruntTout[numEmpreunt][2]=tfDateDeb.getText();
				listEmpruntTout[numEmpreunt][3]=tfDateFin.getText();
				listEmpruntTout[numEmpreunt][4]=Emprunt;
				listEmpruntTout[numEmpreunt][5]=Math.round(prixEmprunt*1000.0)/1000.0;
				numEmpreunt++;


				tfIdClientEmprunt.setEnabled(true);
				lblClientEmprunt.setEnabled(true);
				tfDateDeb.setText("");
				tfDateFin.setText("");
				tfProduitEmprunt.setText("");
				tfIdClientEmprunt.setText("");
				tfIdClientEmprunt.setEnabled(true);
				lblClientEmprunt.setEnabled(true);
				lblInfoClientEmprunt.setText("");
				tfProduitEmprunt.setText("");
				tfDateDeb.setEnabled(false);
				lblDateDebutEmprunt.setEnabled(false);
				tfDateFin.setEnabled(false);
				lblDateFinEmprunt.setEnabled(false);
				tfProduitEmprunt.setEnabled(false);
				lblProduitEmprunt.setEnabled(false);
				ajouterEmprunt.setEnabled(false);
				validerProd.setEnabled(false);
				validerEmprunt.setEnabled(false);


				//Ajoute les emprunt a la liste des commandes
				for(int i=0;i<=idemp;i++){
					listEmprunt[i][0] = "";
					listEmprunt[i][1] = "";
					listEmprunt[i][2] = "";
					listEmprunt[i][3] = "";
					listEmprunt[i][4] = "";

				}
				scListEmprunt.setVisible(false);
				scListEmprunt.setVisible(true);
				idemp=0;

			}
		});

		annulerEmprunt.addActionListener(new ActionListener() // Annule l'emprunt en cours
		{
			public void actionPerformed(ActionEvent e)
			{
				pnlAcceuil.setVisible(false);
				pnlListClient.setVisible(false);
				pnlLogin.setVisible(false);
				pnlBas.setVisible(true);
				pnlAjoutProduit.setVisible(false);
				pnlClient.setVisible(false);
				pnlEmprunt.setVisible(false);
				fenetre.add(pnlAcceuil);
				pnlAcceuil.setVisible(true);
				tfIdClientEmprunt.setEnabled(true);
				lblClientEmprunt.setEnabled(true);
				tfDateDeb.setText("");
				tfDateFin.setText("");
				tfProduitEmprunt.setText("");
				tfIdClientEmprunt.setText("");
				lblInfoClientEmprunt.setText("");
				
			}
		});



		// Retour Emprunt
		validerRetourEmprunt.addActionListener(new ActionListener() //Valide le retour d'un emprunt
		{
			public void actionPerformed(ActionEvent e)
			{
				try {
					int i = Integer.parseInt(tfIdRetourEmprunt.getText());
				} catch (NumberFormatException a) {
					JOptionPane.showMessageDialog(null, "Veuillez saisir un ID de commande valide.");
					tfIdRetourEmprunt.setText(null);
				}



				if(listEmpruntEC[Integer.parseInt(tfIdRetourEmprunt.getText())][0]!=null){
					int reponse = JOptionPane.showConfirmDialog(null,
							"Voulez-vous rendre l'emprunt : "+tfIdRetourEmprunt.getText()+" ?", "Confirmation",
							JOptionPane.YES_NO_OPTION);

					// traitement de la réponse
					switch (reponse) {
						case JOptionPane.YES_OPTION:
							listEmpruntEC[Integer.parseInt(tfIdRetourEmprunt.getText())][0]=null;
							listEmpruntEC[Integer.parseInt(tfIdRetourEmprunt.getText())][1]=null;
							listEmpruntEC[Integer.parseInt(tfIdRetourEmprunt.getText())][2]=null;
							listEmpruntEC[Integer.parseInt(tfIdRetourEmprunt.getText())][3]=null;
							listEmpruntEC[Integer.parseInt(tfIdRetourEmprunt.getText())][4]=null;
							listEmpruntEC[Integer.parseInt(tfIdRetourEmprunt.getText())][5]=null;
							tfIdRetourEmprunt.setText(null);
							break;
						case JOptionPane.NO_OPTION:
							tfIdRetourEmprunt.setText(null);
							break;
						case JOptionPane.CLOSED_OPTION:
							// ...
							break;
					}


				}
				else{
					JOptionPane.showMessageDialog(null,  "Veuillez saisir un ID de commande existant");
					tfIdRetourEmprunt.setText(null);
				}
			}


		});
		


		


	
		
		mq.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			
			{
				quitterApplication();
			}
		});
	
		
		
		
		
		/* gestion de la fenetre*/
		//fenetre.add(mb, BorderLayout.NORTH);
		fenetre.add(pnlListClient, BorderLayout.CENTER);;
		fenetre.add(pnlClient);
		fenetre.add(pnlAcceuil, BorderLayout.CENTER);
		fenetre.add(pnlLogin, BorderLayout.CENTER);
		fenetre.add(pnlBas, BorderLayout.SOUTH);

	}


	public void quitterApplication(){
		int reponse = JOptionPane.showConfirmDialog(null,
				"Voulez-vous vraiment quitter ?", null,
				JOptionPane.YES_NO_OPTION);

		// traitement de la réponse
		switch (reponse) {
			case JOptionPane.YES_OPTION:
				System.exit(0);
				break;
			case JOptionPane.NO_OPTION:
				// ...
				break;
			case JOptionPane.CLOSED_OPTION:
				// ...
				break;
		}
	}

	public void creerJeuDEssais(){
		listClient[idcl][0] = idcl;
		listClient[idcl][1] = "WAJDA";
		listClient[idcl][2] = "Adrien";
		listClient[idcl][3] = "Fidele";
		idcl++;
		listClient[idcl][0] = idcl;
		listClient[idcl][1] = "CRIQUELION";
		listClient[idcl][2] = "Julien";
		listClient[idcl][3] = "Occasionnel";
		idcl++;
		listClient[idcl][0] = idcl;
		listClient[idcl][1] = "DUPONT";
		listClient[idcl][2] = "Martin";
		listClient[idcl][3] = "Occasionnel";
		idcl++;
		listClient[idcl][0] = idcl;
		listClient[idcl][1] = "DANLMUR";
		listClient[idcl][2] = "Alphonse";
		listClient[idcl][3] = "Fidele";
		idcl++;
		listClient[idcl][0] = idcl;
		listClient[idcl][1] = "PELE";
		listClient[idcl][2] = "Sarah";
		listClient[idcl][3] = "Fidele";
		idcl++;
		listClient[idcl][0] = idcl;
		listClient[idcl][1] = "COVER";
		listClient[idcl][2] = "Harry";
		listClient[idcl][3] = "Occasionnel";
		idcl++;
		listClient[idcl][0] = idcl;
		listClient[idcl][1] = "CULAIRE";
		listClient[idcl][2] = "Laury";
		listClient[idcl][3] = "Fidele";
		idcl++;
		listClient[idcl][0] = idcl;
		listClient[idcl][1] = "TOUILLE";
		listClient[idcl][2] = "Sacha";
		listClient[idcl][3] = "Occasionnel";
		idcl++;



		/*Ajout de produits*/
		//CD
		listProduit[idprod][0]=idprod;
		listProduit[idprod][1]="CD";    		/*type*/
		listProduit[idprod][2]=12;				/*quantite*/
		listProduit[idprod][3]="Mesdames";		/*titre*/
		listProduit[idprod][4]=6;				/*tarif*/
		//listProduit[idprod][5]=;				/*realisateur*/
		listProduit[idprod][6]="2020";			/*Année Sortie*/
		//listProduit[idprod][7]=;				/*Auteur*/
		//listProduit[idprod][7]=;				/*Langue*/
		idprod++;
		listProduit[idprod][0]=idprod;
		listProduit[idprod][1]="CD";    		/*type*/
		listProduit[idprod][2]=21;				/*quantite*/
		listProduit[idprod][3]="N'attendons pas";		/*titre*/
		listProduit[idprod][4]=5;				/*tarif*/
		//listProduit[idprod][5]=;				/*realisateur*/
		listProduit[idprod][6]="2020";			/*Année Sortie*/
		//listProduit[idprod][7]=;				/*Auteur*/
		//listProduit[idprod][7]=;				/*Langue*/
		idprod++;
		listProduit[idprod][0]=idprod;
		listProduit[idprod][1]="CD";    		/*type*/
		listProduit[idprod][2]=9;				/*quantite*/
		listProduit[idprod][3]="Un air de famille";		/*titre*/
		listProduit[idprod][4]=7;				/*tarif*/
		//listProduit[idprod][5]=;				/*realisateur*/
		listProduit[idprod][6]="2020";			/*Année Sortie*/
		//listProduit[idprod][7]=;				/*Auteur*/
		//listProduit[idprod][7]=;				/*Langue*/
		idprod++;

		//DVD
		listProduit[idprod][0]=idprod;
		listProduit[idprod][1]="DVD";    				/*type*/
		listProduit[idprod][2]=20;						/*quantite*/
		listProduit[idprod][3]="Avengers Endgame";		/*titre*/
		listProduit[idprod][4]=6;						/*tarif*/
		listProduit[idprod][5]=" Joe Russo Anthony Russo ";				/*realisateur*/
		//listProduit[idprod][6]=;				/*Année Sortie*/
		//listProduit[idprod][7]=;				/*Auteur*/
		//listProduit[idprod][7]=;				/*Langue*/
		idprod++;

		listProduit[idprod][0]=idprod;
		listProduit[idprod][1]="DVD";    				/*type*/
		listProduit[idprod][2]=5;						/*quantite*/
		listProduit[idprod][3]="Harry Potter - L'intégrale 8 Films";		/*titre*/
		listProduit[idprod][4]=25;						/*tarif*/
		listProduit[idprod][5]="Chris Columbus Alfonso Cuarón Mike Newell David Yates";				/*realisateur*/
		//listProduit[idprod][6]=;				/*Année Sortie*/
		//listProduit[idprod][7]=;				/*Auteur*/
		//listProduit[idprod][7]=;				/*Langue*/
		idprod++;

		listProduit[idprod][0]=idprod;
		listProduit[idprod][1]="DVD";    				/*type*/
		listProduit[idprod][2]=21;						/*quantite*/
		listProduit[idprod][3]="Coffret intégrale la 7ème compagnie";		/*titre*/
		listProduit[idprod][4]=5;						/*tarif*/
		listProduit[idprod][5]=" Lamoureux Robert";				/*realisateur*/
		//listProduit[idprod][6]=;				/*Année Sortie*/
		//listProduit[idprod][7]=;				/*Auteur*/
		//listProduit[idprod][7]=;				/*Langue*/
		idprod++;
		// DVD

		listProduit[idprod][0]=idprod;
		listProduit[idprod][1]="DVD";                    //type/
		listProduit[idprod][2]=2;                        //quantite/
		listProduit[idprod][3]="30 Jours Max ";        //titre
		listProduit[idprod][5]="Tarek Boudali";				/*realisateur*/
		listProduit[idprod][4]=12;                        //tarif/
		idprod++;
				// roman
		listProduit[idprod][0]=idprod;
		listProduit[idprod][1]="Roman";                    //type/
		listProduit[idprod][2]=15;                        //quantite/
		listProduit[idprod][3]="Madame Bovary";        //titre/
		listProduit[idprod][4]=8;

		listProduit[idprod][7]="Flaubert";   //realisateur/

		idprod++;
		listProduit[idprod][0]=idprod;
		listProduit[idprod][1]="Roman";                    //type/
		listProduit[idprod][2]=17;                        //quantite/
		listProduit[idprod][3]="Absalon, Absalon !";        //titre/
		listProduit[idprod][4]=12;
		listProduit[idprod][7]="Faulkner";   //realisateur/
		idprod++;
				// CD
		listProduit[idprod][0]=idprod;
		listProduit[idprod][1]="CD";                    //type/
		listProduit[idprod][2]=8;                        //quantite/
		listProduit[idprod][3]="Les chemins de la Liberté";        //titre/
		listProduit[idprod][4]=15 ;
		listProduit[idprod][6]="2010";   //annee sortie/
		idprod++;
		listProduit[idprod][0]=idprod;
		listProduit[idprod][1]="CD";                    //type/
		listProduit[idprod][2]=3;                        //quantite/
		listProduit[idprod][3]="Destin ";        //titre/
		listProduit[idprod][4]=13 ;
		listProduit[idprod][6]="2019";   //annee sortie/
		idprod++;
		// BD
		listProduit[idprod][0]=idprod;
		listProduit[idprod][1]="BD";                    //type/
		listProduit[idprod][2]=78;                        //quantite/
		listProduit[idprod][3]="Tintin au Congo";        //titre/
		listProduit[idprod][4]=15 ;
		listProduit[idprod][7]="Hergé";   //realisateur/
		idprod++;
		listProduit[idprod][0]=idprod;
		listProduit[idprod][1]="Roman";                    //type/
		listProduit[idprod][2]=17;                        //quantite/
		listProduit[idprod][3]="L'Arabe du futur";        //titre/
		listProduit[idprod][4]=20 ;
		listProduit[idprod][7]="Riad Sattouf";   //realisateur/
		idprod++;
				// Manuel scolaire
		listProduit[idprod][0]=idprod;
		listProduit[idprod][1]="Manuel Scolaire";                    //type/
		listProduit[idprod][2]=149;                        //quantite/
		listProduit[idprod][3]="Histoire-Géographie-EMC 3e";        //titre/
		listProduit[idprod][4]=25 ;
		listProduit[idprod][7]="Le livre scolaire";   //realisateur/
		idprod++;
		listProduit[idprod][0]=idprod;
		listProduit[idprod][1]="Manuel Scolaire";                    //type/
		listProduit[idprod][2]=17;                        //quantite/
		listProduit[idprod][3]="Cahier Transmath 5e";        //titre/
		listProduit[idprod][4]=32 ;
		listProduit[idprod][7]="Nathan";   //realisateur/
		idprod++;
				// Dictionnaire
		listProduit[idprod][0]=idprod;
		listProduit[idprod][1]="Dictionnaire";                    //type/
		listProduit[idprod][2]=34;                        //quantite/
		listProduit[idprod][3]="mały Robert";        //titre/
		listProduit[idprod][4]=21 ;
		listProduit[idprod][8]="Polonais";   //langue/
		idprod++;
		listProduit[idprod][0]=idprod;
		listProduit[idprod][1]="Dictionnaire";                    //type/
		listProduit[idprod][2]=123;                        //quantite/
		listProduit[idprod][3]="Le petit Robert";        //titre/
		listProduit[idprod][4]=23 ;
		listProduit[idprod][8]="Francais";   //langue/
		idprod++;


		listEmpruntEC[numEmpreunt][0]= numEmpreunt ;
		listEmpruntEC[numEmpreunt][1]= 1 ;
		listEmpruntEC[numEmpreunt][2]= "30/05/2021" ;
		listEmpruntEC[numEmpreunt][3]= "31/05/2021" ;
		listEmpruntEC[numEmpreunt][4]= "1" ;
		listEmpruntEC[numEmpreunt][5]= 5.0 ;
		listEmpruntTout[numEmpreunt][0]= numEmpreunt ;
		listEmpruntTout[numEmpreunt][1]= 1 ;
		listEmpruntTout[numEmpreunt][2]= "30/05/2021" ;
		listEmpruntTout[numEmpreunt][3]= "31/05/2021" ;
		listEmpruntTout[numEmpreunt][4]= "1" ;
		listEmpruntTout[numEmpreunt][5]= 5.0 ;
		numEmpreunt++;

		listEmpruntEC[numEmpreunt][0]= numEmpreunt;
		listEmpruntEC[numEmpreunt][1]= 2 ;
		listEmpruntEC[numEmpreunt][2]= "02/06/2021" ;
		listEmpruntEC[numEmpreunt][3]= "11/06/2021" ;
		listEmpruntEC[numEmpreunt][4]= "12" ;
		listEmpruntEC[numEmpreunt][5]= 20.0 ;
		listEmpruntTout[numEmpreunt][0]= numEmpreunt;
		listEmpruntTout[numEmpreunt][1]= 2 ;
		listEmpruntTout[numEmpreunt][2]= "02/06/2021" ;
		listEmpruntTout[numEmpreunt][3]= "11/06/2021" ;
		listEmpruntTout[numEmpreunt][4]= "12" ;
		listEmpruntTout[numEmpreunt][5]= 20.0 ;
		numEmpreunt++;

		listEmpruntEC[numEmpreunt][0]= numEmpreunt;
		listEmpruntEC[numEmpreunt][1]= 3 ;
		listEmpruntEC[numEmpreunt][2]= "15/07/2021" ;
		listEmpruntEC[numEmpreunt][3]= "17/07/2021" ;
		listEmpruntEC[numEmpreunt][4]= "16" ;
		listEmpruntEC[numEmpreunt][5]= 20.7 ;
		listEmpruntTout[numEmpreunt][0]= numEmpreunt;
		listEmpruntTout[numEmpreunt][1]= 3 ;
		listEmpruntTout[numEmpreunt][2]= "15/07/2021" ;
		listEmpruntTout[numEmpreunt][3]= "17/07/2021" ;
		listEmpruntTout[numEmpreunt][4]= "16" ;
		listEmpruntTout[numEmpreunt][5]= 20.7 ;
		numEmpreunt++;

		listEmpruntEC[numEmpreunt][0]= numEmpreunt ;
		listEmpruntEC[numEmpreunt][1]= 4 ;
		listEmpruntEC[numEmpreunt][2]= "28/05/2021" ;
		listEmpruntEC[numEmpreunt][3]= "01/06/2021" ;
		listEmpruntEC[numEmpreunt][4]= "6" ;
		listEmpruntEC[numEmpreunt][5]= 10.8 ;
		listEmpruntTout[numEmpreunt][0]= numEmpreunt ;
		listEmpruntTout[numEmpreunt][1]= 4 ;
		listEmpruntTout[numEmpreunt][2]= "28/05/2021" ;
		listEmpruntTout[numEmpreunt][3]= "01/06/2021" ;
		listEmpruntTout[numEmpreunt][4]= "6" ;
		listEmpruntTout[numEmpreunt][5]= 10.8 ;
		numEmpreunt++;

		listEmpruntEC[numEmpreunt][0]= numEmpreunt ;
		listEmpruntEC[numEmpreunt][1]= 5 ;
		listEmpruntEC[numEmpreunt][2]= "17/08/2021" ;
		listEmpruntEC[numEmpreunt][3]= "25/08/2021" ;
		listEmpruntEC[numEmpreunt][4]= "10" ;
		listEmpruntEC[numEmpreunt][5]= 13.0 ;
		listEmpruntTout[numEmpreunt][0]= numEmpreunt ;
		listEmpruntTout[numEmpreunt][1]= 5 ;
		listEmpruntTout[numEmpreunt][2]= "17/08/2021" ;
		listEmpruntTout[numEmpreunt][3]= "25/08/2021" ;
		listEmpruntTout[numEmpreunt][4]= "10" ;
		listEmpruntTout[numEmpreunt][5]= 13.0 ;
		numEmpreunt++;

		listEmpruntEC[numEmpreunt][0]= numEmpreunt ;
		listEmpruntEC[numEmpreunt][1]= 6 ;
		listEmpruntEC[numEmpreunt][2]= "09/09/2021" ;
		listEmpruntEC[numEmpreunt][3]= "31/09/2021" ;
		listEmpruntEC[numEmpreunt][4]= " 11 6 " ;
		listEmpruntEC[numEmpreunt][5]= 24.3 ;
		listEmpruntTout[numEmpreunt][0]= numEmpreunt ;
		listEmpruntTout[numEmpreunt][1]= 6 ;
		listEmpruntTout[numEmpreunt][2]= "09/09/2021" ;
		listEmpruntTout[numEmpreunt][3]= "31/09/2021" ;
		listEmpruntTout[numEmpreunt][4]= " 11 6 " ;
		listEmpruntTout[numEmpreunt][5]= 24.3 ;
		numEmpreunt++;

		listEmpruntEC[numEmpreunt][0]= numEmpreunt ;
		listEmpruntEC[numEmpreunt][1]= 7 ;
		listEmpruntEC[numEmpreunt][2]= "02/10/2021" ;
		listEmpruntEC[numEmpreunt][3]= "15/10/2021" ;
		listEmpruntEC[numEmpreunt][4]= " 2 13 " ;
		listEmpruntEC[numEmpreunt][5]= "32.0" ;
		listEmpruntTout[numEmpreunt][0]= numEmpreunt ;
		listEmpruntTout[numEmpreunt][1]= 7 ;
		listEmpruntTout[numEmpreunt][2]= "02/10/2021" ;
		listEmpruntTout[numEmpreunt][3]= "15/10/2021" ;
		listEmpruntTout[numEmpreunt][4]= " 2 13 " ;
		listEmpruntTout[numEmpreunt][5]= "32.0" ;
		numEmpreunt++;

		listEmpruntEC[numEmpreunt][0]=numEmpreunt ;
		listEmpruntEC[numEmpreunt][1]= 0 ;
		listEmpruntEC[numEmpreunt][2]= "13/07/2021" ;
		listEmpruntEC[numEmpreunt][3]= "14/07/2021" ;
		listEmpruntEC[numEmpreunt][4]= " 4 10 " ;
		listEmpruntEC[numEmpreunt][5]= 34.2 ;
		listEmpruntTout[numEmpreunt][0]=numEmpreunt ;
		listEmpruntTout[numEmpreunt][1]= 0 ;
		listEmpruntTout[numEmpreunt][2]= "13/07/2021" ;
		listEmpruntTout[numEmpreunt][3]= "14/07/2021" ;
		listEmpruntTout[numEmpreunt][4]= " 4 10 " ;
		listEmpruntTout[numEmpreunt][5]= 34.2 ;
		numEmpreunt++;

		listEmpruntEC[numEmpreunt][0]= numEmpreunt ;
		listEmpruntEC[numEmpreunt][1]= 4 ;
		listEmpruntEC[numEmpreunt][2]= "29/05/2021" ;
		listEmpruntEC[numEmpreunt][3]= "29/06/2021" ;
		listEmpruntEC[numEmpreunt][4]= " 12 14 15 " ;
		listEmpruntEC[numEmpreunt][5]= 65.7 ;
		listEmpruntTout[numEmpreunt][0]= numEmpreunt ;
		listEmpruntTout[numEmpreunt][1]= 4 ;
		listEmpruntTout[numEmpreunt][2]= "29/05/2021" ;
		listEmpruntTout[numEmpreunt][3]= "29/06/2021" ;
		listEmpruntTout[numEmpreunt][4]= " 12 14 15 " ;
		listEmpruntTout[numEmpreunt][5]= 65.7 ;
		numEmpreunt++;

		listEmpruntEC[numEmpreunt][0]=numEmpreunt;
		listEmpruntEC[numEmpreunt][1]= 5 ;
		listEmpruntEC[numEmpreunt][2]= "30/11/2021" ;
		listEmpruntEC[numEmpreunt][3]= "06/12/2021" ;
		listEmpruntEC[numEmpreunt][4]= " 2 7 " ;
		listEmpruntEC[numEmpreunt][5]= 40.0 ;
		listEmpruntTout[numEmpreunt][0]=numEmpreunt;
		listEmpruntTout[numEmpreunt][1]= 5 ;
		listEmpruntTout[numEmpreunt][2]= "30/11/2021" ;
		listEmpruntTout[numEmpreunt][3]= "06/12/2021" ;
		listEmpruntTout[numEmpreunt][4]= " 2 7 " ;
		listEmpruntTout[numEmpreunt][5]= 40.0 ;
		numEmpreunt++;





	}
	

		

	public static void main(String[] args) {
		Videotheque monInterface = new Videotheque();
		fenetre.setVisible(true);
	}

}




/*listProduit[idprod][2]=Integer.parseInt(listProduit[idprod][2].toString())-1;*/