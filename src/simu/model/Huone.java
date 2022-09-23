package simu.model;

public class Huone {
    int vieraidenMaara;

    public Huone(int vieraidenMaara){
        this.vieraidenMaara = vieraidenMaara;
    }

    @Override
    public String toString() {
        return "Huone{" +
                "vieraidenMaara=" + vieraidenMaara +
                '}';
    }
}
