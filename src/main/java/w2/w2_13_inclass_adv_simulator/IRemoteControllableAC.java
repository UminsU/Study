package w2.w2_13_inclass_adv_simulator;

public interface IRemoteControllableAC {
    // 전원은 토글합니다
    // - 전원과 같이 한단계 더 추상화 할 수 있는 메서드가 있는 경우
    //   인터페이스도 계층화 고려 가능합니다 (ex - IRemoteControllableDev)
    // - 코드 재사용성과 설계의 효율성/직관성이 Trade-Off 관계에 있으므로
    //   과도한 계층화 또는 요소 분리는 개발 효율을 감소 시킬 수 있으므로 주의!
    void powerToggle();

    // 바람세기 조작
    void windUp();  // 맥락상 처음이거나, 햇갈리는 경우 풀네임을 적어줌
    void windDn();

    // 희망온도 조작
    void tgTmpUp();
    void tgTmpDn();

    // 송풍
    void blowWind();
}
