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
		Scanner sc=new Scanner(System.in);
		System.out.println("vil du oprette et nyt medlem? ");
		String userinput=sc.next();
		if(userinput.equalsIgnoreCase("j")){
			do{
				Medlem.opretMedlem(medlemmer);
				System.out.println("vil du oprette endnu et medlem? J/N: ");
				userinput= sc.next();
			}while (!userinput.equalsIgnoreCase("n"));

		}

		for(Medlem m:medlemmer){
			System.out.println(m);
		}
		Konkurrencesv�mmer m1=(Konkurrencesv�mmer) medlemmer.get(0);
		m1.getDiscipliner()[0].opdaterResutater(1);
		System.out.println(m1);
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