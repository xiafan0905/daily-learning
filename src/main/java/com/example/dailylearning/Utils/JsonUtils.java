package com.example.dailylearning.Utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import ognl.Ognl;
import ognl.OgnlContext;
import java.util.Map;


public class JsonUtils {

    private final static ObjectMapper objectMapper = new ObjectMapper();

    public static ObjectMapper getInstance() {
        return objectMapper;
    }

    public static <T> T parse(String jsonStr, Class<T> clazz) throws Exception {
        return getInstance().readValue(jsonStr, clazz);
    }

    public static <T> T getValue(Map map, String path, Class<T> klass) throws Exception {
        OgnlContext ctx = new OgnlContext();
        ctx.setRoot(map);
        T value = (T) Ognl.getValue(path, ctx, ctx.getRoot());
        return value;
    }
}
