package com.example.myproject.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangbs on 16/5/12.
 */
public class SwitchParams {
    public static SwitchParams switchParams = null;

    public static SwitchParams getInstance() {
        synchronized (SwitchParams.class) {
            if (switchParams == null) {
                switchParams = new SwitchParams();
            }
        }
        return switchParams;
    }
    public Map<Object,Object> getHomeParams(){
        Map<Object,Object> hashMap=new HashMap<>();
        return hashMap;
    }
    public Map<Object,Object> getRecommedParams(){
        Map<Object,Object> hashMap=new HashMap<>();
        return hashMap;
    }
    public Map<Object,Object> getRecordParams(){
        Map<Object,Object> hashMap=new HashMap<>();
        return hashMap;
    }
    public Map<Object,Object> getMessageParams(){
        Map<Object,Object> hashMap=new HashMap<>();
        return hashMap;
    }
    public Map<Object,Object> getSetParams(){
        Map<Object,Object> hashMap=new HashMap<>();
        return hashMap;
    }
}
