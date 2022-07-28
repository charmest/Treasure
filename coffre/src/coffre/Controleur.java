package coffre;

/**
 * 
 * @author Thomas CHARMES
 *
 */
public class Controleur implements IControleur {
	
	private Coffre leModele;

	public Controleur() {
		leModele = new Coffre();
		leModele.attacher(new FenetreChateauMedieval(this));
		leModele.attacher(new FenetreChienGentil());
		leModele.attacher(new FenetreEtat());
		leModele.attacher(new FenetreLapinTueur());
	}
	
	@Override
	public void oterLivre() {
		leModele.oterLivre();
	}

	@Override
	public void remettreLivre() {
		leModele.remettreLivre();
	}

	@Override
	public void tournerChandelleVersDroite() {
		leModele.tournerChandelleVersDroite();
	}

	@Override
	public void tournerChandelleVersGauche() {
		leModele.tournerChandelleVersGauche();
	}

	@Override
	public void fermerCoffre() {
		leModele.fermerCoffre();
	}
	
	@Override
	public String toString() {
		return "LE JEU PEUT COMMENCER !!!";
	}

	public static void main(String[] args) {
		Controleur c = new Controleur();
	}
	
}
