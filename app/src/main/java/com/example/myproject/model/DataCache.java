package com.example.myproject.model;

/**
 * Created by wangbs on 16/5/12.
 */
public class DataCache {
    public static DataCache dataUtils = null;

    public static DataCache getInstance() {
        synchronized (DataCache.class) {
            if (dataUtils == null) {
                dataUtils = new DataCache();
            }
        }
        return dataUtils;
    }
    private int theme=1;

    private int homeStatue;//0:默认值;1:需要重新new;2:需要刷新数据
    private int recommedStatue;
    private int recordStatue;
    private int messageStatue;
    private int setStatue;

    public int getTheme() {
        return theme;
    }

    public void setTheme(int theme) {
        this.theme = theme;
    }

    public int getHomeStatue() {
        return homeStatue;
    }

    public void setHomeStatue(int homeStatue) {
        this.homeStatue = homeStatue;
    }

    public int getRecommedStatue() {
        return recommedStatue;
    }

    public void setRecommedStatue(int recommedStatue) {
        this.recommedStatue = recommedStatue;
    }

    public int getRecordStatue() {
        return recordStatue;
    }

    public void setRecordStatue(int recordStatue) {
        this.recordStatue = recordStatue;
    }

    public int getMessageStatue() {
        return messageStatue;
    }

    public void setMessageStatue(int messageStatue) {
        this.messageStatue = messageStatue;
    }

    public int getSetStatue() {
        return setStatue;
    }

    public void setSetStatue(int setStatue) {
        this.setStatue = setStatue;
    }
}
