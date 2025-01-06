package w1.w1_4_controllogics;

import java.util.Scanner;

public class ConditionSample {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("input command : ");
        String consoleInput = myScanner.nextLine();

        // ##### if #####
        // 조건문과 조건식
        // 문(statement) vs 식(expression)
        // 문 : 동작을 나타내는 코드 -> Return Value 가 없음
        // 식 : 결과적으로 값을 도출하는 코드 -> Return Value 로 수렴
        // Return Value 가 있는 경우 변수에 할당 가능해야 함
        if (consoleInput.equals("true")) {
            System.out.println("This is true branch!");
        } else if (consoleInput.equals("middle")) {
            System.out.println("This is middle branch!");
        } else {
            System.out.println("This is else branch!");
        }


        // ##### switch #####
        // 값의 boolean 변환 없이 분기 수행할 수 있는 구문
        // 다음 분기로 흐르는 특성이 있기에 break 사용
        // 아무 분기에 해당하지 않으면 실행할 default 정의 가능
        // default 에서도 break  명시 권장
        int commandInt = Integer.parseInt(consoleInput);
        switch (commandInt) {
            case 10 :
                System.out.println("Low Score");
                break;
            case 50 :
                System.out.println("Middle Score");
                break;
            case 90 :
                System.out.println("High Score");
                break;
            default:
                System.out.println("Your score is " + commandInt);
                break;
        }
    }
}
