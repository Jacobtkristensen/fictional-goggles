import java.time.LocalDate;

public class Juniorsv�mmer extends Konkurrencesv�mmer {

	private Sv�mmedisciplin[] discipliner;
	private boolean[] aktivdisciplin= new boolean[4];
	//Brystsv�mning, Crawl, Rygsv�mning, Butterfly

	public Juniorsv�mmer(String navn, LocalDate foedselsdag, boolean gender, String aktivdisciplin){
		super(navn,foedselsdag,gender);
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

	@Override
	public void GetResults() {
		System.out.println("to be implemented");
	}

	@Override
	public void tilf�jDisciplin() {
		System.out.println("kommer");
	}
}