package w11.w1_1_grammer;
/**
 * 협업하는 개발들을 위해서
 * 작석한 프로그램 요소별로
 * 친절한 Docs 주석을 작성할 수 있습니다.
 * => Class에 대한 Docs 생성됨
 */


public class Grammer {
    // 한줄 주석 : 주석도 코드다!
    /*
        여러줄 주석
     */

    static {
        int staticNum1 = 1;
    }

    /**
     * 메서드 Docs에 대해서는
     * 작성하는 특정한 포맷이 존재함
     * -> API 문서 작성 및 자동 생성에 필요한 기본 포맷이 됨
     * @param args
     *    : 외부에서 문자열 입력을 수신하는 파라미터
     */
    public static void main(String[] args) {
        int myNum1 = 1;
        int myNum2 = 2;

        {
            int localNum1 = 1;
            int localNum2 = localNum1 + 1;
            System.out.println(localNum2);
        }

        // 공백은 개행과 탭과 빈칸(공백문자)
        // 제어문자를 기반으로 공백이 처리가 됨 (Escape 문자 : \)
        // \n : 개행, \t : 탭, &nbsp : 공백문자
        // \n\r : OS 시스템에 따른 개행

        // 구분자의 종류
        // 공백문자, ;, ",", {}, (), Dot(.)
        int[] arrayA = {1,2,3};

        // 식별자 규칙
        int a1_$ = 1;
        // int 1_$ = 1; // 숫자만 빼고 시작문자로 사용가능
        int _$a1 = 1;
        int $a1_ = 1;

        // 키워드 식별자로 사용금지
        // int int = 1;, int class =1;, int public = 1; 등

    }
}
