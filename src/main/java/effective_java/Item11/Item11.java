package main.java.effective_java.Item11;

import java.util.HashMap;

public class Item11 {

    public static void main(String[] args) {
        Item11 item11 = new Item11();
        item11.hashcode_재정의안함();
        item11.hashcode_재정의();
    }

    private void hashcode_재정의안함() {
        HashMap<PhoneNumber, String> map = new HashMap<>();
        map.put(new PhoneNumber(707, 867, 5307), "제니");
        System.out.println("Instance 1 hashcode : " + new PhoneNumber(707, 867, 5307).hashCode());
        System.out.println("Instance 2 hashcode : " + new PhoneNumber(707, 867, 5307).hashCode());
        String name = map.get(new ExtendedPhoneNumber(707, 867, 5307));
        System.out.println("name : " + name);
    }

    private void hashcode_재정의() {
        HashMap<ExtendedPhoneNumber, String> map = new HashMap<>();
        map.put(new ExtendedPhoneNumber(707, 867, 5307), "제니");
        System.out.println("Instance 1 hashcode : " + new ExtendedPhoneNumber(707, 867, 5307).hashCode());
        System.out.println("Instance 2 hashcode : " + new ExtendedPhoneNumber(707, 867, 5307).hashCode());
        String name = map.get(new ExtendedPhoneNumber(707, 867, 5307));
        System.out.println("name : " + name);
    }
}
