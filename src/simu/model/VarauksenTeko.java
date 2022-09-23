package simu.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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
        for (Huone huone : huoneet) {
            if (!tarkistaHuoneidenSaatavuus(huone, varaus.getAloitusAika(), varaus.getLopetusAika())) {
                return false;
            }
        }
        varaus.varmistaVaraus();
        if (varaus.alkupera.equals(VarauksenAlkupera.ETUKATEEN)) {
            return varauksetEtukateen.add(varaus);
        } else {
            if (varaus.alkupera.equals(VarauksenAlkupera.HOTELLISSA)){
                return varauksetHotellissa.add(varaus);
            } else {
                return false;
            }
        }
    }
    public boolean tarkistaHuoneidenSaatavuus(Huone huone, Date aloitusAika, Date lopetusAika){
        // katsoo etukäteen varattujen jonon
        List<Varaus> huoneVaraukset = varauksetEtukateen.stream().filter(e -> e.getHuoneet().contains(huone)).collect(Collectors.toList());
        // varaus epäonnistuu, jos huoneita ei ole saatavilla
        return true;
    }
    public List<Varaus> getVarauksetHotellissa(){
        return varauksetHotellissa;
    }
    public List<Varaus> getVarauksetEtukateen() {
        return varauksetEtukateen;
    }
}
