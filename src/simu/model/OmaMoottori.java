package simu.model;

import eduni.distributions.Negexp;
import eduni.distributions.Normal;
import simu.framework.Kello;
import simu.framework.Moottori;
import simu.framework.Saapumisprosessi;
import simu.framework.Tapahtuma;

public class OmaMoottori extends Moottori{
	
	private Saapumisprosessi saapumisprosessi;

	public OmaMoottori() {

		palvelupisteet = new Palvelupiste[4];

		palvelupisteet[0]=new Palvelupiste(new Normal(10,6), tapahtumalista, TapahtumanTyyppi.KAHVILASTAPOISTUMINEN);
		palvelupisteet[1]=new Palvelupiste(new Normal(10,3), tapahtumalista, TapahtumanTyyppi.PALVELUTISKI1POISTUMINEN);
		palvelupisteet[2]=new Palvelupiste(new Normal(5,10), tapahtumalista, TapahtumanTyyppi.PALVELUTISKI2POISTUMINEN);
		palvelupisteet[3]=new Palvelupiste(new Normal(5,3), tapahtumalista, TapahtumanTyyppi.RAVINTOLASTAPOISTUMINEN);


		saapumisprosessi = new Saapumisprosessi(new Negexp(15,5), tapahtumalista, TapahtumanTyyppi.ARR1);

	}
	@Override
	protected void alustukset() {
		saapumisprosessi.generoiSeuraava(); // Ensimmäinen saapuminen järjestelmään
	}

	@Override
	protected void suoritaTapahtuma(Tapahtuma t){  // B-vaiheen tapahtumat
        //Oma kommentti, voi tehä toisen asiakas b:n kenellä eri toiminnallisuus.
		//Toiminnallisuus katsottu tapahtumantyypistä ja tehdään erilainen switch-case
		//Käy baarissa, menee palvelutiski1 (hitaampi jono)

		Asiakas a;

		switch (t.getTyyppi()){
			
			case ARR1: palvelupisteet[0].lisaaJonoon(new Asiakas());	
				       saapumisprosessi.generoiSeuraava();	
				break;
			case KAHVILASTAPOISTUMINEN: a = palvelupisteet[0].otaJonosta();
				   	   palvelupisteet[1].lisaaJonoon(a);
				break;
			case PALVELUTISKI1POISTUMINEN: a = palvelupisteet[1].otaJonosta();
				   	   palvelupisteet[3].lisaaJonoon(a);
				break;  
			case RAVINTOLASTAPOISTUMINEN:
				       a = palvelupisteet[3].otaJonosta();
					   a.setPoistumisaika(Kello.getInstance().getAika());
			           a.raportti(); 
		}
		/*
		Asiakas b;
		switch (t.getTyyppi()){

			case ARR1: palvelupisteet[0].lisaaJonoon(new Asiakas2());
				       saapumisprosessi.generoiSeuraava();

				break;
			case KAHVILASTAPOISTUMINEN: a = palvelupisteet[0].otaJonosta();
				   	   palvelupisteet[2].lisaaJonoon(a);
				break;
			case PALVELUTISKI2POISTUMINEN: a = palvelupisteet[2].otaJonosta();
				   	   palvelupisteet[3].lisaaJonoon(a);
				break;
			case RAVINTOLASTAPOISTUMINEN:
				       b = palvelupisteet[3].otaJonosta();
					   b.setPoistumisaika(Kello.getInstance().getAika());
			           b.raportti();
		}
		*/
	}
	@Override
	protected void tulokset() {	
		System.out.println("Simulointi päättyi kello " + Kello.getInstance().getAika());
		System.out.println("Tulokset ... puuttuvat vielä");
	}
}