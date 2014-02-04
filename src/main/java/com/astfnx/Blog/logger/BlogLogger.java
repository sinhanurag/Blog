package com.astfnx.Blog.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by sinhanurag on 2/2/14.
 */
public class BlogLogger {

    public static void logInfo(Class className,InfoLog infoLog){

        Logger logger = LoggerFactory.getLogger(className);

        Iterator iterator = infoLog.getInfoLogMap().entrySet().iterator();

        while(iterator.hasNext()){

            Map.Entry pairs = (Map.Entry)iterator.next();
            logger.info(pairs.getKey()+" :: "+pairs.getValue());
            iterator.remove();
        }
    }
}







