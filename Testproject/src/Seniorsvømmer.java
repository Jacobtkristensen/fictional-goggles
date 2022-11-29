import java.time.LocalDate;

public class Seniorsv�mmer extends Konkurrencesv�mmer {

	private Sv�mmedisciplin[] discipliner=Sv�mmedisciplin[4];
	private boolean[] aktivdisciplin=boolean[4];
	//Brystsv�mning, Crawl, Rygsv�mning, Butterfly

	public Seniorsv�mmer(String navn, LocalDate f�dseldag, boolean gender,String aktivdisciplin){
		super(navn,f�dseldag,gender);
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