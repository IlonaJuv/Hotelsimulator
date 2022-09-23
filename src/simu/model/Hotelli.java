package simu.model;

import java.util.List;

public class Hotelli {
    List<Huone> huoneet;

    public Hotelli(List<Huone> huoneet) {
        this.huoneet = huoneet;
    }

    public List<Huone> getHuoneet() {
        return huoneet;
    }
}