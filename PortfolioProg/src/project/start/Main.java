package project.start;

import project.market.Consumer;
import project.market.MarketPlace;
import project.market.Producer;
import project.market.ResourceSupplier;
// oder market.*

public class Main {

    public static void main(String[] args) {
        //Es wird der Marktplatz rangeholt und gestartet
        MarketPlace.getMarket().start();
        //Es werden drei ResourceSupplierobjekte erzeugt und gestartet
        for(int i=1; i<=3; i++) {
            new Thread(new ResourceSupplier()).start();
        }
        //Es werden drei Poducerobjekte erzeugt und gestartet
        for(int i=1; i<=3; i++) {
            new Thread(new Producer()).start();
        }
        //Es werden fünf Consumerobjekte erzeugt und gestartet
        for(int i=1; i<=5; i++) {
            new Thread(new Consumer()).start();
        }
    }
}
