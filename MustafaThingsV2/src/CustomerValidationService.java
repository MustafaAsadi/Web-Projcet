import java.time.LocalDate;
import java.time.Period;

public class CustomerValidationService {
    private boolean isEmailValid(String email) {
        return email.contains("@");

    }
    private boolean isPhoneNumberValid (String phoneNumber) {
        return phoneNumber.startsWith("+0");
    }
    private boolean isAdult (LocalDate DOB) {
        return Period.between(DOB,LocalDate.now()).getYears()> 16 ;
    }
}
