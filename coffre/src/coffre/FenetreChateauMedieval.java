package coffre;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * 
 * @author Thomas CHARMES
 *
 */
public class FenetreChateauMedieval extends JFrame implements ActionListener,
WindowListener, IFenetres {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btOterLivre;
	private JButton btRemettreLivre;
	private JButton btTournerGauche;
	private JButton btTournerDroite;
	private JButton btFermerCoffre;
	private JButton btQuitter;
	private IControleur ctr;


	public FenetreChateauMedieval(IControleur ctr) {
		this.ctr = ctr;
		setTitle("Projet Chateau Médiéval");
		setBounds(500, 100, 400, 200);
		JPanel panBibliotheque = new JPanel();
		JPanel panCentre = new JPanel();
		JPanel panChandelle = new JPanel();
		JPanel panctr = new JPanel();
		JPanel panQuitter = new JPanel();
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		btOterLivre = new JButton("Oter livre UML");
		btRemettreLivre = new JButton("Remettre livre UML");
		btTournerGauche = new JButton("Tourner chandelle gauche");
		btTournerDroite = new JButton("Tourner chandelle droite");
		btFermerCoffre = new JButton("Fermer coffre");
		btQuitter = new JButton("Quitter");
		panBibliotheque.add(btOterLivre);
		panBibliotheque.add(btRemettreLivre); 
		panChandelle.add(btTournerGauche);
		panChandelle.add(btTournerDroite); 
		panctr.add(btFermerCoffre);  
		panQuitter.add(btQuitter);

		panCentre.add(panChandelle, "North");
		panCentre.add(panctr, "South");			
		contentPane.add(panBibliotheque, "North");
		contentPane.add(panCentre);
		contentPane.add(panQuitter, "South");

		btOterLivre.addActionListener(this);
		btRemettreLivre.addActionListener(this);
		btTournerGauche.addActionListener(this);
		btTournerDroite.addActionListener(this);
		btFermerCoffre.addActionListener(this);
		btQuitter.addActionListener(this);

		addWindowListener(this);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btOterLivre)
			ctr.oterLivre();
		if (e.getSource() == btRemettreLivre)
			ctr.remettreLivre();
		if (e.getSource() == btTournerGauche)
			ctr.tournerChandelleVersGauche();
		if (e.getSource() == btTournerDroite)
			ctr.tournerChandelleVersDroite();
		if (e.getSource() == btFermerCoffre)
			ctr.fermerCoffre();
		if (e.getSource() == btQuitter)
		{
			System.out.println("Vous venez d'appuyer sur le bouton Quitter");				;
			System.exit(0);
		}	
	}

	public void windowClosing(WindowEvent arg0) {
		System.out.println("terminer");
		System.exit(0);
	}

	public void windowActivated(WindowEvent arg0) {}
	public void windowClosed(WindowEvent arg0) {}
	public void windowDeactivated(WindowEvent arg0) {}
	public void windowDeiconified(WindowEvent arg0) {}
	public void windowIconified(WindowEvent arg0) {}
	public void windowOpened(WindowEvent arg0) {}


	public void MAJ(I_CoffreChateau coffre) {
		btFermerCoffre.setVisible(coffre.peutFermerCoffre());
		btOterLivre.setVisible(coffre.peutOterLivreUML());
		btRemettreLivre.setVisible(coffre.peutRemettreLivreUML());
		btTournerDroite.setVisible(coffre.peutTournerChandelleVersDroite());
		btTournerGauche.setVisible(coffre.peutTournerChandelleVersGauche());
	}
}
