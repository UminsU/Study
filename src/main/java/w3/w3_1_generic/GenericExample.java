package w3.w3_1_generic;

// (Non)Generic DTO 사용 예제
public class GenericExample {
    public static void main(String[] args) {
        // =======================================
        // 논제네릭 DTO 사용
        // =======================================
        NonGenericDTO nonGenericDTO = new NonGenericDTO();

        // Object 로 데이터를 저장 (문자열)
        // Object 타입으로는 들어갔지만 String 객체의 성격은 유지하고 있어서 손실은 없다
        // 나중에 꺼낼 때만 잘 변환해 주면 됨
        nonGenericDTO.setObject("I'm NonGeneric!"/*.length()*/); // String 만이 사용할 수 있는 .length() 같은 함수 사용을 위해 변환이 필요

        // 데이터를 꺼낼 때 항상 형변환이 필요
        // 14 행의 코드 동작에서 할당된 타입을 확인하고 변환해야 함
        Object object = nonGenericDTO.getObject();
        if (object instanceof NonGenericDTO) {
            String data = (String) object;
            System.out.println(data);  // 출력: Hello, NonGeneric!
        }
        // 아래 코드는 확인 없이 변환하기 때문에 예외 발생 및 프로그램 중단될 가능성
        String data = (String) nonGenericDTO.getObject();
        System.out.println(data); // 출력: Hello, NonGeneric!

        // 실수로 잘못된 형변환을 할 경우 런타임 에러 발생
        try {
            Integer wrongData = (Integer) nonGenericDTO.getObject(); // 런타임 오류 발생
        } catch (ClassCastException e) {
            System.out.println("ClassCastException 발생: " + e.getMessage());
        }

        // =======================================
        // 제네릭 DTO 사용
        // =======================================
        GenericDTO<String> stringDTO = new GenericDTO<>();  // String 을 쓰기로 약속함

        // 컴파일 타임에 타입이 안전하게 결정됨 (문자열만 저장 가능)
        stringDTO.setObject("I'm Generic!");   // 타입 캐스팅이 불필요해짐
        //stringDTO.setObject(1234);  // 이미 stringDTO 은 String 타입이기에 int 형 불가

        // 데이터를 꺼낼 때 형변환 불필요
        String strData = /*(String)*/ stringDTO.getObject();
        System.out.println(strData); // 출력: Hello, Generic!

        // 컴파일 타임에 잘못된 타입의 데이터 저장을 방지
        // stringDTO.setObject(12345); // 컴파일 에러 발생

        GenericDTO<Integer> intDTO = new GenericDTO<>();

        // 컴파일 타임에 타입이 안전하게 결정됨 (문자열만 저장 가능)
        intDTO.setObject(12345);

        // 데이터를 꺼낼 때 형변환 불필요
        //String intData = intDTO.getObject();
        //System.out.println(intData); // 출력: 12345


        // 즉, Generic 은 어떤 한 class 에 대해서 여러가지 타입의 객체를 받아서 사용할 수 있음
    }
}