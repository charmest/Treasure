package coffre;

import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author Thomas CHARMES
 *
 */
public class FenetreEtat extends JFrame implements IFenetres {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtEtat;

	public FenetreEtat()
	{
		setTitle("Coffre");
		setBounds(500,500,190,130);
		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		JLabel labEtat = new JLabel("COFFRE");
		contentPane.add(labEtat);
		txtEtat = new JTextField(15);
		contentPane.add(txtEtat);
		setVisible(true);
		afficherEtat("pas d'état");
	}
	
	public void afficherEtat(String etat)
	{
		txtEtat.setText(etat);
	}

	@Override
	public void MAJ(I_CoffreChateau coffre) {
		afficherEtat(coffre.nomEtat());
	}
}