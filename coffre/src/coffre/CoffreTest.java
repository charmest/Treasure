package coffre;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Thomas CHARMES
 *
 */
public class CoffreTest {
	
	private I_CoffreChateau coffre;

	@Before
	public void setUp() throws Exception {
		coffre = new Coffre();
	}
	@After
	public void tearDown() throws Exception {
	}
	
	// TESTS DE BASE 
	
	// DEMARRAGE
	@Test
	public void testDemarrageCoffreCacheParBibliotheque() {
		assertEquals("CacheParBibliotheque",coffre.nomEtat());
	}
	@Test
	public void testDemarrageLapinTueurEnferme() {
		assertFalse(coffre.lapinEstLibere());
	}
	@Test
	public void testDemarrageChienGentilEnferme() {
		assertFalse(coffre.chienEstLibere());
	}
	@Test
	public void testCoffreCacheParBibliothequeApresAvoirRemisLeLivreDansLaBibliothequeSansAvoirTouchePrealablementALaChandelle() {
		coffre.oterLivre();
		coffre.remettreLivre();
		assertEquals("CacheParBibliotheque",coffre.nomEtat());
	}
	@Test
	public void testChienGentilEnfermeApresAvoirRemisLeLivreDansLaBibliothequeSansAvoirTouchePrealablementALaChandelle() {
		coffre.oterLivre();
		coffre.remettreLivre();
		assertFalse(coffre.chienEstLibere());
	}
	@Test
	public void testLapinTueurEnfermeApresAvoirRemisLeLivreDansLaBibliothequeSansAvoirTouchePrealablementALaChandelle() {
		coffre.oterLivre();
		coffre.remettreLivre();
		assertFalse(coffre.lapinEstLibere());
	}
	@Test
	public void testCoffreCacheParBibliothequeApresAvoirRemisLeLivreDansLaBibliothequeEnAyantTournePrealablementLaChandelleVersLaDroite() {
		coffre.oterLivre();
		coffre.tournerChandelleVersDroite();
		coffre.remettreLivre();
		assertEquals("CacheParBibliotheque",coffre.nomEtat());
	}
	@Test
	public void testCoffreCacheParBibliothequeApresAvoirRemisLeLivreDansLaBibliothequeEnAyantTournePrealablementLaChandelleVersLaDroiteDeuxFoisEtFermeLeCoffre() {
		coffre.oterLivre();
		coffre.tournerChandelleVersDroite();
		coffre.tournerChandelleVersDroite();
		coffre.fermerCoffre();
		coffre.remettreLivre();
		assertEquals("CacheParBibliotheque",coffre.nomEtat());
	}
	@Test
	public void testChienGentilEnfermeApresAvoirRemisLeLivreDansLaBibliothequeEnAyantTournePrealablementLaChandelleVersLaDroite() {
		coffre.oterLivre();
		coffre.tournerChandelleVersDroite();
		coffre.remettreLivre();
		assertFalse(coffre.chienEstLibere());
	}
	@Test
	public void testLapinTueurEnfermeApresAvoirRemisLeLivreDansLaBibliothequeEnAyantTournePrealablementLaChandelleVersLaDroite() {
		coffre.oterLivre();
		coffre.tournerChandelleVersDroite();
		coffre.remettreLivre();
		assertFalse(coffre.lapinEstLibere());
	}
	
	// COFFRE FERME
	@Test
	public void testCoffreFermeApresAvoirOteLeLivreDeLaBibliotheque() {
		coffre.oterLivre();
		assertEquals("Ferme",coffre.nomEtat());
	}
	@Test
	public void testLapinTueurEnfermeApresAvoirOteLeLivreDeLaBibliotheque() {
		coffre.oterLivre();
		assertFalse(coffre.lapinEstLibere());
	}
	@Test
	public void testChienGentilEnfermeApresAvoirOteLeLivreDeLaBibliotheque() {
		coffre.oterLivre();
		assertFalse(coffre.chienEstLibere());
	}
	@Test
	public void testCoffreFermeApresAvoirFermeLeCoffre() {
		coffre.oterLivre();
		coffre.tournerChandelleVersDroite();
		coffre.tournerChandelleVersDroite();
		coffre.fermerCoffre();
		assertEquals("Ferme",coffre.nomEtat());
	}
	@Test
	public void testChienLibereApresAvoirFermeLeCoffre() {
		coffre.oterLivre();
		coffre.tournerChandelleVersDroite();
		coffre.tournerChandelleVersDroite();
		coffre.fermerCoffre();
		assertTrue(coffre.chienEstLibere());
	}
	
	// COFFRE PRESQUE OUVERT
	@Test
	public void testCoffrePresqueOuvertApresAvoirTourneChandelleVersDroiteAlorsQuIlEtaitFerme() {
		coffre.oterLivre();
		coffre.tournerChandelleVersDroite();
		assertEquals("PresqueOuvert",coffre.nomEtat());
	}
	@Test
	public void testLapinTueurEnfermeAlorsQueCoffrePresqueOuvert() {
		coffre.oterLivre();
		coffre.tournerChandelleVersDroite();
		assertFalse(coffre.lapinEstLibere());
	}
	@Test
	public void testChienGentilLibereAlorsQueCoffrePresqueOuvert() {
		coffre.oterLivre();
		coffre.tournerChandelleVersDroite();
		assertTrue(coffre.chienEstLibere());
	}
	
