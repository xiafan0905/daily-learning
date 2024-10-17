package com.example.dailylearning.test;

import com.example.dailylearning.Utils.JsonUtils;
import java.util.List;
import java.util.Map;

public class fzJson {

    public static void main(String[] args) throws Exception {
        String jsonData = "{  \n" +
                "    \"a1\": {    \n" +
                "        \"b1\": {      \n" +
                "            \"c1\": {        \n" +
                "                \"d1\": \"d1\"      \n" +
                "            }    \n" +
                "        }  \n" +
                "    },  \n" +
                "    \"a2\": {    \n" +
                "        \"b2\": {      \n" +
                "            \"c2\": {\n" +
                "                \"d2\": [\"i1\",\"i2\",\"i3\"]      \n" +
                "            }    \n" +
                "        }  \n" +
                "    }\n" +
                "}\n";

        Map<String, Object> map = JsonUtils.parse(jsonData, Map.class);
        String s = JsonUtils.getValue(map, "a1.b1.c1.d1", String.class);
        System.out.println(s);
        List<String> list = JsonUtils.getValue(map, "a2.b2.c2.d2", List.class);
        System.out.println(list);

    }
}
