package w2.w2_12_simulator;

public enum Option {
    채널,
    볼륨,
    밝기,
    대비,
    종료;

    public static Option fromString(String input) {
        for (Option option : Option.values()) {
            if (option.name().equalsIgnoreCase(input)) {
                return option;
            }
        }
        return null;
    }
}