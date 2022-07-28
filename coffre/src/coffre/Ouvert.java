package coffre;

/**
 * 
 * @author Thomas CHARMES
 *
 */
public class Ouvert implements Etat {
	
	private static Etat instance;
	
	protected Ouvert() {}
	
	public static Etat getInstance() {
		if(instance == null)
			instance = new Ouvert();
		return instance;
	}
	
	@Override
	public void fermerCoffre(Coffre coffre) {
		coffre.setEtat(new Ferme());
	}

	@Override
	public String nomEtat() {
		return "Ouvert";
	}
	
	@Override
	public boolean peutFermerCoffre() {
		return true;
	}

	@Override
	public void oterLivre(Coffre coffre) {}
	@Override
	public void remettreLivre(Coffre coffre) {}
	@Override
	public void tournerChandelleVersDroite(Coffre coffre) {}
	@Override
	public void tournerChandelleVersGauche(Coffre coffre) {}
}
