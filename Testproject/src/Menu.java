import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

public ArrayList<Medlem> medlemmer=new ArrayList<>();

    public static void hovedmenu(ArrayList<Medlem> medlemmer) {



        boolean loop = true;

        while (loop) {
            try {

                System.out.println("Hovedmenu.");
                System.out.println("Hvad �nsker du at g�re?");
                System.out.println("1: Stamoplysninger.");
                System.out.println("2: kontingentoplysninger.");
                System.out.println("3: Sv�mmeresultater.");
                System.out.println("4: Indl�s medlemsliste.");
                System.out.println("0: Forlad program.");

                Scanner scn = new Scanner(System.in);

                switch (scn.nextInt()) {
                    case 0:
                        loop = false;
                        break;
                    case 1:
                        stamoplysninger(medlemmer);
                        break;
                    case 2:
                        kontingentoplysninger(medlemmer);
                        break;
                    case 3:
                        svommeresultater(medlemmer);
                        break;
                    case 4:
                        medlemsliste(medlemmer);
                        break;
                    default:
                        System.out.println("Forkert indtastning, tast 1,2,3 eller 4.");
                }
           } catch (InputMismatchException e) {
                System.out.println("Forkert indtastning, tast 1,2,3 eller 4.");
            }

        }
    }
    public static ArrayList<Medlem> stamoplysninger( ArrayList<Medlem> medlemmer) {
        boolean loop = true;

        while (loop) {
            try {

                System.out.println("Stamoplysninger.");
                System.out.println("Hvad �nsker du at g�re?");
                System.out.println("1: Opret medlem.");
                System.out.println("2: Redigerer Stamoplysninger.");
                System.out.println("3: Slet medlem.");
                System.out.println("4: Se medlemsliste.");
                System.out.println("0: Tilbage til Hovedmenu.");


                Scanner scn = new Scanner(System.in);

                switch (scn.nextInt()) {
                    case 0:
                        loop = false;
                        hovedmenu(medlemmer);
                        break;
                    case 1:
                        opretMedlem(medlemmer);
                        break;
                    case 2:
                        redStamoplysninger(medlemmer);
                        break;
                    case 3:
                        medlemmer= sletMedlem(medlemmer);
                        break;
                    case 4:
                        medlemsliste(medlemmer);
                        break;
                    default:
                        System.out.println("Forker indtastning, tast 1,2,3 eller 4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Forkert indtastning, tast 1,2,3 eller 4.");
            }
        }
        return medlemmer;
    }

    public static ArrayList<Medlem> kontingentoplysninger( ArrayList<Medlem> medlemmer) {

        boolean loop = true;

        while (loop) {
            try {


                System.out.println("kontingentoplysninger.");
                System.out.println("Hvad �nsker du at g�re?");
                System.out.println("1: Se restance.");
                System.out.println("2: Rediger betaling.");
                System.out.println("3: Hent kontingentliste.");
                System.out.println("0: Tilbage til Hovedmenu.");

                Scanner scn = new Scanner(System.in);

                switch (scn.nextInt()) {
                    case 0:
                        loop = false;
                        hovedmenu(medlemmer);
                        break;
                    case 1:
                        Kontingenter.seRestance(medlemmer);
                        break;
                    case 2:
                        Kontingenter.regBetaling(medlemmer);
                        break;
                    case 3:
                        Kontingenter.kontingentliste(medlemmer);
                        break;
                    default:
                        System.out.println("Forkert indtastning, tast 1,2 eller 3.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Forkert indtastning, tast 1,2,3 eller 4.");
            }
        }
        return medlemmer;
    }

    public static void svommeresultater( ArrayList<Medlem> medlemmer) {

        boolean loop = true;
        while(loop) {
            try {


                System.out.println("Sv�mmeresultater.");
                System.out.println("Hvad �nsker du at g�re?");
                System.out.println("1: Opdater resultater.");
                System.out.println("2: Se top 5 sv�mmere.");
                System.out.println("3: Rediger disciplin.");
                System.out.println("4: Se konkurrencesv�mmerliste.");
                System.out.println("0: Tilbage til Hovedmenu.");

                Scanner scn = new Scanner(System.in);

                switch (scn.nextInt()) {
                    case 0: loop = false;
                        hovedmenu(medlemmer);
                        break;
                    case 1:
                        opdaterResultater(medlemmer);
                        break;
                    case 2:
                        seTopFem(medlemmer);
                        break;
                    case 3:
                        redDisciplin();
                        break;
                    case 4:
                        Konkurrencesv�mmer.konkurrencesvoemmerliste(medlemmer);
                        break;
                    default:
                        System.out.println("Forkert indtastning, tast 1,2,3 eller 4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Forkert indtastning, tast 1,2,3 eller 4.");
            }
        }

    }

    public static ArrayList<Medlem> opretMedlem( ArrayList<Medlem> medlemmer) {

        medlemmer = Medlemsadministration.opretMedlem(medlemmer);

        return medlemmer;

    }

    public static ArrayList<Medlem> redStamoplysninger( ArrayList<Medlem> medlemmer) {
        Medlemsadministration.seMedlemsListe( medlemmer);
        System.out.println("Indtast medlemsnummer");

        Scanner scn = new Scanner(System.in);
        int mnr = -1;
        mnr=scn.nextInt();
        try {
            medlemmer= Medlemsadministration.redigerStamoplysninger(medlemmer,mnr);
        } catch (FileNotFoundException e) {
            System.out.println("hovsa: "+e);
        }
        return medlemmer;
    }

    public static ArrayList<Medlem> sletMedlem( ArrayList<Medlem> medlemmer) {
        Medlemsadministration.seMedlemsListe( medlemmer);
        System.out.println("Indtast medlemsnummer");

        Scanner scn = new Scanner(System.in);
        int mnr = -1;
        scn.nextInt();
        medlemmer= Medlemsadministration.sletMedlem( medlemmer,mnr);
        return medlemmer;
    }

    public static void medlemsliste( ArrayList<Medlem> medlemmer) {
          System.out.println("Kald medlemsliste");
          Medlemsadministration.seMedlemsListe( medlemmer);
          hovedmenu(medlemmer);
    }
    public static void opdaterResultater(ArrayList<Medlem> medlemmer) {
        Medlemsadministration.seMedlemsListe( medlemmer);
        System.out.println("Indtast medlemsnummer");

        Scanner scn = new Scanner(System.in);
        int mnr = -1;
        mnr=scn.nextInt();
        Konkurrencesv�mmer k=(Konkurrencesv�mmer) medlemmer.get(mnr-1);

        System.out.println("hvilke discpliner vil tilf�je/�ndre?: ");
        System.out.println("1: brystsv�mning");
        System.out.println("2: crawl");
        System.out.println("3: rygsv�mning");
        System.out.println("4: Butterfly");
        int disciplinnummer=-99;

        switch (scn.nextInt()){
            case 1:
                disciplinnummer=0;
                break;
            case 2:
                disciplinnummer=1;
                break;
            case 3:
                disciplinnummer=2;
                break;
            case 4:
                disciplinnummer=3;
                break;
        }
        System.out.println("tast 1 for tr�ningsresultat, tast 2 for st�vneresultat");
        int tr�nerinput=scn.nextInt();
        //opdaterResultater(Konkurrencesv�mmer k, int disciplinnummer, int tr�nerinput)
        Medlemsadministration.opdaterResultater(k,disciplinnummer,tr�nerinput);
    }

    public static void seTopFem(ArrayList<Medlem> medlemmer) {
        String topFem = "";

        Scanner scn = new Scanner(System.in);

        topFem = disciplin(scn, topFem,medlemmer);
        topFem = kon(scn, topFem,medlemmer);
        topFem = alder(scn, topFem,medlemmer);

        Medlemsadministration.seTop5(medlemmer,topFem);
    }

    public static void redDisciplin() {
        System.out.println("Koster desv�rre ekstra...");
    }
    static String disciplin(Scanner scn, String topFem, ArrayList<Medlem> medlemmer) {

            System.out.println("V�lg Sv�mmedisciplin:");
            System.out.println("1: Bryst");
            System.out.println("2: Crawl");
            System.out.println("3: Rygsv�mning");
            System.out.println("4: Butterfly");
            System.out.println("0: Tilbage til Sv�mmeresultatmenu");

            switch (scn.nextInt()) {
                case 0:
                    svommeresultater(medlemmer);
                    break;
                case 1:
                    topFem = bryst(topFem);
                    break;
                case 2:
                    topFem = crawl(topFem);
                    break;
                case 3:
                    topFem = ryg(topFem);
                    break;
                case 4:
                    topFem = butterfly(topFem);
                    break;
                default:
                    System.out.println("Forkert indtastning, pr�v igen");

            }

        return topFem;
    }

    static String kon(Scanner scn, String topFem, ArrayList<Medlem> medlemmer) {

                System.out.println("V�lg k�n p� sv�mmeren");
                System.out.println("1: Mand");
                System.out.println("2: Kvinde");
                System.out.println("0: Tilbage til Sv�mmeresultatmenu");

                switch (scn.nextInt()) {
                    case 0:
                        svommeresultater(medlemmer);
                        break;
                    case 1:
                        topFem = mand(topFem);
                        break;
                    case 2:
                        topFem = kvinde(topFem);
                        break;
                    default:
                        System.out.println("Forkert indtastning, pr�v igen");

                }
        return topFem;
    }

    static String alder(Scanner scn, String topFem,ArrayList<Medlem> medlemmer) {

                System.out.println("V�lg alder p� sv�mmeren");
                System.out.println("1: Junior");
                System.out.println("2: Senior");
                System.out.println("0: Tilbage til Sv�mmeresultatmenu");

                switch (scn.nextInt()) {
                    case 0:
                        svommeresultater(medlemmer);
                        break;
                    case 1:
                        topFem = junior(topFem);
                        break;
                    case 2:
                        topFem = senior(topFem);
                        break;
                    default:
                        System.out.println("Forkert indtastning, tast 1 eller 2.");

                }
        return topFem;
    }


    public static String bryst(String topFem){
        System.out.println("Bryst sv�mning");
        return topFem.concat("b");
    }
    public static String crawl(String topFem){
        System.out.println("Crawl");
        return topFem.concat("c");
    }
    public static String ryg(String topFem){
        System.out.println("Ryg");
        return topFem.concat("r");
    }
    public static String butterfly(String topFem){
        System.out.println("Butterfly");
        return topFem.concat("f");
    }

    public static String mand(String topFem){
        System.out.println("Mand");
        return topFem.concat("m");
    }

    public static String kvinde(String topFem){
        System.out.println("Kvinde");
        return topFem.concat("k");
    }

    public static String junior(String topFem) {
        System.out.println("Junior");
        return topFem.concat("j");
    }

    public static String senior(String topFem) {
        System.out.println("Senior");
        return topFem.concat("s");
    }


}
