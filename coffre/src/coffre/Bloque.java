package coffre;

/**
 * 
 * @author Thomas CHARMES
 *
 */
public class Bloque implements Etat {
	
	private static Etat instance;
	
	protected Bloque() {}
	
	public static Etat getInstance() {
		if(instance == null)
			instance = new Bloque();
		return instance;
	}

	@Override
	public String nomEtat() {
		return "Bloque";
	}

	@Override
	public void oterLivre(Coffre coffre) {}
	@Override
	public void remettreLivre(Coffre coffre) {}
	@Override
	public void tournerChandelleVersDroite(Coffre coffre) {}
	@Override
	public void tournerChandelleVersGauche(Coffre coffre) {}
	@Override
	public void fermerCoffre(Coffre coffre) {}

}
