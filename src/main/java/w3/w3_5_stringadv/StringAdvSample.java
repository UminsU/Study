package w3.w3_5_stringadv;

public class StringAdvSample {
    public static void main(String[] args) {
        String advPractice = "문자열 데이터를 advanced level 로 다뤄보고자 합니다..!    \n\t  ";
        System.out.println(advPractice.length());
        System.out.println(advPractice.substring(9, 24));
        System.out.println(advPractice.substring(9, 24).toUpperCase());
        System.out.println(advPractice);
        System.out.println(advPractice.trim());
        System.out.println(advPractice.replace(" ", "_"));

        String myStrA = "a";
        String myStrB = "b";
        for (int i = 0; i < 10; i++) {
            myStrA += myStrA;
            myStrA += myStrB;
            System.out.println(myStrA);
        }
    }
}
