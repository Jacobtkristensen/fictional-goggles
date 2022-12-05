import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Konkurrencesvømmer extends Medlem implements Serializable {
	private boolean[] aktivdisciplin=new boolean[4];

	private Svømmedisciplin[] discipliner=new Svømmedisciplin[4];
	private LocalTime[] resultater=new LocalTime[4];
	transient DateTimeFormatter tidsformat = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
	//constructors. in order to be able to serialize/deserialize a no-argument constructor must be available
	public Konkurrencesvømmer(){
		super();
		for(int i=0;i<4;i++){
			this.aktivdisciplin[i]=false;
			this.discipliner[i]=new Svømmedisciplin();
			this.resultater[i]=LocalTime.parse("23:59:59.000",tidsformat);
		}

	}
	public Konkurrencesvømmer(String navn, LocalDate bday, boolean gender, boolean harBetalt, String disciplinset){
		super(navn,bday,gender, harBetalt);
		this.aktivdisciplin=setAktivDiscipliner(disciplinset);
		 DateTimeFormatter tidsformat = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
		String tider="23:59:59.000";
		LocalTime initialtider=LocalTime.parse(tider,tidsformat);
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

		 tider="23:59:59.002";
		 initialtider=LocalTime.parse(tider,tidsformat);
		Arrays.fill(resultater,initialtider);
	}

	public String printTilKonsol(){
		String s=Arrays.toString(discipliner);
		return super.printTilKonsol()+s;
	}

	public String toString(){
		String s=super.toString()+" "+Arrays.toString(aktivdisciplin)+" "+Arrays.toString(discipliner)+" "+Arrays.toString(resultater);
		return s;
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

		for (int i=0;i<4;i++){
			if(aktivdisciplin[i]){
				resultater[i]= discipliner[i].getResultater().getResult();
			}
			else{
				resultater[i]=LocalTime.parse("23:59:59.000",tidsformat);
			}
		}
	}


	public void tilføjDisciplin() {
		System.out.println("kommer");
	}
	public Svømmedisciplin[] getDiscipliner() {
		return discipliner;
	}
}