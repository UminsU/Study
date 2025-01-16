package w3.w3_8_functionalInterface;

// 원하는 인풋 아웃풋 포맷을 메서드 시그니처로 담아주고,
// 선언부 상단에 @FunctionalInterface 어노테이션 추가
@FunctionalInterface

interface MyMathIntBinaryOperation {
    int operate(int a, int b);
}
