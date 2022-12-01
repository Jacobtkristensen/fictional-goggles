import java.time.LocalTime;
import java.util.Comparator;

public class SorterResultat implements Comparator<Resultat> {
    public int compare(Resultat a, Resultat b){
      return  a.getResult().compareTo(b.getResult());
    }
}