	// COFFRE BLOQUE
	@Test
	public void testCoffreBloqueApresAvoirTourneChandelleVersGaucheDepuisFerme() {
		coffre.oterLivre();
		coffre.tournerChandelleVersGauche();
		assertEquals("Bloque",coffre.nomEtat());
	}
	@Test
	public void testCoffreBloqueApresAvoirTourneChandelleVersGaucheDepuisPresqueOuvert() {
		coffre.oterLivre();
		coffre.tournerChandelleVersDroite();
		coffre.tournerChandelleVersGauche();
		assertEquals("Bloque",coffre.nomEtat());
	}
	@Test
	public void testLapinTueurLibereAlorsQueCoffreBloqueApresAvoirTourneChandelleVersGaucheDepuisFerme() {
		coffre.oterLivre();
		coffre.tournerChandelleVersGauche();
		assertTrue(coffre.lapinEstLibere());
	}
	@Test
	public void testLapinTueurLibereAlorsQueCoffreBloqueApresAvoirTourneChandelleVersGaucheDepuisPresqueOuvert() {
		coffre.oterLivre();
		coffre.tournerChandelleVersDroite();
		coffre.tournerChandelleVersGauche();
		assertTrue(coffre.lapinEstLibere());
	}
	@Test
	public void testChienGentilEnfermeAlorsQueCoffreBloqueApresAvoirTourneChandelleVersGaucheDepuisFerme() {
		coffre.oterLivre();
		coffre.tournerChandelleVersGauche();
		assertFalse(coffre.chienEstLibere());
	}
	@Test
	public void testChienGentilLibereAlorsQueCoffreBloqueApresAvoirTourneChandelleVersGaucheDepuisPresqueOuvert() {
		coffre.oterLivre();
		coffre.tournerChandelleVersDroite();
		assertTrue(coffre.chienEstLibere());
	}
	
	// COFFRE OUVERT
	@Test
	public void testCoffreOuvertApresAvoirEtePresqueOuvert() {
		coffre.oterLivre();
		coffre.tournerChandelleVersDroite();
		coffre.tournerChandelleVersDroite();
		assertEquals("Ouvert",coffre.nomEtat());
	}
	@Test
	public void testChienGentilLibereAlorsQueCoffreOuvert() {
		coffre.oterLivre();
		coffre.tournerChandelleVersDroite();
		coffre.tournerChandelleVersDroite();
		assertTrue(coffre.chienEstLibere());
	}
	@Test
	public void testLapinTueurEnfermeAlorsQueCoffreOuvert() {
		coffre.oterLivre();
		coffre.tournerChandelleVersDroite();
		coffre.tournerChandelleVersDroite();
		assertFalse(coffre.lapinEstLibere());
	}
	
	// TEST RECUPERATION DU CHIEN 
	
	@Test
	public void testRecuperationChienGentilApresAvoirRemisLivre() {
		coffre.oterLivre();
		coffre.tournerChandelleVersDroite();
		coffre.tournerChandelleVersDroite();
		coffre.fermerCoffre();
		coffre.remettreLivre();
		assertFalse(coffre.chienEstLibere());
	}
	
	// TESTS METHODES APPELEES AU MAUVAIS ENDROIT
	
