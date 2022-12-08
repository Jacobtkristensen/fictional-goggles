import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {



    public static void hovedmenu() {
       try{
        File memberlist=new File("medlemsliste.txt");
        if (memberlist.exists()) {
            ;
            ArrayList<Medlem> medlemmer = Medlemsadministration.indl�sMedlemmer();
        }
        else {
            ArrayList<Medlem> medlemmer=new ArrayList<>();
        }
       }
       catch (Exception e){
           System.out.println("Der opstod en fejl: "+e);
       }


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
                        stamoplysninger();
                        break;
                    case 2:
                        kontingentoplysninger();
                        break;
                    case 3:
                        svommeresultater();
                        break;
                    case 4:
                        medlemsliste();
                        break;
                    default:
                        System.out.println("Forkert indtastning, tast 1,2,3 eller 4.");
                }
           } catch (InputMismatchException e) {
                System.out.println("Forkert indtastning, tast 1,2,3 eller 4.");
            }

        }
    }
    public static void stamoplysninger( ArrayList<Medlem> medlemmer) {
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
                        hovedmenu();
                        break;
                    case 1:
                        opretMedlem();
                        break;
                    case 2:
                        redStamoplysninger(medlemmer);
                        break;
                    case 3:
                        medlemmer= sletMedlem(medlemmer);
                        break;
                    case 4:
                        medlemsliste();
                        break;
                    default:
                        System.out.println("Forker indtastning, tast 1,2,3 eller 4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Forkert indtastning, tast 1,2,3 eller 4.");
            }
        }
    }

    public static void kontingentoplysninger( ArrayList<Medlem> medlemmer) {

        boolean loop = true;

        while (loop) {
            try {


                System.out.println("kontingentoplysninger.");
                System.out.println("Hvad �nsker du at g�re?");
                System.out.println("1: Se restance.");
                System.out.println("2: Redigerer betaling.");
                System.out.println("3: Hent kontingentliste.");
                System.out.println("0: Tilbage til Hovedmenu.");

                Scanner scn = new Scanner(System.in);

                switch (scn.nextInt()) {
                    case 0:
                        loop = false;
                        hovedmenu();
                        break;
                    case 1:
                        seRestance();
                        break;
                    case 2:
                        redBetaling();
                        break;
                    case 3:
                        kontingentliste();
                        break;
                    default:
                        System.out.println("Forker indtastning, tast 1,2 eller 3.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Forkert indtastning, tast 1,2,3 eller 4.");
            }
        }
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
                        hovedmenu();
                        break;
                    case 1:
                        opdaterResultater();
                        break;
                    case 2:
                        seTopFem();
                        break;
                    case 3:
                        redDisciplin();
                        break;
                    case 4:
                        konkurrencesvoemmerliste();
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
        System.out.println("kald opretMedlem metode");
        medlemmer= Medlemsadministration.opretMedlem(medlemmer);
        return medlemmer;

    }

    public static ArrayList<Medlem> redStamoplysninger( ArrayList<Medlem> medlemmer) {
        Medlemsadministration.seMedlemsListe( medlemmer);
        System.out.println("Indtast medlemsnummer");

        Scanner scn = new Scanner(System.in);
        int mnr = -1;
        mnr=scn.nextInt();
        medlemmer= Medlemsadministration.redigerStamoplysninger(medlemmer,mnr);
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
    }

    public static void seRestance() {
        System.out.println("Kald restanceliste");
    }

    public static ArrayList<Medlem> redBetaling(ArrayList<Medlem> medlemmer) {
        System.out.println("kald betalingsliste");
    }

    public static void kontingentliste() {
        System.out.println("Kald kontingentliste (medlemsliste??)");
    }

    public static void opdaterResultater() {
        System.out.println("Kald metode for opdater resultater");
    }

    public static void seTopFem() {
        String topFem = "";

        Scanner scn = new Scanner(System.in);

        topFem = disciplin(scn, topFem);
        topFem = kon(scn, topFem);
        topFem = alder(scn, topFem);



        System.out.println(topFem);
    }

    public static void redDisciplin() {
        System.out.println("kald rediger disciplin metode");
    }

    public static void konkurrencesvoemmerliste() {
        System.out.println("kald konkurrencesv�mmerliste");

    }
    static String disciplin(Scanner scn, String topFem) {

            System.out.println("V�lg Sv�mmedisciplin:");
            System.out.println("1: Bryst");
            System.out.println("2: Crawl");
            System.out.println("3: Rygsv�mning");
            System.out.println("4: Butterfly");
            System.out.println("0: Tilbage til Sv�mmeresultatmenu");

            switch (scn.nextInt()) {
                case 0:
                    svommeresultater();
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

    static String kon(Scanner scn, String topFem) {

                System.out.println("V�lg k�n p� sv�mmeren");
                System.out.println("1: Mand");
                System.out.println("2: Kvinde");
                System.out.println("0: Tilbage til Sv�mmeresultatmenu");

                switch (scn.nextInt()) {
                    case 0:
                        svommeresultater();
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

    static String alder(Scanner scn, String topFem) {

                System.out.println("V�lg alder p� sv�mmeren");
                System.out.println("1: Junior");
                System.out.println("2: Senior");
                System.out.println("0: Tilbage til Sv�mmeresultatmenu");

                switch (scn.nextInt()) {
                    case 0:
                        svommeresultater();
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
