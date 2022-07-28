package coffre;

import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author Thomas CHARMES
 *
 */
public class FenetreLapinTueur extends JFrame implements IFenetres {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtLapin;

	public FenetreLapinTueur()
	{
		setTitle("Lapin du Chateau Médiéval");
		setBounds(700,500,190,130);
		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		JLabel labLapin = new JLabel ("LAPIN TUEUR");
		contentPane.add(labLapin);
		txtLapin = new JTextField(15);
		contentPane.add(txtLapin);
		setVisible(true);
		afficherLapin(false);
	}
	
	public void afficherLapin(boolean libre)
	{
		if (libre == true)
			txtLapin.setText("Le lapin tueur est libéré");
		else 
			txtLapin.setText("Le lapin tueur est enfermé");
	}

	@Override
	public void MAJ(I_CoffreChateau coffre) {
		afficherLapin(coffre.lapinEstLibere());
	}
}