	@Test
	public void testLapinEnfermeApresAvoirTourneLaChandelleVersLaGaucheAuDemarrage() {
		coffre.tournerChandelleVersGauche();
		assertEquals("CacheParBibliotheque", coffre.nomEtat());
		assertFalse(coffre.lapinEstLibere());
	}
	@Test
	public void testCoffreBloqueEtLapinTueurEtChienGentilLiberesApresAvoirTourneLaChandelleVersLaDroitePuisVersLaGaucheAlorsQueLeCoffreEtaitFerme() {
		coffre.oterLivre();
		coffre.tournerChandelleVersDroite();
		coffre.tournerChandelleVersGauche();
		assertEquals("Bloque", coffre.nomEtat());
		assertTrue(coffre.chienEstLibere());
		assertTrue(coffre.lapinEstLibere());
	}
	@Test
	public void testCoffreToujoursBloqueEtLapinLibereQuandOnTourneLaChandelleVersLaDroiteAlorsQueCoffreBloqueApresAvoirEteFerme() {
		coffre.oterLivre();
		coffre.tournerChandelleVersGauche();
		coffre.tournerChandelleVersDroite();
		assertEquals("Bloque", coffre.nomEtat());
		assertTrue(coffre.lapinEstLibere());
	}
	@Test
	public void testCoffreToujoursBloqueEtLapinLibereQuandOnTourneLaChandelleVersLaGaucheAlorsQueCoffreBloqueApresAvoirEteFerme() {
		coffre.oterLivre();
		coffre.tournerChandelleVersGauche();
		coffre.tournerChandelleVersGauche();
		assertEquals("Bloque", coffre.nomEtat());
		assertTrue(coffre.lapinEstLibere());
	}
	@Test
	public void testCoffreToujoursBloqueEtLapinLibereQuandOnFermeLeCoffreAlorsQueCoffreBloqueApresAvoirEteFerme() {
		coffre.oterLivre();
		coffre.tournerChandelleVersGauche();
		coffre.fermerCoffre();
		assertEquals("Bloque", coffre.nomEtat());
		assertTrue(coffre.lapinEstLibere());
	}
	@Test
	public void testCoffreToujoursBloqueEtLapinLibereQuandOnRemetLivreAlorsQueCoffreBloqueApresAvoirEteFerme() {
		coffre.oterLivre();
		coffre.tournerChandelleVersGauche();
		coffre.remettreLivre();
		assertEquals("Bloque", coffre.nomEtat());
		assertTrue(coffre.lapinEstLibere());
	}
	@Test
	public void testCoffreToujoursBloqueEtLapinLibereQuandOnTourneLaChandelleVersLaDroiteAlorsQueCoffreBloqueApresAvoirEtePresqueOuvert() {
		coffre.oterLivre();
		coffre.tournerChandelleVersDroite();
		coffre.tournerChandelleVersGauche();
		coffre.tournerChandelleVersDroite();
		assertEquals("Bloque", coffre.nomEtat());
		assertTrue(coffre.lapinEstLibere());
	}
	@Test
	public void testCoffreToujoursBloqueEtLapinLibereQuandOnTourneLaChandelleVersLaGaucheAlorsQueCoffreBloqueApresAvoirEtePresqueOuvert() {
		coffre.oterLivre();
		coffre.tournerChandelleVersDroite();
		coffre.tournerChandelleVersGauche();
		coffre.tournerChandelleVersGauche();
		assertEquals("Bloque", coffre.nomEtat());
		assertTrue(coffre.lapinEstLibere());
	}
	@Test
	public void testCoffreToujoursBloqueEtLapinLibereQuandOnFermeLeCoffreAlorsQueCoffreBloqueApresAvoirEtePresqueOuvert() {
		coffre.oterLivre();
		coffre.tournerChandelleVersDroite();
		coffre.tournerChandelleVersGauche();
		coffre.fermerCoffre();
		assertEquals("Bloque", coffre.nomEtat());
		assertTrue(coffre.lapinEstLibere());
	}
	@Test
	public void testCoffreToujoursBloqueEtLapinLibereQuandOnRemetLivreAlorsQueCoffreBloqueApresAvoirEtePresqueOuvert() {
		coffre.oterLivre();
		coffre.tournerChandelleVersDroite();
		coffre.tournerChandelleVersGauche();
		coffre.remettreLivre();
		assertEquals("Bloque", coffre.nomEtat());
		assertTrue(coffre.lapinEstLibere());
	}
	
	// TESTS RETOUR DANS LE MEME ETAT
	
	@Test
	public void testLapinTueurEnfermeEtChienGentilLibereEtCoffreOuvertApresAvoirRemisLeLivreAlorsQueLeCoffreEtaitPresqueOuvertPuisApresAvoirReoteLivreEtTourneChandelleDeuxFoisVersLaDroite() {
		coffre.oterLivre();
		coffre.tournerChandelleVersDroite();
		coffre.remettreLivre();
		coffre.oterLivre();
		coffre.tournerChandelleVersDroite();
		coffre.tournerChandelleVersDroite();
		assertEquals("Ouvert",coffre.nomEtat());
		assertFalse(coffre.lapinEstLibere());
		assertTrue(coffre.chienEstLibere());
	}
	@Test
	public void testLapinTueurEnfermeEtChienGentilLibereEtCoffreOuvertApresAvoirRemisLeLivreAlorsQueLeCoffreEtaitFermePuisApresAvoirReoteLivreEtTourneChandelleDeuxFoisVersLaDroite() {
		coffre.oterLivre();
		coffre.remettreLivre();
		coffre.oterLivre();
		coffre.tournerChandelleVersDroite();
		coffre.tournerChandelleVersDroite();
		assertEquals("Ouvert",coffre.nomEtat());
		assertFalse(coffre.lapinEstLibere());
		assertTrue(coffre.chienEstLibere());
	}
	@Test
	public void testCoffreFermeEtLapinTueurEnfermeEtChienGentilEnfermeApresAvoirOteLeLivreUnePremiereFoisPuisLAvoirRemisEtLAvoirReote() {
		coffre.oterLivre();
		coffre.remettreLivre();
		coffre.oterLivre();
		assertEquals("Ferme",coffre.nomEtat());
		assertFalse(coffre.chienEstLibere());
		assertFalse(coffre.lapinEstLibere());
	}
}