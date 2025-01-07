package w2.w2_6_hashcollision;

import java.util.Arrays;
import java.util.List;

public class StringHashAndAddress {
    public static void main(String[] args) {
        List<String> testStrings = Arrays.asList(
            "AAAAAAA",
            "BBBBBBB",
            "CCCCCCCCCCCCCC",
            "CCCCCCCCCCCCCC",
            new String("CCCCCCCCCCCCCC")
        );
        for (String a: testStrings) {
            System.out.println(a.hashCode());
        }
        System.out.println("----------------------------------");
        for (String a: testStrings) {
            System.out.println(System.identityHashCode(a));
        }
    }
}
