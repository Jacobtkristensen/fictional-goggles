import java.util.Comparator;

public class SorterResultat (int i) implements Comparator<Konkurrencesvømmer> {
    public int i=-99;
    SorterResultat(int i){
        this.i= i;
    }

    public int compare(Konkurrencesvømmer a, Konkurrencesvømmer b){
      return  a.getResults()[i]-b.getResults()[i];
    }
}