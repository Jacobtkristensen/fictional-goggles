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
		System.out.println("Hvad ønsker du at gøre? ");
		System.out.println("[1] Stamoplysninger.");
		System.out.println("[2] Kontingentoplysninger.");
		System.out.println("[3] Svømmeresultater.");
		System.out.println("[4] Indlæs eller skriv til Medlemsfil.");

		try { //Hovedmenu.
			Scanner scn = new Scanner(System.in);

			switch (scn.nextInt()) {
				case 1: Menu.StamoplysningMenu();
				case 2: Menu.Kontingentmenu();
				case 3: Menu.SvømmeresultatMenu();
				case 4: Menu.IndlæsSkrivMedlemsfil();
			}
		} catch (Exception e) {
			System.out.println("Forkert indtastning, prøv igen");
		}

*/
		System.out.println("hej");

	}
}