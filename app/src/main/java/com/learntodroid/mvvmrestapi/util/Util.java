package com.learntodroid.mvvmrestapi.util;

import java.util.List;

public class Util {
    public String StringJoin(List<String> stringList, String delimeter) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stringList.size(); i++) {
            sb.append(stringList.get(i));
            if (i != stringList.size() - 1) {
                sb.append(delimeter);
            }
        }

        return sb.toString();
    }
}
