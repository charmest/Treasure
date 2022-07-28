package coffre;

/**
 * 
 * @author Thomas CHARMES
 *
 */
public class CacheParBibliotheque implements Etat {
	
	private static Etat instance;
	
	protected CacheParBibliotheque() {}
	
	public static Etat getInstance() {
		
		if(instance == null)
			instance = new CacheParBibliotheque();
		return instance;
	}

	@Override
	public String nomEtat() {
		return "CacheParBibliotheque";
	}

	@Override
	public void oterLivre(Coffre coffre) {
		coffre.setEtat(new Ferme());
		
	}
	
	@Override
	public boolean peutOterLivreUML() {
		return true;
	}

	@Override
	public void remettreLivre(Coffre coffre) {}
	@Override
	public void tournerChandelleVersDroite(Coffre coffre) {}
	@Override
	public void tournerChandelleVersGauche(Coffre coffre) {}
	@Override
	public void fermerCoffre(Coffre coffre) {}

}
