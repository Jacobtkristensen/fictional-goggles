import java.util.Scanner;

public class Svømmedisciplin {

	private String disciplinNavn;
	private Resultat resultater;

	public Svømmedisciplin(String disciplinNavn){
		this.disciplinNavn=disciplinNavn;
		this.resultater=new Resultat();
	}

	public void opdaterResutater(int trænerinput) { //del af trænerens muligheder
		// TODO - implement Svømmedisciplin.opdaterResutater
		Scanner sc= new Scanner(System.in);
		//System.out.println("[1]: træningsresultat \n[2]: stævneresultat ");
		//System.out.println("indtast valg"); //husk try-catch eller default...
		//String input=sc.nextInt();
		switch (trænerinput){
			case 1:
			System.out.println("indtast træningsdato som [YYYY-MM-DD]: ");
			String dato=sc.next();
			System.out.println("indtast træningstid som [HH:MM:SS,nn]: ");
			String træningstid=sc.next();
			this.resultater.setTræningsresultater(dato,træningstid);
			break;
			case 2:
				System.out.println("indtast stævnenavn");
				String stævnenavn=sc.next();
				System.out.println("indtast placering: ");
				int placering=sc.nextInt();
				System.out.println("indtast tid som [HH:MM:SS,nn]:");
				String tid=sc.next();
				this.resultater.setStævneresultater(stævnenavn,placering,tid);
				break;
		}
		throw new UnsupportedOperationException();
	}

}