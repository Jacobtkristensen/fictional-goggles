import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Delfinen {

/*public static ArrayList<Medlem> indl�sMedlemmer() throws FileNotFoundException {
	//Scanner medlemsliste=new Scanner(new File("medlemsliste.txt"));
	/* indl�se medlemmer og gemme dem i hukommelsen som de er skabt kan g�res med ObjectInputStream, men da alle medlemmer
	   er ens, kr�ver det at de typecastes ved indl�sning: jeg forestiller mig at vi kan tilf�je et felt i medlemsklassen: String type="";
	   og hvert medlem som oprettes f�r en type p� sig: PassivMedlem, Konkurrencesv�mmer eller Medlem
	   samtidig tilf�jes en getType() til medlemsklassen som arves.

	ArrayList<Medlem> medlemmer=new ArrayList<>();
	File medlemsliste=new File("medlemsliste.txt");
	try{
		ObjectInputStream objin=new ObjectInputStream(new FileInputStream(medlemsliste));
		Medlem frafil=null;
		do {
			try {
				frafil = (Medlem) objin.readObject();
				medlemmer.add(frafil);
			}
			catch (ClassNotFoundException c){
				System.out.println("this sucks: "+c);
			}
		} while (frafil.getMedlemsnummer()<Medlem.getMedlemmer()); //hvis det her virker s� er vi hjemme
		objin.close();


	}
	catch (IOException e) {
		System.out.println("something sucked "+e);
	}
	return medlemmer;*/


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

	public static void main(String[] args) throws Exception {
		// TODO - implement Delfinen.main
	//ArrayList<Medlem> medlemmer=new ArrayList<>();
		//medlemmer=Medlem.indl�sMedlemmer();
		for(Medlem m: Medlem.indl�sMedlemmer()){
			System.out.println(m.printTilKonsol());
		}

	/*	ArrayList<Medlem> medlemmer = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		System.out.println("vil du oprette et nyt medlem? ");
		String userinput = sc.next();
		if (userinput.equalsIgnoreCase("j")) {
			do {
				Medlem.opretMedlem(medlemmer);
				System.out.println("vil du oprette endnu et medlem? J/N: ");
				userinput = sc.next();
			} while (!userinput.equalsIgnoreCase("n"));

		}

		for (Medlem m : medlemmer) {
			System.out.println(m.printTilKonsol());
			System.out.println(m);

		}*/
		//Konkurrencesv�mmer m1=(Konkurrencesv�mmer) medlemmer.get(0);
		//m1.getDiscipliner()[0].opdaterResutater(1);
		//System.out.println(m1);
	/*	ArrayList<Medlem> test=new ArrayList<>();
		try {
			test= indl�sMedlemmer();
			System.out.println(test.get(0));
		}
		catch (FileNotFoundException f){
			System.out.println("something went south..sour..sucked.. "+f);
		}*/


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
