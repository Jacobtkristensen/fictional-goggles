import java.time.LocalDate;

public class Seniorsvømmer extends Konkurrencesvømmer {

	private Svømmedisciplin[] discipliner=Svømmedisciplin[4];
	private boolean[] aktivdisciplin=boolean[4];
	//Brystsvømning, Crawl, Rygsvømning, Butterfly

	public Seniorsvømmer(String navn, LocalDate fødseldag, boolean gender,String aktivdisciplin){
		super(navn,fødseldag,gender);
		this.aktivdisciplin=setAktivDiscipliner(aktivdisciplin);
	}


	public void setAktivDiscipliner(String disciplinset) {
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
	}
}