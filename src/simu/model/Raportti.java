package simu.model;

public class Raportti {
    double asiakkaidenlukumaara;
    double suoritettujenAsiakkaidenLukumaara;
    double aloitusaika;
    double lopetusaika;

    //Kuinka paljon aktuaalista työtä tehdään, eli kun asiakas palveltavana
    double plvltiski1Aktiiviaika;
    double plvltiski2Aktiiviaika;
    double kahvilaAktiiviaika;
    double ravintolaAktiiviaika;

    //suoritusteho on palveltujen
//asiakkaiden lukumäärä aikayksikössä X = C/T (asiakas jaettuna simulointiajalla)
    double plvltiski1suoritusteho;
    double plvltiski2suoritusteho;
    double kahvilaSuoritusteho;
    double ravintolaSuoritusteho;

    //S = B/C plvlpisteen aktiiviaika jaettuna asiakkaiden määrällä
    double plvltiski1keskimPalveluaika;
    double plvltiski2keskimPalveluaika;
    double kahvilakeskimPalveluaika;
    double ravintolakeskimPalveluaika;

    //Asiakkaan aika plvlpisteen jonoon saapumisesta palvelun päättymiseen (Asiakkaan kokema läpimenoaika)
    double plvltiski1lapimenoaika;
    double plvltiski2lapimenoaika;
    double kahvilaLapimenoaika;
    double ravintolaLapimenoaika;

    //keskimääräinen läpimenoaika palvelupisteessä
    //(R, response time) R = W/C  (kokonaisoleskeluaika / asiakkaiden määrällä)
    double plvltiski1keskimLapimenoaika;
    double plvltiski2keskimLapimenoaika;
    double kahvilakeskimLapimenoaika;
    double ravintolakeskimLapimenoaika;

//palvelupisteen käyttöaste (U, utilization) on käytön
//suhde kapasiteettiin U= B/T (aktiiviaika jaettuna ajalla)
    double plvltiski1kayttoaste;
    double plvltiski2kayttoaste;
    double kahvilaKayttoaste;
    double ravintolaKayttoaste;

    //Kaikkien asiakkaiden läpimenoaikojen summa
    double ravintolaKokonaispalveluaika;
    double kahvilaKokonaispalveluaika;
    double plvltiski1kokonaispalveluaika;
    double getPlvltiski2kokonaispalveluaika;

    //palvelupisteen keskimääräinen jononpituus
    //(palveltava mukana) N = W/T (kokonaisoleskeluaika palvelupisteessä / simulointiajalla)
    double ravintolaJono;
    double kahvilaJono;
    double plvltiski1jono;
    double plvltiski2jono;
    public void aktiiviaika(){}
    public void suoritusteho(){}
    public void lapimenoaika(){}
    public void keskimLapimenoaika(){}
    public void keskimPalveluaika(){}
    public void kayttoaste(){}
    public void kokonaisPalveluaika(){}
    public void keskimJononPituus () {}
    public double getTulokset(){
        return 0;
    }
}
