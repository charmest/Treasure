package coffre;

/**
 * 
 * @author Thomas CHARMES
 *
 */
public class PresqueOuvert extends Visible {
	
    private static Etat instance;
	
	protected PresqueOuvert() {}
	
	public static Etat getInstance() {
		if(instance == null)
			instance = new PresqueOuvert();
		return instance;
	}

	@Override
	public void tournerChandelleVersDroite(Coffre coffre) {
		coffre.setEtat(new Ouvert());
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
		return "PresqueOuvert";
	}
	
	@Override
	public void oterLivre(Coffre coffre) {}
	@Override
	public void fermerCoffre(Coffre coffre) {}
}
