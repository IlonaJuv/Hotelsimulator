package simu.model;

import simu.framework.Moottori;

public class Raportti {
    // Moottori moottori;
    //  double simulointiaika = ((Object) moottori).getSimulointiaika();

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
    double yleinenSuoritusteho;

    //S = B/C plvlpisteen aktiiviaika jaettuna asiakkaiden määrällä
    double plvltiski1keskimPalveluaika;
    double plvltiski2keskimPalveluaika;
    double kahvilakeskimPalveluaika;
    double ravintolakeskimPalveluaika;

    //Asiakkaan aika plvlpisteen jonoon saapumisesta palvelun päättymiseen (Asiakkaan kokema läpimenoaika)
    double plvltiski1lapimenoaika;
    double plvltiski2lapimenoaika;
    double kahvilaLapimenoaika;
    double huoneLapimenoaika;
    double ravintolaLapimenoaika;
    double lapimenoaika;
    //-----------------------------------------------
    double plvl1KokonaisPaveluaika;
    double plvl2KokonaisPaveluaika;
    double kahvilaKokonaisPaveluaika;
    double ravintolaKokonaisPaveluaika;

    double kokonaisPaveluaika;
    ///-----------------------------------------------

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

    //------------------------------------
    public void setAsiakaslkm(int asiakaslkm) {
        this.asiakkaidenlukumaara = asiakaslkm;
    }

//----------------------------------------------------------------------------------------------------


    //Kuinka paljon aktuaalista työtä tehdään, eli kun asiakas palveltavana
    public double kahvilaAktiiviaika(double simulointiaika, double asiakkaanPalveluaika){
        return plvltiski1Aktiiviaika = yleinenAktiiviAika(simulointiaika, asiakkaanPalveluaika);
    }
    public double palvelu1Aktiiviaika(double simulointiaika, double asiakkaanPalveluaika){
        return plvltiski2Aktiiviaika =  yleinenAktiiviAika(simulointiaika, asiakkaanPalveluaika);
    }
    public double palvelu2Aktiiviaika(double simulointiaika, double asiakkaanPalveluaika){
        return kahvilaAktiiviaika =  yleinenAktiiviAika(simulointiaika, asiakkaanPalveluaika);
    }

    public double ravintolaAktiiviaika(double simulointiaika, double asiakkaanPalveluaika){
        return ravintolaAktiiviaika = yleinenAktiiviAika(simulointiaika, asiakkaanPalveluaika);
    }

    private double yleinenAktiiviAika (double simulointiaika, double asiakkaanPalveluaika) {
        double yleinenAktiiviaika;
        return yleinenAktiiviaika = simulointiaika / asiakkaanPalveluaika;
    }
    //-------------------------------------------------------------------------------------------

    //suoritusteho on palveltujen
    //asiakkaiden lukumäärä aikayksikössä X = C/T (asiakkaat jaettuna simulointiajalla)
    //Ehkä jokaiselle palvelupisteelle oma suoritusteho
    public void setSuoritusteho(long asiakaslkm, double simulointiaika){
        this.yleinenSuoritusteho = (asiakaslkm / simulointiaika);
    }
    public double getYleinenSuoritusteho() {
        return yleinenSuoritusteho;
    }


    //--------------------------------------------------------------------------------------------


    //Asiakkaan aika plvlpisteen jonoon saapumisesta palvelun päättymiseen (Asiakkaan kokema läpimenoaika)

