package simu.objects;

import java.util.ArrayList;
import java.util.List;
public class Tuoli {
    private List<VapaatTuolit>vapaattuolit;
    public Tuoli(){
        this.vapaattuolit = new ArrayList<>();
    }
    public void lisaaTuoli(VapaatTuolit vapaatuoli){
        if(!vapaattuolit.contains(vapaatuoli)){
            vapaattuolit.add(vapaatuoli);
        }
    }
    public List<VapaatTuolit> getVapaattuolit(){
        return vapaattuolit;
    }
    @Override
    public String toString(){
        return "Tuoleja vapaana: " + vapaattuolit;
    }
}
