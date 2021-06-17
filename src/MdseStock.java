import java.util.ArrayList;

public class MdseStock {
    int tailleStock;
    ArrayList<MdseObjet> marchandisesS;

    public MdseStock(int tailleStock) {
        this.tailleStock = tailleStock;
        //Remplire le stock dans le constructeur avec des marchandises
        marchandisesS = new ArrayList<>(tailleStock);
        for (int i = 0; i < tailleStock; i++) {
            MdseObjet m = new MdseObjet();
            marchandisesS.add(m);
        }
    }

    boolean estVide() {
        return tailleStock == 0;
    }

    public int getTailleStock() {
        return tailleStock;
    }

    MdseObjet extraireElement() {
        MdseObjet element;
        element = marchandisesS.get(tailleStock - 1); // get the last element
        marchandisesS.remove(element); //delete it from the list
        tailleStock--;
        return element;  //return it
    }

    MdseObjet depilerStock(int i) {
        MdseObjet element;
        element = marchandisesS.get(i); // get the last element
        marchandisesS.remove(element); //delete it from the list
        tailleStock--;
        return element;  //return it
    }

    void printStock() {
        for (int i = 0; i < tailleStock; i++) {
            System.out.println("Marchandise: "+ marchandisesS.get(i) + " de poids " + marchandisesS.get(i).getPoids());
        }
    }
}
