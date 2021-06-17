public class Chargeur implements Runnable {

    MdseStock stock;
    Chariot chariot;

    public Chargeur(MdseStock stock, Chariot chariot) {
        this.stock = stock;
        this.chariot = chariot;
    }

    @Override
    public void run() {
        synchronized (chariot) {
            while (!stock.estVide()) {
                System.out.println("\nPrêt a chargé!");
                for (int i = stock.getTailleStock() - 1; i >= 0; i--) {
                    if (!stock.estVide()) {
                        if (chariot.placeDispo(stock.marchandisesS.get(i).getPoids())) {
                            MdseObjet m = stock.extraireElement(i);
                            chariot.marchandisesC.add(m);
                            System.out.println("Marchandise " + m + " ajoutée au chariot");
                            chariot.setPoidsUsed(1, m.getPoids());
                            System.out.println("poids restant dans le chariot: " + chariot.getPoidsRestant());
                            System.out.println("Stock taille: " + stock.getTailleStock());
                        }
                    } else break;
                    chariot.notifyAll();
                }
                try {
                    chariot.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("\nChargeur resumed");
        }
    }
}
