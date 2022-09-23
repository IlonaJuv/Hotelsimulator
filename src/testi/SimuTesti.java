package testi;

import simu.model.*;

import java.util.*;

public class SimuTesti {
    int asiakasLaskuri = 1;

    public void simuTestaus1() {
        Huone huone1 = new Huone(1);
        Huone huone2 = new Huone(2);
        Huone huone3 = new Huone(4);
        Huone huone4 = new Huone(4);
        Huone huone5 = new Huone(1);
        List<Huone> huoneet = new ArrayList<>();
        huoneet.add(huone1);
        huoneet.add(huone2);
        huoneet.add(huone3);
        huoneet.add(huone4);
        huoneet.add(huone5);
        Hotelli hotelli = new Hotelli(huoneet);
        VarauksenTeko varauksenTeko = new VarauksenTeko(hotelli);
        int etukateenTodennakoisuus = 60;
        while (varauksenTeko.getVarauksetHotellissa().size() + varauksenTeko.getVarauksetEtukateen().size() < 300){
            List<Huone> valitutHuoneet = new LinkedList<>();
            valitutHuoneet.add(hotelli.getHuoneet().get(0));
            varauksenTeko.varmistaVaraus(luoVarausEtukateenTaiHotellissa(etukateenTodennakoisuus), valitutHuoneet);
        }
    }

    private Varaus luoVarausEtukateenTaiHotellissa(int etukateenTodennakoisuus) {
        int todennakoisyys = Utils.getRandomNumber(0, 100);
        VarauksenAlkupera alkupera = VarauksenAlkupera.HOTELLISSA;
        if (todennakoisyys <= etukateenTodennakoisuus) {
            alkupera = VarauksenAlkupera.ETUKATEEN;
        }
        return luoVarausAlkuperalla(alkupera);
    }

    private Varaus luoVarausAlkuperalla(VarauksenAlkupera alkupera) {
        //min ja max päivät jonka ajaksi huoneen voi varata
        int paivienMaara = Utils.getRandomNumber(1,3);
        Date aloitusAika = new Date(Calendar.getInstance().getTimeInMillis() + Utils.getRandomNumber(400000, 4000000));
        String asiakastunniste = "C" + asiakasLaskuri;
        asiakasLaskuri = asiakasLaskuri + 1;
        Varaus varaus = new Varaus(aloitusAika,paivienMaara, new Asiakas(asiakastunniste), alkupera);
        return varaus;
    }
}
