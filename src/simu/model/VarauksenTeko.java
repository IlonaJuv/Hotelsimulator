package simu.model;

import java.util.*;
import java.util.stream.Collectors;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class VarauksenTeko {
    List<Varaus> varauksetHotellissa;
    List<Varaus> varauksetEtukateen;
    Hotelli hotelli;

    public VarauksenTeko(Hotelli hotelli) {
        this.hotelli = hotelli;
        this.varauksetHotellissa = new LinkedList<>();
        this.varauksetEtukateen = new LinkedList<>();
    }

    public List<Huone> vapaatHuoneet(Date aloitusAika, Date lopetusAika, int asiakkaidenMaara) {
        List<Huone> vapaatHuoneet = new ArrayList<>();
        //etsitään vapaita huoneita
        return vapaatHuoneet;
    }

    public boolean varmistaVaraus(Varaus varaus, List<Huone> huoneet) {
        varaus.setHuoneet(huoneet);
        Iterator var3 = huoneet.iterator();

        Huone huone;
        do {
            if (!var3.hasNext()) {
                varaus.varmistaVaraus();
                if (varaus.alkupera.equals(VarauksenAlkupera.ETUKATEEN)) {
                    return varauksetEtukateen.add(varaus);
                }

                if (varaus.alkupera.equals(VarauksenAlkupera.HOTELLISSA)) {
                    return varauksetHotellissa.add(varaus);
                }
                return false;
            }
            huone = (Huone) var3.next();
        } while(this.tarkistaHuoneidenSaatavuus(huone, varaus.getAloitusAika(), varaus.getLopetusAika()));
                    return false;
                }

                public boolean tarkistaHuoneidenSaatavuus (Huone huone, Date aloitusAika, Date lopetusAika){
                    // katsoo etukäteen varattujen jonon
                    List<Varaus> huoneVaraukset = (List)this.varauksetEtukateen.stream().filter((e) -> {
                        return e.getHuoneet().contains(huone);
                    }).collect(Collectors.toList());
                    // varaus epäonnistuu, jos huoneita ei ole saatavilla
                    return true;
                }

                public List<Varaus> getVarauksetHotellissa () {
                    return this.varauksetHotellissa;
                }
                public void getVarauksetHotellissa (List < Varaus > varauksetHotellissa) {
                    this.varauksetHotellissa = varauksetHotellissa;
                }
                public List<Varaus> getVarauksetEtukateen () {
                    return this.varauksetEtukateen;
                }
                public void getVarauksetEtukateen (List < Varaus > varauksetEtukateen) {
                    this.varauksetEtukateen = varauksetEtukateen;
                }
            }
