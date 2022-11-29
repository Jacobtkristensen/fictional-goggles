import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Delfinen {

	ArrayList<Medlem> medlemmer=new ArrayList<>();
	public void opretMedlem(medlemmer) {
		// TODO - implement Delfinen.opretMedlem
		Scanner sc=new Scanner(System.in);
		System.out.println("indtast medlemsnavn: ");
		String navn= sc.next();
		System.out.println(" indtast fødselsdag som YYYY-MM-DD: ");
		LocalDate bday=sc.next();
		System.out.println(" indtast køn: M/K: ");
		boolean gender;
		if (sc.next()=="M"||sc.next()="m"){
			gender=true;
		}
		System.out.println("ønsker du at være aktivt medlem? [J/N]");
		if (sc.next()=="n"||sc.next()=="n"){
			Medlem nytmedlem=new PassivMedlem(navn,bday,gender);
			medlemmer.add(nytmedlem);
		}
		System.out.println("ønsker du at være konkurrencesvømmer? [J/N]");
		if (sc.next()=="n"||sc.next()=="n"){
			Medlem nytmedlem=new Motionist(navn,bday,gender);

		// tilføj nyt medlem til ArrayList

		throw new UnsupportedOperationException();
	}

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

	public static void main() {
		// TODO - implement Delfinen.main
		//throw new UnsupportedOperationException();

		System.out.println("hej");
	}

}