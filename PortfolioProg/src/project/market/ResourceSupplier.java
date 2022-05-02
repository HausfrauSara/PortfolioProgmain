package project.market;


//Die Klasse ResourceSupplier ist der Rohstofflieferant, der die verschiedenen Rohstoffe liefert
public class ResourceSupplier implements Runnable{
        //extends Thread implements ResourceSupplierDistribute{
    private int finishedRuns = 0;

    public void run() {
        while(this.finishedRuns < 20) {
            this.distributeResource(this.generateRandom());

            try {
                Thread.sleep(MarketPlace.pause);
                this.finishedRuns++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private void distributeResource(int prodNr) {
        // Die Schleife läuft zweimal durch, da immer zwei Rohstofftypen pro Zeiteinheit in einer Menge von 5 -10 Einheiten geliefert werden.
        for(int i=1; i<=2; i++) {
            switch(prodNr) {
                case 1: {
                    MarketPlace.wheatflour = this.marketResource(MarketPlace.wheatflour, "Weizenmehl");
                    break;
                }
                case 2: {
                    MarketPlace.salt = this.marketResource(MarketPlace.salt, "Salz");
                    break;
                }
                case 3: {
                    MarketPlace.yeast = this.marketResource(MarketPlace.yeast, "Hefe");
                    break;
                }
                case 4: {
                    MarketPlace.water = this.marketResource(MarketPlace.water, "Wasser");
                    break;
                }
                case 5: {
                    MarketPlace.ryeflour = this.marketResource(MarketPlace.ryeflour, "Roggenmehl");
                    break;
                }
            }
        }
    }

    //Ein case aus der distributeResource wird zufällig mit dieser Methode ausgewählt
    public int generateRandom() {
        double randomNr = Math.random()*5;
        randomNr = Math.ceil(randomNr);
        return (int)randomNr;
    }

    //Diese Methoden generieren zufällig eine Menge von 5 -10 Einheiten und liefert diese an den Marktplatz aus
    public int generateRandomAmountsOfUnit() {
        double random2 = Math.random()*5 + 5;
        random2 = Math.ceil(random2);
        return (int)random2;
    }

    public int marketResource(int resourceMarketPlace, String type) {
        int generatedAmount = this.generateRandomAmountsOfUnit();
        resourceMarketPlace += generatedAmount;
        int resource = resourceMarketPlace;
        System.out.println(type + " wurde " + generatedAmount + " mal" + " geliefert!" + "\n" + type + ": " + resource);
        return resourceMarketPlace;
    }

}
