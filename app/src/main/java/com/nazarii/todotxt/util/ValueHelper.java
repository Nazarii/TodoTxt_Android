package com.nazarii.todotxt.util;

/**
 * Created by nazik on 21.12.15.
 */
public class ValueHelper {

    public static String join(String[] strings, String sign) {

        StringBuilder builder = new StringBuilder();

        for (String string : strings) {

            if (builder.length() > 0) {
                builder.append(sign);
            }

            builder.append(string);
        }

        return builder.toString();
    }
}
