package utils;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

    private static Map<String, Object> context = new HashMap<>();

    public static void setContext(String key, Object value) {
        context.put(key, value);
    }

    public static Object getContext(String key) {
        return context.get(key);
    }

    public static void clearParameter(String key) {
        context.remove(key);
    }

}
