import java.util.ArrayList;
import java.util.Scanner;

public class Kontingenter {
    public static void seRestance(ArrayList<Medlem> medlemmer) {
        for(Medlem m: medlemmer) {
            if (!m.getHarBetalt()) {
                System.out.println(m.printTilKonsol());
            }
        }
    }

    public static ArrayList<Medlem> regBetaling(ArrayList<Medlem> medlemmer) {
        Medlemsadministration.seMedlemsListe( medlemmer);
        System.out.println("Indtast medlemsnummer");

        Scanner scn = new Scanner(System.in);
        int mnr = -1;
        mnr=scn.nextInt();
        medlemmer.get(mnr-1).setHarBetalt();
        return medlemmer;

    }
    public static void kontingentliste(ArrayList<Medlem> medlemmer) {

        System.out.println("Det koster ekstra");
        for (Medlem m:medlemmer){
            System.out.println(m.beregnKontingent());
        }
    }
    }
