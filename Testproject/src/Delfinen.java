import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Delfinen {


	public static void main(String[] args) throws Exception {

		File memberlist=new File("medlemsliste.txt");
		if (memberlist.exists()) System.out.println("filen findes");



	ArrayList<Medlem> medlemmer=Medlemsadministration.indl�sMedlemmer();








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


		//Indl�s medlemsliste, hvis tom opret nogle medlemmer.





		System.out.println("hej");

	}
}
