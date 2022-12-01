import java.util.Scanner;

public class Menu {

   /* System.out.println("Hvad �nsker du at g�re? ");
		System.out.println("[1] Stamoplysninger.");
		System.out.println("[2] Kontingentoplysninger.");
		System.out.println("[3] Sv�mmeresultater.");
		System.out.println("[4] Indl�s eller skriv til Medlemsfil.");

		try { //Hovedmenu.
        Scanner scn = new Scanner(System.in);

        switch (scn.next()) {
            case 1: // kald stamoplysningermenu.
            case 2: // Kontingentmenu.
            case 3: // Sv�mmemenu
            case 4: // Medlemsfil.
        }
    } catch (Exception e) {
        System.out.println("Forkert input, pr�v igen");
    }*/

    public static void StamoplysningMenu() {
        System.out.println("Hvad �nsker du at g�re? ");
        System.out.println("[1] Opret medlem.");
        System.out.println("[2] Rediger stamoplysninger.");
        System.out.println("[3] Slet medlem.");
        System.out.println("[4] Se medlemliste.");

        try {
            Scanner scn = new Scanner(System.in);

            switch (scn.nextInt()) {
                case 1: //Opret Medlem
                case 2: // Rediger stam.
                case 3: // Slet medlem
                case 4: // se medlemsliste
            }
        } catch (Exception e) {
            System.out.println("Forkert input, pr�v igen");
        }
    }
    public static void Kontingentmenu() {
        System.out.println("Hvad �nsker du at g�re? ");
        System.out.println("[1] Se restance.");
        System.out.println("[2] Betalingsoversigt.");

        try {
            Scanner scn = new Scanner(System.in);

            switch (scn.nextInt()) {
                case 1: //Se restance.
                case 2: //Betalingsoversigt.

            }
        } catch (Exception e) {
            System.out.println("Forkert input, pr�v igen");
        }

    }

    public static void Sv�mmeresultatMenu() {
        System.out.println("Hvad �nsker du at g�re? ");
        System.out.println("[1] Opdater resultater.");
        System.out.println("[2] Se top 5 sv�mmere.");
        System.out.println("[3] Rediger discipliner.");
        System.out.println("[4] Se konkurrencesv�mmere.");
        try {
            Scanner scn = new Scanner(System.in);

            switch (scn.nextInt()) {
                case 1: //opdater res.
                case 2: //Top 5.
                case 3: //red disc.
                case 4: //Se konSv�m
            }
        } catch (Exception e) {
            System.out.println("Forkert input, pr�v igen");
        }

    }

    public static void OpdaterResultater();
        System.out.println("Hvad �nsker du at g�re? ");
        System.out.println("[1] Opdater resultater.");
        System.out.println("[2] Se top 5 sv�mmere.");
        System.out.println("[3] Rediger discipliner.");
        System.out.println("[4] Se konkurrencesv�mmere.");
        try {
        Scanner scn = new Scanner(System.in);

        switch (scn.nextInt()) {
            case 1: //opdater res.
            case 2: //Top 5.
            case 3: //red disc.
            case 4: //Se konSv�m
        }
    } catch (Exception e) {
        System.out.println("Forkert input, pr�v igen");
    }

    public static void Indl�sSkrivMedlemsfil() {
        System.out.println("Hvad �nsker du at g�re? ");
        System.out.println("[1] Indl�s medlemsfil.");
        System.out.println("[2] Rediger i eksisterende medlemmer.");

        try {
            Scanner scn = new Scanner(System.in);

            switch (scn.nextInt()) {
                case 1: //indl�s medlemsfil.
                case 2: //rediger i medlemsfil.

            }
        } catch (Exception e) {
            System.out.println("Forkert input, pr�v igen");
        }

    }

}
