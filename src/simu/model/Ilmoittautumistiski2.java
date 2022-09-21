package simu.model;

import java.util.LinkedList;

import eduni.distributions.ContinuousGenerator;
import simu.framework.Kello;
import simu.framework.Tapahtuma;
import simu.framework.Tapahtumalista;

public class Ilmoittautumistiski2 extends Palvelupiste{
	

		private LinkedList<Asiakas> jono = new LinkedList<Asiakas>(); // Tietorakennetoteutus
		
		private ContinuousGenerator generator;
		private Tapahtumalista tapahtumalista;
		private TapahtumanTyyppi skeduloitavanTapahtumanTyyppi; 
		
		//JonoStartegia strategia; //optio: asiakkaiden järjestys
		
		private boolean varattu = false;


		public Ilmoittautumistiski2(ContinuousGenerator generator, Tapahtumalista tapahtumalista, TapahtumanTyyppi tyyppi){
			super(generator, tapahtumalista, tyyppi);
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

		public void aloitaPalvelu(){  //Aloitetaan uusi palvelu, asiakas on jonossa palvelun aikana
			varattu = true;
			double palveluaika = generator.sample();
			tapahtumalista.lisaa(new Tapahtuma(skeduloitavanTapahtumanTyyppi,Kello.getInstance().getAika()+palveluaika));
		}


		public boolean onVarattu(){
			return varattu;
		}

		public boolean onJonossa(){
			return jono.size() != 0;
		}

}