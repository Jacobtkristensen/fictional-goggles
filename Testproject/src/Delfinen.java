import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Delfinen {

/*public static ArrayList<Medlem> indlæsMedlemmer() throws FileNotFoundException {
	//Scanner medlemsliste=new Scanner(new File("medlemsliste.txt"));
	/* indlæse medlemmer og gemme dem i hukommelsen som de er skabt kan gøres med ObjectInputStream, men da alle medlemmer
	   er ens, kræver det at de typecastes ved indlæsning: jeg forestiller mig at vi kan tilføje et felt i medlemsklassen: String type="";
	   og hvert medlem som oprettes får en type på sig: PassivMedlem, Konkurrencesvømmer eller Medlem
	   samtidig tilføjes en getType() til medlemsklassen som arves.
	*/
/*	ArrayList<Medlem> medlemmer=new ArrayList<>();
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
		} while (frafil.getMedlemsnummer()<Medlem.getMedlemmer()); //hvis det her virker så er vi hjemme
		objin.close();


	}
	catch (IOException e) {
		System.out.println("something sucked "+e);
	}
	return medlemmer;

}

/*public static void skrivMedlemmerTilFil(Medlem o) throws FileNotFoundException {
	File medlemsliste=new File("medlemsliste.txt");
	if(o instanceof Medlem) {
		try {
			ObjectOutputStream objout = new ObjectOutputStream(new FileOutputStream(medlemsliste, true));
			objout.defaultWriteObject(o);
			objout.close();
		} catch (Exception e) {
			System.out.println("something went wrong.... " + e);
		}
	}
}*/


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

		//Indlæs medlemsliste, hvis tom opret nogle medlemmer.
		//Menu.hovedmenu();


		System.out.println("hej");

	}
}