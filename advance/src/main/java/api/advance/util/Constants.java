package api.advance.util;

import java.util.HashMap;
import java.util.Map;

public class Constants {
    public static final Map<String, int[]> DAYS_BY_LICENSE_PLATE = Map.of(
            "Monday", new int[]{1, 2},
            "Tuesday", new int[]{3, 4},
            "Wednesday", new int[]{5, 6},
            "Thursday", new int[]{7, 8},
            "Friday", new int[]{9, 0}
    );
}
