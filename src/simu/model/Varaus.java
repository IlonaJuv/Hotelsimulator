package simu.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Varaus {
    List<Huone> huoneet;
    Huone huone;
    double aika;
    Asiakas asiakas;
    VarauksenTila tila;
    VarauksenAlkupera alkupera;
    Date aloitusAika;
    Date lopetusAika;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    static int i =0;

    public Varaus(Date aloitusAika, double aika, Asiakas asiakas, VarauksenAlkupera alkupera) {
        this.huoneet = new LinkedList<>();
        this.aloitusAika = aloitusAika;
        this.aika = aika;
        this.lopetusAika = new Date(aloitusAika.getTime() + (long) (aika * 86390));
        this.asiakas = asiakas;
        this.tila = VarauksenTila.ODOTTAA;
        this.alkupera = alkupera;

    }

    public boolean lisaaHuoneVaraus(Huone huone) {
        return this.huoneet.add(huone);
    }

    public void setHuoneet(List<Huone> huoneet) {
        this.huoneet = huoneet;
    }

    public List<Huone> getHuoneet() {
        return huoneet;
    }

    public void setHuone(Huone huone) {
        this.huone = huone;
    }
    public Huone getHuone() {
      /* // int id =0;
        i ++;
        huone = huoneet.get(i);
*/
        return this.huone;
    }

    public Date getAloitusAika() {
        return this.aloitusAika;
    }

    public void setAloitusAika(Date aloitusAika) {
        this.aloitusAika = aloitusAika;
    }

    public Date getLopetusAika() {
        return this.lopetusAika;
    }
/*
    public void setLopetusAika(Date lopetusAika) {
        this.lopetusAika = lopetusAika;
    }
*/
    public Asiakas getAsiakas() {
        return this.asiakas;
    }

    public void setAsiakas(Asiakas asiakas) {
        this.asiakas = asiakas;
    }

    public void varmistaVaraus() {
        this.tila = VarauksenTila.VARMISTETTU;
    }

    public VarauksenTila getTila() {
        return tila;
    }

    @Override
    public String toString() {
        return "Varaus{" +
                "huoneet=" + huoneet +
                ", aika=" + aika +
                ", asiakas=" + asiakas +
                ", tila=" + tila +
                ", alkupera=" + alkupera +
                ", aloitusAika=" + aloitusAika +
                ", lopetusAika=" + lopetusAika +
              //  ", sdf=" + sdf +
                "}\n";
    }
}
