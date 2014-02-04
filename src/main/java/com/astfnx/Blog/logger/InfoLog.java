package com.astfnx.Blog.logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sinhanurag on 2/4/14.
 */
public class InfoLog {

    protected Map InfoLogMap = new HashMap<String,String>();


    public Map getInfoLogMap() {
        return InfoLogMap;
    }

    public void setInfoLogMap(Map infoLogMap) {
        InfoLogMap = infoLogMap;
    }
}
