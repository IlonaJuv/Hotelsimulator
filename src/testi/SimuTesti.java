/*package testi;

import simu.model.*;

import java.util.*;

public class SimuTesti {
    int asiakasLaskuri = 1;
    Varaus varaus;

    public void simuTestaus1() {
        int kapasiteetti = 3;
        List<Huone> huoneet = new ArrayList<>();
        for (int i = 1; i<= kapasiteetti; i++) {
            Huone huone1 = new Huone(i);
            huoneet.add(huone1);

        }

        Hotelli hotelli = new Hotelli(huoneet);
        VarauksenTeko varauksenTeko = new VarauksenTeko(hotelli);
        int etukateenTodennakoisuus = 60;


        while (varauksenTeko.getVarauksetHotellissa().size() + varauksenTeko.getVarauksetEtukateen().size() < 300){
            List<Huone> valitutHuoneet = new LinkedList<>();

                for (int i = 0; i < hotelli.getHuoneet().size(); i++) {

                    valitutHuoneet.add(hotelli.getHuoneet().get(i));
                    // valitutHuoneet.add(hotelli.getHuoneet().get(0));
//                    varaus.setHuone(hotelli.getHuoneet().get(i));

                }

            varauksenTeko.varmistaVaraus(luoVarausEtukateenTaiHotellissa(etukateenTodennakoisuus), valitutHuoneet);
        }
        System.out.println(varauksenTeko.getVarauksetEtukateen());
        System.out.println(varauksenTeko.getVarauksetHotellissa());
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
        double paivienMaara = Utils.getRandomNumber(1,4);
        Date aloitusAika = new Date(Calendar.getInstance().getTimeInMillis() + Utils.getRandomNumber(400000, 4000000));
        String asiakastunniste = "C" + asiakasLaskuri;
        asiakasLaskuri = asiakasLaskuri + 1;
        Varaus varaus = new Varaus(aloitusAika,paivienMaara, new Asiakas(asiakastunniste), alkupera);

        return varaus;
    }
}

 */
