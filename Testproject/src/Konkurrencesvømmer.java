import java.time.LocalDate;

public class Konkurrencesvømmer extends Medlem {
	private boolean[] aktivdisciplin=new boolean[4];
	public Konkurrencesvømmer(String navn, LocalDate bday, boolean gender, String disciplinset){
		super(navn,bday,gender);
		this.aktivdisciplin=setAktivDiscipliner(disciplinset);
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


	public void tilføjDisciplin() {
		System.out.println("kommer");
	}
}