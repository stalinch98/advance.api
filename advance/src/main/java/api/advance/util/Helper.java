package api.advance.util;

import java.util.Map;

public class Helper {
public static String findKeyByValue(int value) {
        for (Map.Entry<String, int[]> entry : Constants.DAYS_BY_LICENSE_PLATE.entrySet()) {
            int[] values = entry.getValue();
            for (int num : values) {
                if (num == value) {
                    return entry.getKey();
                }
            }
        }
        return null;
    }
}
