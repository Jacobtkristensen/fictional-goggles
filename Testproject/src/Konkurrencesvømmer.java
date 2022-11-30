import java.time.LocalDate;

public class Konkurrencesvømmer extends Medlem {
	private boolean[] aktivdisciplin=new boolean[4];
	private Svømmedisciplin[] discipliner=new Svømmedisciplin[4];
	public Konkurrencesvømmer(String navn, LocalDate bday, boolean gender, String disciplinset){
		super(navn,bday,gender);
		this.aktivdisciplin=setAktivDiscipliner(disciplinset);
		for (int i=0;i<4;i++){
			if(aktivdisciplin[i]){
				if(i==0){    //"brystsvømning=b, crawl=c, ryg=r, butterfly=f"
					discipliner[i]=new Svømmedisciplin("brystsvømning");
				}
				if(i==1){
					discipliner[i]=new Svømmedisciplin("crawl");
				}
				if(i==2){
					discipliner[i]=new Svømmedisciplin("ryg");
				}
				if(i==3){
					discipliner[i]=new Svømmedisciplin("butterfly");
				}
			}
		}
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