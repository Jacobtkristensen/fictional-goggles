import java.time.LocalDate;

public class PassivMedlem extends Medlem {
    public PassivMedlem(String navn, LocalDate fødseldag, boolean gender){
        super(navn, fødseldag, gender);
    }


    @Override
    public double beregnKontingent() {
        return 500;
    }
}