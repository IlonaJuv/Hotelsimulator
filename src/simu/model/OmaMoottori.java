package simu.model;

import eduni.distributions.Negexp;
import eduni.distributions.Normal;
import simu.framework.Kello;
import simu.framework.Moottori;
import simu.framework.Saapumisprosessi;
import simu.framework.Tapahtuma;

public class OmaMoottori extends Moottori {
	private Saapumisprosessi saapumisprosessi;
	Raportti raportti = new Raportti();
	int asiakaslkm = 0;
	double kahvilaJonoSaapuminen;
	double kahvilaJonoPoistuminen;
	double tiski1JonoSaapuminen;
	double tiski1JonoPoistuminen;

	double tiski2JonoSaapuminen;
	double tiski2JonoPoistuminen;

	double huoneSaapuminen;
	double huonePoistuminen;
	double ravintolaJonoSaapuminen;
	double ravintolaJonoPoistuminen;


	public OmaMoottori() {

		palvelupisteet = new Palvelupiste[5];

		palvelupisteet[0] = new Palvelupiste(new Normal(5, 6), tapahtumalista, TapahtumanTyyppi.KAHVILASTAPOISTUMINEN);
		palvelupisteet[1] = new Palvelupiste(new Normal(5, 10), tapahtumalista, TapahtumanTyyppi.PALVELUTISKI1POISTUMINEN);
		palvelupisteet[2] = new Palvelupiste(new Normal(5, 3), tapahtumalista, TapahtumanTyyppi.PALVELUTISKI2POISTUMINEN);
		palvelupisteet[3] = new Palvelupiste(new Normal(8, 20), tapahtumalista, TapahtumanTyyppi.HUONEESTAPOISTUMINEN);
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
					asiakaslkm ++;
					if (a.meneekoKahvilaan()) {
						palvelupisteet[0].lisaaJonoon(a);
						kahvilaJonoSaapuminen = Kello.getInstance().getAika();
					}
					if (!a.meneekoKahvilaan() && !a.onkoVaraus())
						palvelupisteet[1].lisaaJonoon(a);
					tiski1JonoSaapuminen = Kello.getInstance().getAika();
					if (!a.meneekoKahvilaan() && a.onkoVaraus())
						palvelupisteet[2].lisaaJonoon(a);
					tiski2JonoSaapuminen = Kello.getInstance().getAika();
					saapumisprosessi.generoiSeuraava();
					break;

				case KAHVILASTAPOISTUMINEN:	a = palvelupisteet[0].otaJonosta();
					kahvilaJonoPoistuminen = Kello.getInstance().getAika();
					if (!a.onkoVaraus()) {
						palvelupisteet[1].lisaaJonoon(a);
						tiski1JonoSaapuminen = Kello.getInstance().getAika();
					}else
						palvelupisteet[2].lisaaJonoon(a);
					tiski2JonoSaapuminen = Kello.getInstance().getAika();
					break;

				case PALVELUTISKI1POISTUMINEN: a = palvelupisteet[1].otaJonosta();
					tiski1JonoPoistuminen = Kello.getInstance().getAika();
					palvelupisteet[3].lisaaJonoon(a);
					huoneSaapuminen = Kello.getInstance().getAika();
					break;
				case PALVELUTISKI2POISTUMINEN: a = palvelupisteet[2].otaJonosta();
					tiski2JonoPoistuminen = Kello.getInstance().getAika();
					palvelupisteet[3].lisaaJonoon(a);
					huoneSaapuminen = Kello.getInstance().getAika();
					break;
				case HUONEESTAPOISTUMINEN: a = palvelupisteet[3].otaJonosta();
				huonePoistuminen = Kello.getInstance().getAika();
					palvelupisteet[4].lisaaJonoon(a);
					ravintolaJonoSaapuminen = Kello.getInstance().getAika();
					break;
				case RAVINTOLASTAPOISTUMINEN:
					a = palvelupisteet[4].otaJonosta();
					ravintolaJonoPoistuminen = Kello.getInstance().getAika();
					a.setPoistumisaika(Kello.getInstance().getAika());
					a.raportti();
			}
		}

	public void setTulokset () {
		raportti.setSuoritusteho(asiakaslkm, Kello.getInstance().getAika());
		raportti.setAsiakaslkm(asiakaslkm);

		raportti.setKahvilaLapimenoaika(kahvilaJonoSaapuminen, kahvilaJonoPoistuminen);
		raportti.setPlvltiski2Lapimenoaika(kahvilaJonoSaapuminen, tiski2JonoPoistuminen);
		raportti.setPlvltiski1Lapimenoaika(tiski1JonoSaapuminen, tiski1JonoPoistuminen);
		raportti.setHuoneLapimenoaika(huoneSaapuminen, huonePoistuminen);
		raportti.setRavintolaLapimenoaika(kahvilaJonoSaapuminen, ravintolaJonoPoistuminen);
	}

	@Override
	protected void tulokset() {
		setTulokset();
		System.out.println(raportti);
		//System.out.println(asiakaslkm);
		System.out.println("Simulointi päättyi kello " + Kello.getInstance().getAika());
		System.out.println("Tulokset ... puuttuvat vielä");
	}
}
