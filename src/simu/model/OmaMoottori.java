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

		Asiakas a = new Asiakas();
		a.setVaraus();
		Boolean varaus = a.onkoVaraus();
		
		if (varaus == false) {
			switch (t.getTyyppi()){

				case ARR1: palvelupisteet[0].lisaaJonoon(a);
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

		}
		else {
			switch (t.getTyyppi()){

				case ARR1: palvelupisteet[0].lisaaJonoon(a);
					saapumisprosessi.generoiSeuraava();

					break;
				case KAHVILASTAPOISTUMINEN: a = palvelupisteet[0].otaJonosta();
					palvelupisteet[2].lisaaJonoon(a);
					break;
				case PALVELUTISKI2POISTUMINEN: a = palvelupisteet[2].otaJonosta();
					palvelupisteet[3].lisaaJonoon(a);
					break;
				case RAVINTOLASTAPOISTUMINEN:
					a = palvelupisteet[3].otaJonosta();
					a.setPoistumisaika(Kello.getInstance().getAika());
					a.raportti();
			}
		}
	}
	@Override
	protected void tulokset() {	
		System.out.println("Simulointi päättyi kello " + Kello.getInstance().getAika());
		System.out.println("Tulokset ... puuttuvat vielä");
	}
}