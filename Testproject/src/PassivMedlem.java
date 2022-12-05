import java.io.Serializable;
import java.time.LocalDate;

public class PassivMedlem extends Medlem implements Serializable {
    public PassivMedlem(String navn, LocalDate f�dseldag, boolean gender, boolean harBetalt){
        super(navn, f�dseldag, gender, harBetalt);
    }
    public PassivMedlem(){
        super();
    }


    @Override
    public double beregnKontingent() {
        return 500;
    }
}