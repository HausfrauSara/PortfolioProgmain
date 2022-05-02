package project.market;

import java.util.Random;

//Die Klasse Producer ist der Produzent, der Brot und Nudeln aus den Rohstoffen herstellt und diese dann an den Marktplatz liefert
public class Producer implements Runnable {
    private int product1;
    private int product2;
    private int finishedRuns = 0;
    public Producer(){
        product1 = new Random().nextInt(5);
        product2 = new Random().nextInt(5);
        while (product1 == product2){
           product2 = new Random().nextInt(5);
        }


    }
    public void run() {
        while(this.finishedRuns < 20) {

            for(int i = 0; i< 2; i++){
                if(product1 == 0 || product2 == 0){
                    this.produceBread();
                }
                if(product1 == 1 || product2 == 1){
                    this.produceNoodles();
                }
                if(product1 == 2 || product2 == 2){
                    this.produceRyeBread();
                }
                if(product1 == 3 || product2 == 3){
                    this.produceRyeBun();
                }
                if(product1 == 4 || product2 == 4){
                    this.produceBun();
                }

            }


            try {
                Thread.sleep(MarketPlace.pause);
                this.finishedRuns++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    //Die Methode produceBread produziert Brot, aber nur wenn die Ressourcen dafür vorhanden sind
    private void produceBread() {
        if (MarketPlace.salt > 0 && MarketPlace.wheatflour > 0 && MarketPlace.yeast > 0){
            MarketPlace.bread++;
            MarketPlace.salt--;
            MarketPlace.wheatflour--;
            MarketPlace.yeast--;
            System.out.println("Die Rohstoffe Salz, Weizenmehl und Hefe wurden verbraucht. \n" +
                    "Ein Brot wurde gebacken und an den Marktplatz geliefert! \n" + "Brot: " + MarketPlace.bread);
        }
    }
    private void produceRyeBread() {
        if (MarketPlace.salt > 0 && MarketPlace.ryeflour > 0 && MarketPlace.yeast > 0){
            MarketPlace.ryeBread++;
            MarketPlace.salt--;
            MarketPlace.ryeflour--;
            MarketPlace.yeast--;
            System.out.println("Die Rohstoffe Salz, Roggenmehl und Hefe wurden verbraucht. \n" +
                    "Ein Roggenbrot wurde gebacken und an den Marktplatz geliefert! \n" + "Roggenbrot: " + MarketPlace.ryeBread);
        }
    }  private void produceBun() {
        if (MarketPlace.salt > 0 && MarketPlace.wheatflour > 0 && MarketPlace.yeast > 0){
            MarketPlace.bun++;
            MarketPlace.salt--;
            MarketPlace.wheatflour--;
            MarketPlace.yeast--;
            System.out.println("Die Rohstoffe Salz, Weizenmehl und Hefe wurden verbraucht. \n" +
                    "Ein Brötchen wurde gebacken und an den Marktplatz geliefert! \n" + "Brötchen: " + MarketPlace.bun);
        }
    }  private void produceRyeBun() {
        if (MarketPlace.salt > 0 && MarketPlace.ryeflour > 0 && MarketPlace.yeast > 0){
            MarketPlace.ryeBun++;
            MarketPlace.salt--;
            MarketPlace.ryeflour--;
            MarketPlace.yeast--;
            System.out.println("Die Rohstoffe Salz, Roggenmehl und Hefe wurden verbraucht. \n" +
                    "Ein Roggenbrötchen wurde gebacken und an den Marktplatz geliefert! \n" + "RoggenBrötchen: " + MarketPlace.ryeBun);
        }
    }





    //Die Methode produceNoodles produziert Nudeln, aber nur wenn die Ressourcen dafür vorhanden sind.
    private void produceNoodles() {
        if (MarketPlace.water > 0 && MarketPlace.wheatflour > 0) {
            MarketPlace.noodles++;
            MarketPlace.water--;
            MarketPlace.wheatflour--;
            System.out.println("Die Rohstoffe Wasser und Weizenmehl wurden verbraucht. \n" +
                    "Ein Pack Nudeln wurde hergestellt und an den Marktplatz geliefert! \n" + "Nudeln: " + MarketPlace.noodles);
        }
    }
}
