import java.time.LocalDate;

public class PassivMedlem extends Medlem {
    public PassivMedlem(String navn, LocalDate fødseldag, boolean gender, boolean harBetalt){
        super(navn, fødseldag, gender, harBetalt);
    }


    @Override
    public double beregnKontingent() {
        return 500;
    }
}