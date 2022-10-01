package simu.model;

import controller.IKontrolleri;
import eduni.distributions.Negexp;
import eduni.distributions.Normal;
import simu.framework.Kello;
import simu.framework.Moottori;
import simu.framework.Saapumisprosessi;
import simu.framework.Tapahtuma;

public class OmaMoottori extends Moottori {
	private Saapumisprosessi saapumisprosessi;
	Raportti raportti = new Raportti();
	public OmaMoottori(IKontrolleri kontrolleri) { //UUSI
		super(kontrolleri);

		palvelupisteet = new Palvelupiste[5];
		palvelupisteet[0] = new Palvelupiste(new Normal(5, 6), tapahtumalista, TapahtumanTyyppi.KAHVILASTAPOISTUMINEN);
		palvelupisteet[1] = new Palvelupiste(new Normal(5, 6), tapahtumalista, TapahtumanTyyppi.PALVELUTISKI1POISTUMINEN);
		palvelupisteet[2] = new Palvelupiste(new Normal(5, 6), tapahtumalista, TapahtumanTyyppi.PALVELUTISKI2POISTUMINEN);
		palvelupisteet[3] = new Palvelupiste(new Normal(5, 6), tapahtumalista, TapahtumanTyyppi.HUONEESTAPOISTUMINEN);
		palvelupisteet[4] = new Palvelupiste(new Normal(15, 6), tapahtumalista, TapahtumanTyyppi.RAVINTOLASTAPOISTUMINEN);

		saapumisprosessi = new Saapumisprosessi(new Negexp(15,5), tapahtumalista, TapahtumanTyyppi.ARR1);
	}
	@Override
	protected void alustukset() {
		saapumisprosessi.generoiSeuraava(); // Ensimmäinen saapuminen järjestelmään
	}
	double rvTulo, kTulo, hTulo, p1Tulo, p2Tulo;
		@Override

	protected void suoritaTapahtuma(Tapahtuma t){  // B-vaiheen tapahtumat
		Asiakas a;
			switch (t.getTyyppi()){
				case ARR1: a = new Asiakas();
					if (a.meneekoKahvilaan()) {
						kTulo = Kello.getInstance().getAika();
						palvelupisteet[0].lisaaJonoon(a);
					}
					if (!a.meneekoKahvilaan() && !a.onkoVaraus()) {
						p1Tulo = Kello.getInstance().getAika();
						palvelupisteet[1].lisaaJonoon(a);
					}
					if (!a.meneekoKahvilaan() && a.onkoVaraus()) {
						p2Tulo = Kello.getInstance().getAika();
						palvelupisteet[2].lisaaJonoon(a);
					}
					saapumisprosessi.generoiSeuraava();
					break;
				case KAHVILASTAPOISTUMINEN:
					a = palvelupisteet[0].otaJonosta();
					a.setKahvilaanTuloAika(kTulo);
					a.setKahvilastaPoistumisaika(Kello.getInstance().getAika());
					if (!a.onkoVaraus()) {
						p1Tulo = Kello.getInstance().getAika();
						palvelupisteet[1].lisaaJonoon(a);
					}else{
						p2Tulo = Kello.getInstance().getAika();
						palvelupisteet[2].lisaaJonoon(a);
					}
					break;
				case PALVELUTISKI1POISTUMINEN: a = palvelupisteet[1].otaJonosta();
				a.setPlvlTiski1TuloAika(p1Tulo);
				a.setPlvltiski1Poistumisaika(Kello.getInstance().getAika());
					hTulo = Kello.getInstance().getAika();
					palvelupisteet[3].lisaaJonoon(a);
					break;
				case PALVELUTISKI2POISTUMINEN: a = palvelupisteet[2].otaJonosta();
				a.setPlvlTiski2TuloAika(p2Tulo);
				a.setPlvltiski2Poistumisaika(Kello.getInstance().getAika());
					palvelupisteet[3].lisaaJonoon(a);
					hTulo = Kello.getInstance().getAika();
					break;
				case HUONEESTAPOISTUMINEN: a = palvelupisteet[3].otaJonosta();
				a.setHuoneeseenTuloAika(hTulo);
				a.setHuoneestaPoistumisaika(Kello.getInstance().getAika());
					palvelupisteet[4].lisaaJonoon(a);
					rvTulo = Kello.getInstance().getAika();
					break;
				case RAVINTOLASTAPOISTUMINEN:
					a = palvelupisteet[4].otaJonosta();
					a.setRavintolaanTuloAika(rvTulo);
					a.setRavintolastaPoistumisAika(Kello.getInstance().getAika());
					a.setPoistumisaika(Kello.getInstance().getAika());
					a.raportti();
					Palvelupiste p = new Palvelupiste();

					raportti.setRavintolaKeskimLapimenoaika(p.getRavintolaLapimenoaika());
					raportti.setHuoneKeskimLapimenoaika(p.getHuoneLapimenoaika());
					raportti.setKahvilaKeskimLapimenoaika(p.getKahvilaLapimenoaika());
					raportti.setPlvltiski1KeskimLapimenoaika(p.getPlvltiski1Lapimenoaika());
					raportti.setPlvltiski2KeskimLapimenoaika(p.getPlvltiski2Lapimenoaika());

					raportti.setKahvilanKeskimJononPituus(p.getKahvilanKeskimJononPituus());
					raportti.setPlvltiski1KeskimJononPituus(p.getPlvltiski1KeskimJononPituus());
					raportti.setPlvltiski2KeskimJononPituus(p.getPlvltiski2KeskimJononPituus());
					raportti.setHuoneenKeskimJononPituus(p.getHuoneKeskimJononPituus());
					raportti.setRavintolaKeskimJononPituus(p.getRavintolaKeskimJononPituus());

					raportti.setKahvilaAsiakkaat(a.getKahvilaAsiakkaat());
					raportti.setPlvlpiste1Asiakkaat(a.getP1Asiakkaat());
					raportti.setPlvlpiste2Asiakkaat(a.getP2Asiakkaat());
					raportti.setHuoneAsiakkaat(a.getHuoneAsiakkaat());
					raportti.setRavintolaAsiakkaat(a.getRavintolaAsiakkaat());
			}
		}
	@Override
	protected void tulokset() {
		System.out.println("Simulointi päättyi kello " + Kello.getInstance().getAika());
		System.out.println(raportti);
		System.out.println("Tulokset ... puuttuvat vielä");
		kontrolleri.naytaLoppuaika(Kello.getInstance().getAika());
	}
}
