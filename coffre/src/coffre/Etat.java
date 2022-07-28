package coffre;

/**
 * 
 * @author Thomas CHARMES
 *
 */
public interface Etat {

	public abstract String nomEtat();

	public abstract void oterLivre(Coffre coffre);
	
	public abstract void remettreLivre(Coffre coffre);

	public abstract void tournerChandelleVersDroite(Coffre coffre);

	public abstract void tournerChandelleVersGauche(Coffre coffre);

	public abstract void fermerCoffre(Coffre coffre);
	
	public default boolean peutOterLivreUML() {
		return false;
	}
	
	public default boolean peutTournerChandelleVersDroite() {
		return false;
	}
	
	public default boolean peutTournerChandelleVersGauche() {
		return false;
	}
	
	public default boolean peutFermerCoffre() {
		return false;
	}
	
	public default boolean peutRemettreLivreUML() {
		return false;
	}

}
