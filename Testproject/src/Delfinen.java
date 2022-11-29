import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Delfinen {



	public static ArrayList<Medlem> opretMedlem(ArrayList<Medlem> medlemmer) {
		// TODO - implement Delfinen.opretMedlem
		Scanner sc=new Scanner(System.in);
		System.out.println("indtast medlemsnavn: ");
		String navn= sc.next();
		System.out.println(" indtast f�dselsdag som YYYY-MM-DD: ");
		//DateTimeFormatter format = DateTimeFormatter.ofPattern("YYYY-MM-DD");
		String date =sc.next();

		//convert String to LocalDate
		LocalDate bday = LocalDate.parse(date);






		System.out.println(" indtast k�n: M/K: ");
		boolean gender=false;
		if (sc.next().equalsIgnoreCase("M")){
			gender=true;
		}
		System.out.println("�nsker du at v�re aktivt medlem? [J/N]");
		if (sc.next().equalsIgnoreCase("N")){
			Medlem nytmedlem=new PassivMedlem(navn,bday,gender);
			medlemmer.add(nytmedlem);
			return medlemmer;
		}
		System.out.println("�nsker du at v�re konkurrencesv�mmer? [J/N]");
		if (sc.next().equalsIgnoreCase("n")) {
			Medlem nytmedlem = new Medlem(navn, bday, gender);
			medlemmer.add(nytmedlem);
			return medlemmer;
		}
		String aktivdisciplin="";
		System.out.println("tast de discipliner du vil stille op i, uden komma i mellem: ");
		System.out.println("brystsv�mnin=b, crawl=c, ryg=r, butterfly=f");
		aktivdisciplin=aktivdisciplin.concat(sc.next());

			Medlem nytmedlem=new Konkurrencesv�mmer(navn, bday, gender, aktivdisciplin);
			medlemmer.add(nytmedlem);
			return medlemmer;



		// tilf�j nyt medlem til ArrayList


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

	public static void main(String[] args) {
		// TODO - implement Delfinen.main
		ArrayList<Medlem> medlemmer=new ArrayList<>();
		opretMedlem(medlemmer);

		System.out.println("hej");
	}

}