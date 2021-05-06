package root.model;

import java.util.stream.Stream;

public enum TabooCollections {
    LIVE("liveCards"),
    CANDIDATE("candidateCards"),
    USER("users");

    private final String name;

    TabooCollections(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Stream<String> cards() {
        return Stream.of(LIVE.getName(), CANDIDATE.getName());
    }
}
