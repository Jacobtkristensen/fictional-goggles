import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Konkurrencesv�mmer extends Medlem {
	private boolean[] aktivdisciplin=new boolean[4];
	private Sv�mmedisciplin[] discipliner=new Sv�mmedisciplin[4];
	private LocalTime[] resultater=new LocalTime[4];
	DateTimeFormatter tidsformat = DateTimeFormatter.ofPattern("HH:mm:ss,SS");
	public Konkurrencesv�mmer(String navn, LocalDate bday, boolean gender, boolean harBetalt, String disciplinset){
		super(navn,bday,gender, harBetalt);
		this.aktivdisciplin=setAktivDiscipliner(disciplinset);
		DateTimeFormatter tidsformat = DateTimeFormatter.ofPattern("HH:mm:ss,SS");
		String tider="23:59:59,00";
		LocalTime initialtider=LocalTime.parse(tider,tidsformat);
		for (int i=0;i<4;i++){
			if(aktivdisciplin[i]){
				if(i==0){    //"brystsv�mning=b, crawl=c, ryg=r, butterfly=f"
					discipliner[i]=new Sv�mmedisciplin("brystsv�mning");
				}
				if(i==1){
					discipliner[i]=new Sv�mmedisciplin("crawl");
				}
				if(i==2){
					discipliner[i]=new Sv�mmedisciplin("ryg");
				}
				if(i==3){
					discipliner[i]=new Sv�mmedisciplin("butterfly");
				}
			}
		}

		tider="23:59:59,00";
		initialtider=LocalTime.parse(tider,tidsformat);
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

		for (int i=0;i<4;i++){
			if(aktivdisciplin[i]){
				resultater[i]= discipliner[i].getResultater().getResult();
			}
			else{
				resultater[i]=LocalTime.parse("23:59:59,00",tidsformat);
			}
		}
	}


	public void tilf�jDisciplin() {
		System.out.println("kommer");
	}
}