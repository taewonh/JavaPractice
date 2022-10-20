package effective_java.Item12;

public class Item12 {

    public static void main(String[] args) {
        Item12 item12 = new Item12();
        item12.testToString();
    }

    private void testToString() {
        PhoneNumber phoneNumber = PhoneNumber.parse("010-123-1234");
        System.out.println(phoneNumber);
    }
}
