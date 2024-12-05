import javax.xml.validation.Validator;
import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

enum ValidationResult {
    SUCCESS,
    THE_PHONE_NUMBER_IS_NOT_VALID,
    THE_EMAIL_IS_NOT_VALID,
    IS_NOT_AN_ADULT

}
public interface CustomerRegisterValidation extends Function<customer, ValidationResult> {

    static CustomerRegisterValidation isEmailValid () {
        return customer -> customer.Emali.contains("@")?
                ValidationResult.SUCCESS:ValidationResult.THE_EMAIL_IS_NOT_VALID;
    }
    static CustomerRegisterValidation isPhoneNumberValid () {
        return customer -> customer.number.startsWith("+0")?
                ValidationResult.SUCCESS : ValidationResult.THE_PHONE_NUMBER_IS_NOT_VALID;
    }
    static CustomerRegisterValidation isAdult() {
            return customer -> Period.between(customer.DOB,LocalDate.now()).getYears()> 16? ValidationResult.SUCCESS
                    :ValidationResult.IS_NOT_AN_ADULT;
    }
    default CustomerRegisterValidation and(CustomerRegisterValidation other) {
        return customer -> {
            ValidationResult result = this.apply(customer);
            return result.equals(ValidationResult.SUCCESS)? other.apply(customer) :result;
        };
    }


}
