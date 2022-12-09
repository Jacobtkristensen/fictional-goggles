import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Delfinen {


	public static void main(String[] args) throws Exception {

		File memberlist=new File("medlemsliste.txt");
		if (memberlist.exists()) System.out.println("filen findes");



	ArrayList<Medlem> medlemmer=Medlemsadministration.indlæsMedlemmer();








//		for(Medlem m: medlemmer){
//			System.out.println(m.printTilKonsol());

		Menu.hovedmenu(medlemmer);


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
			Medlem.skrivMedlemmerTilFil(m);
		}

		}*/
		//Konkurrencesvømmer m1=(Konkurrencesvømmer) medlemmer.get(0);
		//m1.getDiscipliner()[0].opdaterResutater(1);
		//System.out.println(m1);
	/*	ArrayList<Medlem> test=new ArrayList<>();
		try {
			test= indlæsMedlemmer();
			System.out.println(test.get(0));
		}
		catch (FileNotFoundException f){
			System.out.println("something went south..sour..sucked.. "+f);
		}*/


		//Indlæs medlemsliste, hvis tom opret nogle medlemmer.





		System.out.println("hej");

	}
}
