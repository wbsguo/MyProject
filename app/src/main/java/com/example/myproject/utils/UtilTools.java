package com.example.myproject.utils;

/**
 * Created by wangbs on 16/5/12.
 */
public class UtilTools {
    public static UtilTools utilTools = null;

    public static UtilTools getInstance() {
        synchronized (UtilTools.class) {
            if (utilTools == null) {
                utilTools = new UtilTools();
            }
        }
        return utilTools;
    }
}
