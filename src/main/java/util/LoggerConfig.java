package util;

import org.apache.log4j.*;

import java.io.IOException;

import static util.RestPath.filePath;

public class LoggerConfig {


    private String loggerName;

    LoggerConfig(String name) {
        this.loggerName = name;
    }

    public Logger loggerConfig() throws IOException {
        Logger log = Logger.getLogger(loggerName);
        log.setLevel(Level.DEBUG);
        log.addAppender(new FileAppender(new PatternLayout("%m%n"),
                filePath + loggerName + ".log"));
        return log;

    }


}
