package simu.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Varaus {
    List<Huone> huoneet;
    int aika;
    Asiakas asiakas;
    VarauksenTila tila;
    VarauksenAlkupera alkupera;
    Date aloitusAika;
    Date lopetusAika;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public Varaus(Date aloitusAika, int aika, Asiakas asiakas, VarauksenAlkupera alkupera) {
        this.huoneet = new LinkedList<>();
        this.aloitusAika = aloitusAika;
        this.lopetusAika = lopetusAika;
        this.aika = aika;
        this.asiakas = asiakas;
        this.tila = VarauksenTila.ODOTTAA;
        this.alkupera = alkupera;
    }

    public void setHuoneet(List<Huone> huoneet) {
        this.huoneet = huoneet;
    }

    public List<Huone> getHuoneet(){
        return huoneet;
    }
    public Date getAloitusAika() {
        return aloitusAika;
    }

    public void setAloitusAika(Date aloitusAika) {
        this.aloitusAika = aloitusAika;
    }
    public Date getLopetusAika() {
        return lopetusAika;
    }

    public void setLopetusAika(Date lopetusAika) {
        this.lopetusAika = lopetusAika;
    }
    public void varmistaVaraus(){
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
                "}\n";
    }
}