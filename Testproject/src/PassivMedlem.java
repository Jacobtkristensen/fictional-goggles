import java.time.LocalDate;

public class PassivMedlem extends Medlem {
    public PassivMedlem(String navn, LocalDate f�dseldag, boolean gender, boolean harBetalt){
        super(navn, f�dseldag, gender, harBetalt);
    }


    @Override
    public double beregnKontingent() {
        return 500;
    }
}