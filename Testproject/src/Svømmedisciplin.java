import java.io.Serializable;
import java.time.LocalTime;
import java.util.Scanner;

public class Sv�mmedisciplin implements Serializable {
	private String disciplinNavn;
	private Resultat resultater;
	private LocalTime currentbest;

	//constructors...noarg constructor must be found
	public Sv�mmedisciplin(){
		this.disciplinNavn="NyDisciplin";
		this.resultater=new Resultat();
		this.currentbest=this.resultater.getResult();
	}
	public Sv�mmedisciplin(String disciplinNavn){
		this.disciplinNavn=disciplinNavn;
		this.resultater=new Resultat();
		this.currentbest=this.resultater.getResult();
	}
	public Sv�mmedisciplin(String disciplinnavn, LocalTime resultat){
		this.disciplinNavn=disciplinNavn;
		this.resultater= new Resultat();
		this.currentbest=resultat;
		this.resultater.setBedsteTid(resultat);
	}
	public String getDisciplinNavn() {
		return disciplinNavn;
	}

	public Resultat getResultater() {
		return resultater;
	}
	public String toString(){
		return "["+ this.getDisciplinNavn()+", "+getResultater().getResult()+"]";
	}
	public void opdaterResutater(int tr�nerinput) { //del af tr�nerens muligheder

		Scanner sc= new Scanner(System.in);
		switch (tr�nerinput){
			case 1:
			System.out.println("indtast tr�ningsdato som [YYYY-MM-DD]: ");
			String dato=sc.next();
			System.out.println("indtast tr�ningstid som [HH:MM:ss.SSS]: ");
			String tr�ningstid=sc.next();
			this.resultater.setTr�ningsresultater(dato,tr�ningstid);
			break;
			case 2:
				System.out.println("indtast st�vnenavn");
				String st�vnenavn=sc.next();
				System.out.println("indtast placering: ");
				int placering=sc.nextInt();
				System.out.println("indtast tid som [HH:MM:SS,nn]:");
				String tid=sc.next();
				this.resultater.setSt�vneresultater(st�vnenavn,placering,tid);
				break;
		}

	}

}