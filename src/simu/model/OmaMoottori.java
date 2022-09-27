package simu.model;

import eduni.distributions.Negexp;
import eduni.distributions.Normal;
import simu.framework.Kello;
import simu.framework.Moottori;
import simu.framework.Saapumisprosessi;
import simu.framework.Tapahtuma;

public class OmaMoottori extends Moottori {
	private Saapumisprosessi saapumisprosessi;

	public OmaMoottori() {

		palvelupisteet = new Palvelupiste[5];

		palvelupisteet[0] = new Palvelupiste(new Normal(5, 6), tapahtumalista, TapahtumanTyyppi.KAHVILASTAPOISTUMINEN);
		palvelupisteet[1] = new Palvelupiste(new Normal(5, 3), tapahtumalista, TapahtumanTyyppi.PALVELUTISKI1POISTUMINEN);
		palvelupisteet[2] = new Palvelupiste(new Normal(5, 3), tapahtumalista, TapahtumanTyyppi.PALVELUTISKI2POISTUMINEN);
		palvelupisteet[3] = new Palvelupiste(new Normal(5, 3), tapahtumalista, TapahtumanTyyppi.HUONEESTAPOISTUMINEN);
		palvelupisteet[4] = new Palvelupiste(new Normal(5, 3), tapahtumalista, TapahtumanTyyppi.RAVINTOLASTAPOISTUMINEN);

		saapumisprosessi = new Saapumisprosessi(new Negexp(15,5), tapahtumalista, TapahtumanTyyppi.ARR1);

	}
	@Override
	protected void alustukset() {
		saapumisprosessi.generoiSeuraava(); // Ensimmäinen saapuminen järjestelmään
	}

	@Override
	protected void suoritaTapahtuma(Tapahtuma t){  // B-vaiheen tapahtumat
		Asiakas a;
			switch (t.getTyyppi()){
				case ARR1: a = new Asiakas();
				if (a.meneekoKahvilaan()) {
					palvelupisteet[0].lisaaJonoon(a);
				}
				if (!a.meneekoKahvilaan() && !a.onkoVaraus())
						palvelupisteet[1].lisaaJonoon(a);
				if (!a.meneekoKahvilaan() && a.onkoVaraus())
						palvelupisteet[2].lisaaJonoon(a);
					saapumisprosessi.generoiSeuraava();
					break;

				case KAHVILASTAPOISTUMINEN:	a = palvelupisteet[0].otaJonosta();
						if (!a.onkoVaraus())
							palvelupisteet[1].lisaaJonoon(a);
						else
							palvelupisteet[2].lisaaJonoon(a);
						break;
				case PALVELUTISKI1POISTUMINEN: a = palvelupisteet[1].otaJonosta();
					palvelupisteet[3].lisaaJonoon(a);
					break;
				case PALVELUTISKI2POISTUMINEN: a = palvelupisteet[2].otaJonosta();
					palvelupisteet[3].lisaaJonoon(a);
					break;
				case HUONEESTAPOISTUMINEN: a = palvelupisteet[3].otaJonosta();
					palvelupisteet[4].lisaaJonoon(a);
					break;
				case RAVINTOLASTAPOISTUMINEN:
					a = palvelupisteet[4].otaJonosta();
					a.setPoistumisaika(Kello.getInstance().getAika());
					a.raportti();
			}
		}

	@Override
	protected void tulokset() {
		System.out.println("Simulointi päättyi kello " + Kello.getInstance().getAika());
		System.out.println("Tulokset ... puuttuvat vielä");
	}
}

