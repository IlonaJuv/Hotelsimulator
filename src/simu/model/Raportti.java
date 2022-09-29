package simu.model;

import simu.framework.Moottori;

public class Raportti {
Asiakas asiakas;
    int kahvilaAsiakkaat, plvlpiste1Asiakkaat,plvlpiste2Asiakkaat,huoneAsiakkaat,ravintolaAsiakkaat;
    //suoritusteho on palveltujen
    //asiakkaiden lukumäärä aikayksikössä X = C/T (asiakas jaettuna simulointiajalla)
    double plvltiski1suoritusteho;
    double plvltiski2suoritusteho;
    double kahvilaSuoritusteho;
    double ravintolaSuoritusteho;
    double yleinenSuoritusteho;


    //Asiakkaan aika plvlpisteen jonoon saapumisesta palvelun päättymiseen (Asiakkaan kokema läpimenoaika)
    double plvltiski1keskimlapimenoaika;
    double plvltiski2keskimlapimenoaika;
    double kahvilaKeskimLapimenoaika;
    double huoneKeskimLapimenoaika;
    double ravintolaKeskimLapimenoaika;

    //---------------------------------------------------------------------------------------------
    //palvelupisteen keskimääräinen jononpituus
    //(palveltava mukana) N = W/T (kokonaisoleskeluaika palvelupisteessä / simulointiajalla)
    double kahvilaKeskimJononPituus, plvltiski1KeskimJononPituus,
            plvltiski2KeskimJononPituus, huoneenKeskimJononPituus,ravintolanKeskimJononPituus;

    //-------------------------------------------------------------------------------------------

    //suoritusteho on palveltujen
    //asiakkaiden lukumäärä aikayksikössä X = C/T (asiakkaat jaettuna simulointiajalla)
    //Ehkä jokaiselle palvelupisteelle oma suoritusteho
    public void ravintolaSuoritusteho(){
        double rvAsiakkaat = asiakas.getRavintolaAsiakkaat();
        double simulointiaika = 1000; //moottori.getSimulointiaika();
        this.ravintolaSuoritusteho = (rvAsiakkaat / simulointiaika);
    }
    public double getRavintolaSuoritusteho() {
        return ravintolaSuoritusteho;
    }

    //--------------------------------------------------------------------------------------------
    //Asiakkaan aika plvlpisteen jonoon saapumisesta palvelun päättymiseen (Asiakkaan kokema läpimenoaika)
    //Keskimääräinen läpimenoaika.

    public void setKahvilaLapimenoaika(double lapimenoaika){
        this.kahvilaKeskimLapimenoaika = lapimenoaika;
    }
    public double getKahvilaKeskimLapimenoaika() {
        return kahvilaKeskimLapimenoaika;
    }
    public void  setPlvltiski1KeskimLapimenoaika(double lapimenoaika){
        this.plvltiski1keskimlapimenoaika = lapimenoaika;
    }
    public double getPlvltiski1KeskimLapimenoaika() {
        return plvltiski1keskimlapimenoaika;
    }
    public void setPlvltiski2Lapimenoaika(double lapimenoaika){
        this.plvltiski2keskimlapimenoaika = lapimenoaika;
    }
    public double getPlvltiski2Lapimenoaika() {
        return plvltiski2keskimlapimenoaika;
    }
    public void setHuoneLapimenoaika(double lapimenoaika) {
        this.huoneKeskimLapimenoaika = lapimenoaika;
    }
    public double getHuoneKeskimLapimenoaika () {
        return huoneKeskimLapimenoaika;
    }
    public void setRavintolaLapimenoaika(double lapimenoaika){
      this.ravintolaKeskimLapimenoaika = lapimenoaika;
    }
    public double getRavintolaKeskimLapimenoaika() {
        return ravintolaKeskimLapimenoaika;
    }


