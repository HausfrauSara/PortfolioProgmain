package project.market;

//Die Klasse Consumer stellt den Konsumenten dar, der die produzierten Waren vom Marktplatz in bestimmten Mengen kauft
public class Consumer implements Runnable{
    private int finishedRuns = 0;

    public void run() {
        while(this.finishedRuns < 20) {
            this.buyProduct(this.generateRandomNumber());

            try {
                Thread.sleep(MarketPlace.pause);
                this.finishedRuns++;
                } catch (InterruptedException e) {
                  e.printStackTrace();
            }
        }
    }

    // Diese Methode beschreibt den zufälligen Kauf der produzierten Produkten mit zufälliger Menge
    private void buyProduct(int productCase) {
        switch(productCase) {
            case 1: {
                MarketPlace.bread = this.product(MarketPlace.bread, "Brot");
            }
            case 2: {
                MarketPlace.noodles = this.product(MarketPlace.noodles, "Nudeln");
            }
            case 3: {
                MarketPlace.bun = this.product(MarketPlace.bun, "Brötchen");
            }
            case 4: {
                MarketPlace.ryeBread = this.product(MarketPlace.ryeBread, "Roggenbrot");
            }
            case 5: {
                MarketPlace.ryeBun = this.product(MarketPlace.ryeBun, "Roggenbrötchen");
            }
        }
    }
    //Diese Methode generiert eine zufällige Zahl für die buyProduct Methode
    public int generateRandomNumber() {
        double random = Math.random()*5;
        return (int)random;
    }
    //Diese Methode generiert eine zufällige Zahl für die product Methode
    public int generateRandomUnit() {
        double random2 = Math.random()*3 + 2;;
        random2 = Math.ceil(random2);
        return (int)random2;
    }
    //Diese Methode wählt ein zufälliges Produkt mit einer zufälligen Menge und kauft dieses
    public int product(int productType, String productName) {
        int amount = this.generateRandomUnit();
        if(amount <= productType && productType > 0) {
            productType -= amount;
            System.out.println(productName + " wurde " + amount + " mal gekauft! \n" +
                    "übrige Menge: " + productType);
        } else{
            System.out.println("--> keine ausreichende Menge an " + productName + " vorhanden");
        }
        return productType;
    }
}

