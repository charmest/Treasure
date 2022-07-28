package coffre;

/**
 * 
 * @author Thomas CHARMES
 *
 */
public class Ferme extends Visible {
	
private static Etat instance;
	
	protected Ferme() {}
	
	public static Etat getInstance() {
		if(instance == null)
			instance = new Ferme();
		return instance;
	}

	@Override
	public void tournerChandelleVersDroite(Coffre coffre) {
		coffre.setEtat(new PresqueOuvert());
		coffre.libererChienGentil();
	}
	
	@Override
	public void tournerChandelleVersGauche(Coffre coffre) {
		super.tournerChandelleVersGauche(coffre);
	}
	
	@Override
	public void remettreLivre(Coffre coffre) {
		super.remettreLivre(coffre);
	}

	@Override
	public String nomEtat() {
		return "Ferme";
	}

	@Override
	public void oterLivre(Coffre coffre) {}
	@Override
	public void fermerCoffre(Coffre coffre) {}
		
}
