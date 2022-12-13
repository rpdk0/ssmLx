package fun.rpdk.mvcxmlx.util;

import org.apache.logging.log4j.LogManager;

public class Logger {
    private static org.apache.logging.log4j.Logger logger= LogManager.getLogger(LogManager.class);

    public static org.apache.logging.log4j.Logger getLogger() {
        return logger;
    }
}
