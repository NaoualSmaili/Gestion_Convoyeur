import java.util.ArrayList;

public class Chariot {
    int poidsMax;
    ArrayList<MdseObjet> marchandisesC;
    MdseStock stock;
    static int poidsUsed = 0;

    public Chariot(int poidsMax, MdseStock stock) {
        this.poidsMax = poidsMax;
        marchandisesC = new ArrayList<>(poidsMax);
        this.stock = stock;
    }

    public int getPoidsRestant() {
        return (poidsMax - poidsUsed);
    }

    public void setPoidsUsed(int cmp, int poidMdse) {
        if (cmp == 1) {
            poidsUsed += poidMdse;
        } else if (cmp == 2) {
            poidsUsed -= poidMdse;
        }
    }

    public boolean estVide() {
        return marchandisesC.size() == 0;
    }

    public ArrayList<MdseObjet> getMarchandisesC() {
        return marchandisesC;
    }

    boolean placeDispo(int poidMarchandise) {
        if ((poidMarchandise + poidsUsed) <= poidsMax) return true;
        else return false;
    }
}
