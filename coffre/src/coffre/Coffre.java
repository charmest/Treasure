package coffre;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Thomas CHARMES
 *
 */
public class Coffre implements I_CoffreChateau {
	
	private Etat etat;
	private boolean chienLibere;
	private boolean lapinLibere;
	private List<IFenetres> fenetres = new ArrayList<IFenetres>();
	
	public Coffre() {
		chienLibere = false;
		lapinLibere = false;
		setEtat(new CacheParBibliotheque());
	}

	public void libererLapinTueur() {
		lapinLibere = true;
	}
	
	public void libererChienGentil() {
		chienLibere = true;
	}
	
	public void recupererChienGentil() {
		chienLibere = false;
	}
	
	@Override
	public void oterLivre() {
		etat.oterLivre(this);
		avertir();
	}

	@Override
	public void remettreLivre() {
		etat.remettreLivre(this);
		avertir();
	}

	@Override
	public void tournerChandelleVersDroite() {
		etat.tournerChandelleVersDroite(this);
		avertir();
	}

	@Override
	public void tournerChandelleVersGauche() {
		etat.tournerChandelleVersGauche(this);
		avertir();
	}

	@Override
	public void fermerCoffre() {
		etat.fermerCoffre(this);
		avertir();
	}

	@Override
	public boolean lapinEstLibere() {
		return this.lapinLibere;
	}

	@Override
	public boolean chienEstLibere() {
		return this.chienLibere;
	}

	@Override
	public String nomEtat() {
		return etat.nomEtat();
	}
	
	public void setEtat(Etat nouvelEtat) {
		etat = nouvelEtat;
		avertir();
	}
	
	public void attacher(IFenetres fenetre) {
		fenetres.add(fenetre);
		avertir();
	}
	
	private void avertir() {
		for (IFenetres fenetre : fenetres)
			fenetre.MAJ(this);
	}

	@Override
	public boolean peutOterLivreUML() {
		return etat.peutOterLivreUML();
	}

	@Override
	public boolean peutTournerChandelleVersDroite() {
		return etat.peutTournerChandelleVersDroite();
	}

	@Override
	public boolean peutTournerChandelleVersGauche() {
		return etat.peutTournerChandelleVersGauche();
	}

	@Override
	public boolean peutFermerCoffre() {
		return etat.peutFermerCoffre();
	}

	@Override
	public boolean peutRemettreLivreUML() {
		return etat.peutRemettreLivreUML();
	}

}
