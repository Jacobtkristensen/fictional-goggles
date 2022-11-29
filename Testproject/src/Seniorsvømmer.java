import java.time.LocalDate;

public class Seniorsvømmer extends Konkurrencesvømmer {

	private Svømmedisciplin[] discipliner=new Svømmedisciplin[4];
	private boolean[] aktivdisciplin= new boolean[4];
	//Brystsvømning, Crawl, Rygsvømning, Butterfly

	public Seniorsvømmer(String navn, LocalDate fødseldag, boolean gender,String aktivdisciplin){
		super(navn,fødseldag,gender);
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
	public void tilføjDisciplin() {
		System.out.println("kommer");
	}
}