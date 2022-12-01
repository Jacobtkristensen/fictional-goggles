import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class KonkurrencesvÝmmer extends Medlem {
	private boolean[] aktivdisciplin=new boolean[4];
	private SvÝmmedisciplin[] discipliner=new SvÝmmedisciplin[4];
	private LocalTime[] resultater=new LocalTime[4];
	public KonkurrencesvÝmmer(String navn, LocalDate bday, boolean gender, boolean harBetalt, String disciplinset){
		super(navn,bday,gender, harBetalt);
		this.aktivdisciplin=setAktivDiscipliner(disciplinset);
		for (int i=0;i<4;i++){
			if(aktivdisciplin[i]){
				if(i==0){    //"brystsvÝmning=b, crawl=c, ryg=r, butterfly=f"
					discipliner[i]=new SvÝmmedisciplin("brystsvÝmning");
				}
				if(i==1){
					discipliner[i]=new SvÝmmedisciplin("crawl");
				}
				if(i==2){
					discipliner[i]=new SvÝmmedisciplin("ryg");
				}
				if(i==3){
					discipliner[i]=new SvÝmmedisciplin("butterfly");
				}
			}
		}
		DateTimeFormatter tidsformat = DateTimeFormatter.ofPattern("HH:mm:ss,SS");
		String tider="23:59:59,00";
		LocalTime initialtider=LocalTime.parse(tider,tidsformat);
		Arrays.fill(resultater,initialtider);
	}

	public String toString(){
		String s=Arrays.toString(discipliner);
		return super.toString()+s;
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
		for (int i=0;i<4;i++){
			if(aktivdisciplin[i]){
				if(i==0){    //"brystsvÝmning=b, crawl=c, ryg=r, butterfly=f"
					discipliner[i]=new SvÝmmedisciplin("brystsvÝmning");
				}
				if(i==1){
					discipliner[i]=new SvÝmmedisciplin("crawl");
				}
				if(i==2){
					discipliner[i]=new SvÝmmedisciplin("ryg");
				}
				if(i==3){
					discipliner[i]=new SvÝmmedisciplin("butterfly");
				}
			}
		}
	}


	public void tilfÝjDisciplin() {
		System.out.println("kommer");
	}
}