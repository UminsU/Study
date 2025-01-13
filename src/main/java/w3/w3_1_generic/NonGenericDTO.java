package w3.w3_1_generic;

import java.io.Serializable;

// DTO 란 데이터의 전송을 위해 사용하는 표준화된 클래스의 형태를 말함
// (1) 내부에 `private` 필드를 가지고 있고,
// (2) `getter 와 `setter` 메서드를 통해 데이터 교환을 하며,
// (3) Serializable 인터페이스를 구현하는 것을 특징으로 함
public class NonGenericDTO implements Serializable {
    private Object object;

    public void setObject(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return object;
    }
}