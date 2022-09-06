package effective_java.Item11;

public class ExtendedPhoneNumber extends PhoneNumber {

    public ExtendedPhoneNumber(int firstNumber, int secondNumber, int thirdNumber) {
        super(firstNumber, secondNumber, thirdNumber);
    }

    @Override
    public int hashCode() {
        int c = 31;
        int hashcode = Integer.hashCode(firstNumber);
        hashcode = c * hashcode + Integer.hashCode(secondNumber);
        hashcode = c * hashcode + Integer.hashCode(thirdNumber);
        return hashcode;
    }
}
