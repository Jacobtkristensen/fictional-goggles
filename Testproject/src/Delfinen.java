import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Delfinen {





	public void hentkontingent() {
		// TODO - implement Delfinen.hentkontingent
		throw new UnsupportedOperationException();
	}

	public void registrerBetaling() {
		// TODO - implement Delfinen.registrerBetaling
		throw new UnsupportedOperationException();
	}

	public void hentRestanceOversigt() {
		// TODO - implement Delfinen.hentRestanceOversigt
		throw new UnsupportedOperationException();
	}

	public static void main(String[] args) {
		// TODO - implement Delfinen.main
		ArrayList<Medlem> medlemmer = new ArrayList<>();
		Medlem.opretMedlem(medlemmer);
		for(Medlem m:medlemmer){
			System.out.println(m);
		}
/*
		System.out.println("Hvad �nsker du at g�re? ");
		System.out.println("[1] Stamoplysninger.");
		System.out.println("[2] Kontingentoplysninger.");
		System.out.println("[3] Sv�mmeresultater.");
		System.out.println("[4] Indl�s eller skriv til Medlemsfil.");

		try { //Hovedmenu.
			Scanner scn = new Scanner(System.in);

			switch (scn.nextInt()) {
				case 1: Menu.StamoplysningMenu();
				case 2: Menu.Kontingentmenu();
				case 3: Menu.Sv�mmeresultatMenu();
				case 4: Menu.Indl�sSkrivMedlemsfil();
			}
		} catch (Exception e) {
			System.out.println("Forkert indtastning, pr�v igen");
		}

*/
		System.out.println("hej");

	}
}