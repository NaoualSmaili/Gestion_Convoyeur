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
        /*    System.out.println("Waiting for ChariotPlein to begin...");
            while (!chariot.estPlein()) {
                System.out.println("Prêt a dechargé!");
                chariot.notifyAll();
                for (int i = chariot.marchandisesC.size() - 1; i >= 0; i--) {
                    if (stock.estVide()) {
                        break;
                    };
                    MdseObjet m = chariot.getMarchandisesC().get(i);
                    System.out.println("Marchandise " + m + " va etre supprimee du chariot");
                    chariot.marchandisesC.remove(i);
                    chariot.setPoidsUsed(2, m.getPoids());
                    System.out.println("poids restant dans le chariot: " + chariot.getPoidsRestant());
                }
            }
            System.out.println("Stock vide, dechargement fini");
            try {
                chariot.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            while (!stock.estVide()){
                if (chariot.estVide()){
                    try {
                        System.out.println("Dechargeur wait");
                        chariot.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("\nPrêt a dechargé!");
                while (!chariot.estVide()){
                    int i = chariot.marchandisesC.size() - 1;
                    if(i >= 0){
                        MdseObjet m = chariot.getMarchandisesC().get(i);
                        System.out.println("Marchandise " + m + " va etre supprimee du chariot");
                        chariot.marchandisesC.remove(i);
                        chariot.setPoidsUsed(2, m.getPoids());
                    }
                    System.out.println("poids restant dans le chariot: " + chariot.getPoidsRestant());
                }
                chariot.notify();
            }
            System.out.println("Dechargeur resumed");
        }

    }
}
