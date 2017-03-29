package com.common.log;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by hs on 2016/12/22.
 */
public class MyApp {
    private static final Logger logger = LogManager.getLogger(MyApp.class);

    public static void main(String[] args) {
        logger.trace("entering application");
        Bar bar = new Bar();
        if (bar.doIt()) {
            logger.error("Didn't do it.");
        }
        logger.trace("Exiting application");
    }
}
