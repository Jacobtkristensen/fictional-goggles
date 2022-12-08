import java.time.LocalTime;
import java.util.Comparator;

public class SorterResultat (int i) implements Comparator<Resultat> {
    public int compare(Konkurrencesvømmer a, Konkurrencesvømmer b, int i){
      return  a.getResults()[i]-b.getResults()[i];
    }
}