    //-----------------------------------------------------------
    //palvelupisteen keskimääräinen jononpituus
    //(palveltava mukana) N = W/T (kokonaisoleskeluaika palvelupisteessä / simulointiajalla)
    public void setKahvilanKeskimJononPituus (double kahvilaKeskimJononPituus) {
        this.kahvilaKeskimJononPituus = kahvilaKeskimJononPituus;
    }
    public double getKahvilanKeskimJononPituus() {
        return this.kahvilaKeskimJononPituus;
    }
    public void setPlvltiski1KeskimJononPituus (double plvltiski1KeskimJononPituus) {
        this.plvltiski1KeskimJononPituus = plvltiski1KeskimJononPituus;
    }
    public double getKPlvltiski1KeskimJononPituus() {
        return this.plvltiski1KeskimJononPituus;
    }
    public void setPlvltiski2KeskimJononPituus (double plvltiski2KeskimJononPituus) {
        this.plvltiski2KeskimJononPituus = plvltiski2KeskimJononPituus;
    }
    public double getKPlvltiski2KeskimJononPituus() {
        return this.plvltiski2KeskimJononPituus;
    }
    public void setHuoneenKeskimJononPituus (double huoneenKeskimJononPituus) {
        this.huoneenKeskimJononPituus = huoneenKeskimJononPituus;
    }
    public double getHuoneenKeskimJononPituus() {
        return this.huoneenKeskimJononPituus;
    }
    public void setRavintolaKeskimJononPituus (double ravintolanKeskimJononPituus) {
        this.ravintolanKeskimJononPituus = ravintolanKeskimJononPituus;
    }
    public double getRavintolanKeskimJononPituus() {
        return this.ravintolanKeskimJononPituus;
    }

    //-----------------------------------------------------------------------------------------------
    public void setKahvilaAsiakkaat (int asiakkaat) {
        this.kahvilaAsiakkaat = asiakkaat;
    }
   public void setPlvlpiste1Asiakkaat (int asiakkaat) {
        this.plvlpiste1Asiakkaat = asiakkaat;
    }
    public void setPlvlpiste2Asiakkaat (int asiakkaat) {
        this.plvlpiste2Asiakkaat = asiakkaat;
    } public void setHuoneAsiakkaat (int asiakkaat) {
        this.huoneAsiakkaat = asiakkaat;
    }  public void setRavintolaAsiakkaat (int asiakkaat) {
        this.ravintolaAsiakkaat = asiakkaat;
    }

    //----------------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "Raportti{" +
                ", kahvilaKeskimLapimenoaika=" + kahvilaKeskimLapimenoaika + " palvellut asiakkaat " + kahvilaAsiakkaat+"\n" +
                ", plvltiski1keskimlapimenoaika=" + plvltiski1keskimlapimenoaika + " palvellut asiakkaat " + plvlpiste1Asiakkaat +"\n" +
                ", plvltiski2keskimlapimenoaika=" + plvltiski2keskimlapimenoaika + " palvellut asiakkaat " + plvlpiste2Asiakkaat  +  "\n" +
                ", huoneKeskimLapimenoaika=" + huoneKeskimLapimenoaika + " palvellut asiakkaat " + huoneAsiakkaat  + "\n" +
                ", ravintolaKeskimLapimenoaika=" + ravintolaKeskimLapimenoaika + " palvellut asiakkaat " + ravintolaAsiakkaat +  "\n" +
                ", kahvilaKeskimJononPituus=" + kahvilaKeskimJononPituus +"\n" +
                ", plvltiski1KeskimJononPituus=" + plvltiski1KeskimJononPituus +"\n" +
                ", plvltiski2KeskimJononPituus=" + plvltiski2KeskimJononPituus +"\n" +
                ", huoneenKeskimJononPituus=" + huoneenKeskimJononPituus +"\n" +
                ", ravintolanKeskimJononPituus=" + ravintolanKeskimJononPituus +"\n" +
                '}';
    }
}

