package w2.w2_13_inclass_adv_simulator;

public interface IRemoteControllableTV {
    // 전원은 토글합니다
    // 한단계 더 추상화 할 수 있는 메서드가 있는 경우
    //   인터페이스도 계층화 고려 가능합니다 (ex - IRemoteControllableDev)
    // - 코드 재사용성과 설계의 효율성/직관성이 Trade-Off 관계에 있으므로
    //   과도한 계층화 또는 요소 분리는 개발 효율을 감소 시킬 수 있으므로 주의!
    void powerToggle();

    // 채널 조작
    void channelUp();  // 맥락상 처음이거나, 햇갈리는 경우 풀네임을 적어줌
    void channelDn();

    // 볼륨 조작
    void volumeUp();
    void volumeDn();

    void showVideo();
}
