package project.market;



//Die Klasse MarketPlace ist der Marktplatz an den die Rohstoffe und fertigen Produkte geliefert werden und die fertigen Produkte verkauft werden.
public class MarketPlace extends Thread
       //Alle Threads sollen Runnable sein aber hier gehts nicht deswegen Thread.
{

    //Die bread und noodle Attribute werden von den Produzenten produziert und von den Konsumenten gekauft
    volatile  static int bread = 0;
    volatile static int noodles = 0;
    volatile static int ryeBread = 0;
    volatile static int ryeBun = 0;
    volatile static int bun = 0;


    // Die wheatflour, water, ryeflour, yeast und salt Attribute werden von den Rohstofflieferanten geliefert und von den Produzenten gekauft
    volatile static int wheatflour = 0;
    volatile static int water = 0;
    volatile static int ryeflour = 0;
    volatile static int yeast = 0;
    volatile static int salt = 0;

    //Mit dem Attribut Pause wird die Pausenzeit der Threads festgelegt
    static int pause = 1000;
    //Erzeugt einen einzigartigen Marktplatz
    private static Thread market = new Thread(new MarketPlace());
    public static Thread getMarket() {
        return market;
    }
}