import java.time.LocalDate;

public class Seniorsv�mmer extends Konkurrencesv�mmer {

	private Sv�mmedisciplin[] discipliner=new Sv�mmedisciplin[4];
	private boolean[] aktivdisciplin= new boolean[4];
	//Brystsv�mning, Crawl, Rygsv�mning, Butterfly

	public Seniorsv�mmer(String navn, LocalDate f�dseldag, boolean gender,String aktivdisciplin){
		super(navn,f�dseldag,gender);
		this.aktivdisciplin=setAktivDiscipliner(aktivdisciplin);
	}


	public boolean[] setAktivDiscipliner(String disciplinset) {
		if(disciplinset.contains("b")){
			aktivdisciplin[0]=true;
		}
		if(disciplinset.contains("c")){
			aktivdisciplin[1]=true;
		}
		if(disciplinset.contains("r")){
			aktivdisciplin[2]=true;
		}
		if(disciplinset.contains("f")){
			aktivdisciplin[3]=true;
		}
		return aktivdisciplin;
	}
	public void GetResults() {
		System.out.println("to be implemented");
	}

	@Override
	public void tilf�jDisciplin() {
		System.out.println("kommer");
	}
}