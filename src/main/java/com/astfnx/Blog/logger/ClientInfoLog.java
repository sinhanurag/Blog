package com.astfnx.Blog.logger;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Locale;

/**
 * Created by sinhanurag on 2/4/14.
 */
public class ClientInfoLog extends InfoLog {

    private String USER_AGENT = "User Agent";
    private String IP_ADDRESS = "IP Address";
    private String DATE = "Date";
    private String USER_LOCALE = "User Locale";

    public ClientInfoLog(HttpServletRequest request){

        super.InfoLogMap.put(USER_AGENT,request.getHeader("user-agent"));
        super.InfoLogMap.put(IP_ADDRESS,request.getRemoteAddr());
        super.InfoLogMap.put(DATE,request.getHeader("Date"));
        super.InfoLogMap.put(USER_LOCALE,request.getLocale().toString());
    }
}
