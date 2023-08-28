package pl.stagecrew.shared.common;

import java.util.Arrays;
import java.util.List;

public class CommonConstants {

    public static final String SYSTEM = "SYSTEM";
    public static final String ANONYMOUS = "ANONYMOUS";
    public static final String UNAUTHENTICATED = "UNAUTHENTICATED";
    public static final List<String> FORBIDDEN_USERNAMES = Arrays.asList(SYSTEM, ANONYMOUS, UNAUTHENTICATED);

    private CommonConstants() {
        throw new IllegalStateException("Utility class");
    }
}
