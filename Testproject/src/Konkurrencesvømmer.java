import java.time.LocalDate;

public class KonkurrencesvÝmmer extends Medlem {
	private boolean[] aktivdisciplin=new boolean[4];
	private SvÝmmedisciplin[] discipliner=new SvÝmmedisciplin[4];
	public KonkurrencesvÝmmer(String navn, LocalDate bday, boolean gender, String disciplinset){
		super(navn,bday,gender);
		this.aktivdisciplin=setAktivDiscipliner(disciplinset);
		for (int i=0;i<4;i++){
			if(aktivdisciplin[i]){
				if(i==0){    //"brystsvÝmning=b, crawl=c, ryg=r, butterfly=f"
					SvÝmmedisciplin[i]=new SvÝmmedisciplin("brystsvÝmning");
				}
				if(i==1){
					SvÝmmedisciplin[i]=new SvÝmmedisciplin("crawl");
				}
				if(i==2){
					SvÝmmedisciplin[i]=new SvÝmmedisciplin("ryg");
				}
				if(i==3){
					SvÝmmedisciplin[i]=new SvÝmmedisciplin("butterfly");
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


	public void tilfÝjDisciplin() {
		System.out.println("kommer");
	}
}