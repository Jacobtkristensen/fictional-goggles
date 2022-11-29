import java.time.LocalDate;

public class Juniorsvømmer extends Konkurrencesvømmer {

	private Svømmedisciplin[] discipliner;
	private boolean[] aktivdisciplin= new boolean[4];
	//Brystsvømning, Crawl, Rygsvømning, Butterfly

	public Juniorsvømmer(String navn, LocalDate foedselsdag, boolean gender, String aktivdisciplin){
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
	public void tilføjDisciplin() {
		System.out.println("kommer");
	}
}