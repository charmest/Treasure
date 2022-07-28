package coffre;

/**
 * 
 * @author Thomas CHARMES
 *
 */
public abstract class Visible implements Etat {

	@Override
	public void tournerChandelleVersGauche(Coffre coffre) {
		coffre.setEtat(new Bloque());
		coffre.libererLapinTueur();
	}
	
	@Override
	public void remettreLivre(Coffre coffre) {
		coffre.setEtat(new CacheParBibliotheque());
		coffre.recupererChienGentil();
	}
	
	@Override
	public boolean peutRemettreLivreUML() {
		return true;
	}
	
	@Override
	public boolean peutTournerChandelleVersDroite() {
		return true;
	}
	
	@Override
	public boolean peutTournerChandelleVersGauche() {
		return true;
	}

}