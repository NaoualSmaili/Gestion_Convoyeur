public class Test {

    public Test() {
    }

    public static void main(String[] args) throws InterruptedException {
        final int capaciteChariot = 60;
        final int capaciteStock = 20;

        System.out.println("Lancement du programme\n");

        MdseStock stock = new MdseStock(capaciteStock);
        Chariot chariot = new Chariot(capaciteChariot, stock);

        stock.printStock();

        Thread t1 = new Thread(new Chargeur(stock, chariot));
        Thread t2 = new Thread(new Dechargeur(stock, chariot));
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("\nFin du programme");
    }
}
