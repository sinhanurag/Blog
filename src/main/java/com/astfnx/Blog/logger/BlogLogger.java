package com.astfnx.Blog.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by sinhanurag on 2/2/14.
 */
public class BlogLogger {

    public static void logClientInfo(Class className,HttpServletRequest request){

        org.slf4j.Logger logger = LoggerFactory.getLogger(className);

        logger.info("Date: ",request.getHeader("Date"));
        logger.info("User Locale: ",request.getLocale());
        logger.info("IP Address: ",request.getRemoteAddr());
        logger.info("User Agent: ",request.getHeader("User-Agent"));



    }
}
