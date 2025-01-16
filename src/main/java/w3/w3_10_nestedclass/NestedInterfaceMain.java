package w3.w3_10_nestedclass;

class Button {
    // 범용 객체에 대해서 동적으로 함수를 할당받을 수 있게끔 인터페이스를 사용
    //  -> Collection 안에 forEach() 메서드가 Consumer 인터페이스 사용하는 구조 참조

    // => 특정 개념 하에서만 독점 사용되는 인터페이스의 경우 중첩으로 선언한다!
    interface OnClickListener {  // 함수형 인터페이스
        void onClick();
    } // "외부와의 소통을 전담하는 동작 요소" 를 선언

    private OnClickListener listener;

    public void setOnClickListener(OnClickListener listener) {
        this.listener = listener;
    }

    public void click() {
        if (listener != null) {
            listener.onClick();
        }
    }
}

public class NestedInterfaceMain {
    public static void main(String[] args) {
        Button button = new Button();
        button.setOnClickListener(() -> System.out.println("Button clicked!"));
        button.click(); // 출력: Button clicked!

        Button redButton = new Button();
        button.setOnClickListener(() -> System.out.println("Red Button clicked!"));
        redButton.click(); // 출력: Red Button clicked!
    }
}