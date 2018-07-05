package fr.eni.clinique.ihm;


import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import fr.eni.clinique.ihm.login.EcranLoginController;

public class MainFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JDesktopPane desktopPane;
	private JMenuBar menuBarre;
	private JMenuItem menuAgenda;
	private JMenuItem menuGestionClient;
	private JMenuItem menuPriseRdv;
	private JMenuItem menuGestionPersonnel;
	private JMenu menu2;



	public MainFrame() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, 1200, 800);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/fr/eni/clinique/ihm/img/ico_veto.png")));

		// initialiser l'ecran MDI
		desktopPane = new JDesktopPane();
		setContentPane(getDesktopPane());

		// Barre de menus
		setJMenuBar(getMenuBarre());
		
		//Frame interne exemple		
		//desktopPane.add(getClient());
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		
	}

	public void createMenuBar() {

		// Menu Fichier
		JMenu menu = new JMenu("Fichier");
		menu2 = new JMenu("Gestion des rendez-vous");
		menuBarre.add(menu);
		menuBarre.add(menu2);
		// Sous menu Déconnexion
		JMenuItem menuItem = new JMenuItem("D�connexion");
		menuItem.setActionCommand("deconnexion");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		// Sous menu fermer
		menuItem = new JMenuItem("Fermer");
		menuItem.setActionCommand("fermer");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		// Menu Gestion des rendez-vous
		menuPriseRdv = new JMenuItem("Prise de rendez-vous");		
		menuPriseRdv.setActionCommand("prise de rendez-vous");
		menuPriseRdv.addActionListener(this);
		menu2.add(menuPriseRdv);
		
		menuGestionClient = new JMenuItem("Gestion des clients");	
		menuGestionClient.setActionCommand("gestion des clients");
		menuGestionClient.addActionListener(this);
		menu2.add(menuGestionClient);
		// Menu Agenda
		menuAgenda= new JMenuItem("Agenda");
		menuBarre.add(menuAgenda);		
		menuAgenda.setActionCommand("agenda");
		menuAgenda.addActionListener(this);
		
		menuGestionPersonnel = new JMenuItem("Gestion du personnel");
		menuBarre.add(menuGestionPersonnel);		
		menuGestionPersonnel.setActionCommand("gestion du personnel");
		menuGestionPersonnel.addActionListener(this);

		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(500, 200, 170, 170);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(MainFrame.class.getResource("/fr/eni/clinique/ihm/img/fond_frame.jpg")));
		getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("Clinique v\u00E9t\u00E9rinaire");
		label.setHorizontalTextPosition(SwingConstants.LEFT);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Arial", Font.BOLD, 20));
		label.setBounds(500, 100, 182, 24);
		getContentPane().add(label);
	}

	// Réagir aux clicks sur les menus
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "deconnexion":
			EcranLoginController.get().startApp();
			System.out.println("Deconnexion");
			setVisible(false);
			break;
		case "fermer":
			System.exit(0);
			break;
		case "prise de rendez-vous":
			desktopPane.removeAll();
			MainFrameController.get().gestionRdv();
			break;
		case "gestion des clients":
			desktopPane.removeAll();
			MainFrameController.get().gestionClient();
			break;	
		case "gestion du personnel":
			desktopPane.removeAll();
			MainFrameController.get().gestionPersonnel();
			System.out.println("Ouverture frame gestion du personnel");
			break;
		case "agenda":
			System.err.println("Ouverture page agenda");
			break;
		default:
			System.out.println("Probleme e=" + e);
		}

	}

	public JDesktopPane getDesktopPane() {
		return desktopPane;
	}

	public JMenuBar getMenuBarre() {
		if (menuBarre == null) {
			menuBarre = new JMenuBar();

			createMenuBar();
		}
		return menuBarre;
	}

	public JMenuItem getMenuAgenda(){
		if (menuAgenda == null) {
			menuAgenda= new JMenuItem();
		}
		return menuAgenda;
	}
	public JMenuItem getmenuGestionClient(){
		return menuGestionClient;
	}
	public JMenuItem getmenuPriseRdv(){
		return menuPriseRdv;
	}
	public JMenuItem getmenuGestionPersonnel(){
		if(menuGestionPersonnel == null){
			menuGestionPersonnel = new JMenuItem();
		}
		return menuGestionPersonnel;
	}
	public JMenu getMenuGestionRdv(){
		if(menu2 == null){
			menu2 = new JMenu();
		}
		return menu2;
	}
}
