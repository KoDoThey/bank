package com.vcc.mlbigdata.layer.infrastructure;

public class Strings {
    public static boolean isNullOrEmptyString(Object source) {
        return source == null || source.toString().isEmpty();
    }
}
