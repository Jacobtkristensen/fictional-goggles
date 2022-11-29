import java.time.LocalDate;

public abstract class Konkurrencesv�mmer extends Medlem {
	private boolean[] aktivdisciplin=new boolean[4];
	public Konkurrencesv�mmer(String navn, LocalDate bday, boolean gender){
		super(navn,bday,gender);
		//this.aktivdisciplin=setAktivDiscipliner(disciplinset);
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
	public abstract void GetResults();

	public abstract void tilf�jDisciplin();

}