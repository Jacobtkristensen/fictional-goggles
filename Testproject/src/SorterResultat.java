import java.util.Comparator;

public class SorterResultat (int i) implements Comparator<Konkurrencesv�mmer> {
    public int i=-99;
    SorterResultat(int i){
        this.i= i;
    }

    public int compare(Konkurrencesv�mmer a, Konkurrencesv�mmer b){
      return  a.getResults()[i]-b.getResults()[i];
    }
}