    public void  setPlvltiski1Lapimenoaika(double jonoAika, double plvlpistePoistumisaika){
        this.plvltiski1lapimenoaika = lapimenoaika(jonoAika, plvlpistePoistumisaika);
        setPlvl1kokonaisPalveluaika(plvltiski1lapimenoaika);
    }
    public double getPlvltiski1Lapimenoaika() {
        return plvltiski1lapimenoaika;
    }
    public void setPlvltiski2Lapimenoaika(double jonoAika, double plvlpistePoistumisaika){
        this.plvltiski2lapimenoaika = lapimenoaika(jonoAika, plvlpistePoistumisaika);
    }
    public double getPlvltiski2Lapimenoaika() {
        return plvltiski2lapimenoaika;
    }
    public void setKahvilaLapimenoaika(double jonoAika, double plvlpistePoistumisaika){
        this.kahvilaLapimenoaika = lapimenoaika(jonoAika, plvlpistePoistumisaika);
    }
    public double getKahvilaLapimenoaika() {
        return kahvilaLapimenoaika;
    }
    public void setHuoneLapimenoaika(double jonoaika, double plvlpistePoistumisaika) {
        this.huoneLapimenoaika = lapimenoaika(jonoaika, plvlpistePoistumisaika);
    }
    public void setRavintolaLapimenoaika(double jonoAika, double plvlpistePoistumisaika){
        //this.ravintolaLapimenoaika = lapimenoaika(jonoAika, plvlpistePoistumisaika);
        this.ravintolaLapimenoaika = (plvlpistePoistumisaika-jonoAika);
    }
    public double getRavintolaLapimenoaika() {
        return ravintolaLapimenoaika;
    }
    private double lapimenoaika (double jonoAika, double plvlpistePoistumisaika) {
        return lapimenoaika = ( jonoAika - plvlpistePoistumisaika);
    }
    public double getLapimenoaika() {
        return lapimenoaika;
    }

    //---------------------------------------------------------------------------------------


    //Kaikkien asiakkaiden läpimenoaikojen summa (w)
    public void setPlvl1kokonaisPalveluaika(double palveluaika){
        plvl1KokonaisPaveluaika = plvl1KokonaisPaveluaika+palveluaika;
    }
    public void setPlvl2kokonaisPalveluaika(double palveluaika){
        plvl2KokonaisPaveluaika = plvl2KokonaisPaveluaika+palveluaika;
    }
    public void setKahvilaKokonaisPalveluaika(double palveluaika){
        kahvilaKokonaisPaveluaika = kahvilaKokonaisPaveluaika+palveluaika;
    }
    public void setRavintolaKokonaisPalveluaika(double palveluaika){
        ravintolaKokonaisPaveluaika = ravintolaKokonaisPaveluaika+palveluaika;
    }
    public double yleinenKokonaisPalveluaika(double lapimenoaika){
        kokonaisPaveluaika += lapimenoaika;
        return kokonaisPaveluaika;
    }


    //keskimääräinen läpimenoaika palvelupisteessä
    //(R, response time) R = W/C  (kokonaisoleskeluaika / asiakkaiden määrällä)
    public void keskimLapimenoaika(){

    }
    //-----------------------------------------------------------
    //S = B/C plvlpisteen aktiiviaika jaettuna asiakkaiden määrällä
    public void keskimPalveluaika(){}


    //palvelupisteen käyttöaste (U, utilization) on käytön
//suhde kapasiteettiin U= B/T (aktiiviaika jaettuna ajalla)
    public void kayttoaste(){}


    //palvelupisteen keskimääräinen jononpituus
    //(palveltava mukana) N = W/T (kokonaisoleskeluaika palvelupisteessä / simulointiajalla)
    public void keskimJononPituus () {}
    @Override
    public String toString() {
        return "Raportti [asiakkaidenlukumaara=" + asiakkaidenlukumaara + ", yleinenSuoritusteho=" +  "\n" + yleinenSuoritusteho
                + ", plvltiski1lapimenoaika=" + plvltiski1lapimenoaika + "\n" + ", plvltiski2lapimenoaika="
                + plvltiski2lapimenoaika + ", kahvilaLapimenoaika=" + kahvilaLapimenoaika + "\n" + ", Huonelapienoaika " + huoneLapimenoaika +", ravintolaLapimenoaika="
                + ravintolaLapimenoaika ;
    }

    public double getTulokset(){

        return 0;
    }
}