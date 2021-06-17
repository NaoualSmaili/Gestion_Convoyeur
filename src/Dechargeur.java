public class Dechargeur implements Runnable {

    MdseStock stock;
    Chariot chariot;

    public Dechargeur(MdseStock stock, Chariot chariot) {
        this.stock = stock;
        this.chariot = chariot;
    }

    @Override
    public void run() {
        synchronized (chariot) {
            while (!stock.estVide()) {
                if (chariot.estVide()) {
                    try {
                        chariot.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("\nPrêt a dechargé!");
                while (!chariot.estVide()) {
                    for (int i = chariot.marchandisesC.size() - 1; i >= 0; i--) {
                        MdseObjet m = chariot.getMarchandisesC().get(i);
                        System.out.println("Marchandise " + m + " va etre supprimee du chariot");
                        chariot.marchandisesC.remove(i);
                        chariot.setPoidsUsed(2, m.getPoids());
                        System.out.println("poids restant dans le chariot: " + chariot.getPoidsRestant());
                    }
                }
                chariot.notify();
            }
            System.out.println("\nDechargeur resumed");
        }

    }
}
