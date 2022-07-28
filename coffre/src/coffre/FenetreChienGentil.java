package coffre;

import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author Thomas CHARMES
 *
 */
public class FenetreChienGentil extends JFrame implements IFenetres {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtChien;

	public FenetreChienGentil()
	{
		setTitle("Chien du Chateau Médiéval");
		setBounds(300,500,190,130);
		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		JLabel labChien = new JLabel ("CHIEN GENTIL");
		contentPane.add(labChien);
		txtChien = new JTextField(15);
		contentPane.add(txtChien);
		setVisible(true);
		afficherChien(false);
	}
	
	public void afficherChien(boolean libre)
	{
		if (libre == true)
			txtChien.setText("Le chien gentil est libéré");
		else 
			txtChien.setText("Le chien gentil est enfermé");
	}

	@Override
	public void MAJ(I_CoffreChateau coffre) {
		afficherChien(coffre.chienEstLibere());
	}
}