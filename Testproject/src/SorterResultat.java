import java.time.LocalTime;
import java.util.Comparator;

public class SorterResultat (int i) implements Comparator<Resultat> {
    public int compare(Konkurrencesv�mmer a, Konkurrencesv�mmer b, int i){
      return  a.getResults()[i]-b.getResults()[i];
    }
}