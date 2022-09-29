package simu.model;

import java.util.LinkedList;
import java.util.List;

import eduni.distributions.ContinuousGenerator;
import simu.framework.Kello;
import simu.framework.Tapahtuma;
import simu.framework.Tapahtumalista;
import simu.framework.Trace;

// TODO:
// Palvelupistekohtaiset toiminnallisuudet, laskutoimitukset (+ tarvittavat muuttujat) ja raportointi koodattava
public class Palvelupiste {
	private LinkedList<Asiakas> jono = new LinkedList<Asiakas>(); // Tietorakennetoteutus
	private LinkedList<Asiakas> ravintolaJono = new LinkedList<Asiakas>();
	private ContinuousGenerator generator;

	private Tapahtumalista tapahtumalista;
	private TapahtumanTyyppi skeduloitavanTapahtumanTyyppi;

	//JonoStartegia strategia; //optio: asiakkaiden järjestys
	private boolean varattu = false;
	private boolean ravintolaVaraus =  false;

	public Palvelupiste(ContinuousGenerator generator, Tapahtumalista tapahtumalista, TapahtumanTyyppi tyyppi){
		this.tapahtumalista = tapahtumalista;
		this.generator = generator;
		this.skeduloitavanTapahtumanTyyppi = tyyppi;
	}
	public void lisaaJonoon(Asiakas a){   // Jonon 1. asiakas aina palvelussa
		jono.add(a);
	}
	public Asiakas otaJonosta(){  // Poistetaan palvelussa ollut
		varattu = false;
		return jono.poll();
	}
	public List<Asiakas> jononKokoko () {
		return jono;
	}
	public void lisaaRavintolaJonoon(Asiakas a) {
		ravintolaJono.add(a);
	}
	public Asiakas otaRavintolaJonosta(){
		ravintolaVaraus = false;
		return ravintolaJono.poll();
	}

	public void aloitaPalvelu(){  //Aloitetaan uusi palvelu, asiakas on jonossa palvelun aikana
		
		Trace.out(Trace.Level.INFO, "Aloitetaan uusi palvelu asiakkaalle " + jono.peek().getId());
		varattu = true;

		if (skeduloitavanTapahtumanTyyppi == TapahtumanTyyppi.KAHVILASTAPOISTUMINEN) {
			double palveluaika = generator.sample();
			tapahtumalista.lisaa(new Tapahtuma(skeduloitavanTapahtumanTyyppi,Kello.getInstance().getAika()+palveluaika));
		} else if (skeduloitavanTapahtumanTyyppi == TapahtumanTyyppi.PALVELUTISKI1POISTUMINEN) {
			double palveluaika = generator.sample();
			tapahtumalista.lisaa(new Tapahtuma(skeduloitavanTapahtumanTyyppi,Kello.getInstance().getAika()+palveluaika));
		} else if (skeduloitavanTapahtumanTyyppi == TapahtumanTyyppi.PALVELUTISKI2POISTUMINEN) {
			double palveluaika = generator.sample();
			tapahtumalista.lisaa(new Tapahtuma(skeduloitavanTapahtumanTyyppi,Kello.getInstance().getAika()+palveluaika));
		} else if (skeduloitavanTapahtumanTyyppi == TapahtumanTyyppi.HUONEESTAPOISTUMINEN) {
			double palveluaika = generator.sample();
			tapahtumalista.lisaa(new Tapahtuma(skeduloitavanTapahtumanTyyppi,Kello.getInstance().getAika()+palveluaika));
		} else {
			ravintolaVaraus = true;
			double palveluaika = generator.sample();
			tapahtumalista.lisaa(new Tapahtuma(skeduloitavanTapahtumanTyyppi,Kello.getInstance().getAika()+palveluaika));
		}
	}
	public boolean ravintolaVarattu() {
		return ravintolaVaraus;
	}
	public boolean onVarattu(){
		return varattu;
	}
	public boolean onRavintolaJonossa(){
		return jono.size() != 0;
	}
	public boolean onJonossa(){
		return jono.size() != 0;
	}
}
