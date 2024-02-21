package main.java.com.assignment.question;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class LoggerImpl implements Logger{

    private static LoggerImpl instance;
    private String logFilePath;
    private PrintWriter logWriter;
    private LoggerImpl(){

    }
    public static LoggerImpl getInstance(){
        if(instance==null){
            synchronized (LoggerImpl.class){
                if(instance==null){
                    instance = new LoggerImpl();
                }
            }
        }
        return instance;
    }
    public static void resetInstance(){
        instance = null;
    }

    @Override
    public void log(LogLevel level, String message) {
        if(logWriter == null){
            throw new IllegalStateException("Logger not initialized. Call setLogFile method to do so.");
        }
        String logEntry = "TimeStamp: "+LocalDateTime.now()+"\nLog Level: "+level.name()+"\nMessage: "+message;
        logWriter.println(logEntry);
    }

    @Override
    public void setLogFile(String filePath) {
        try {
            logFilePath = filePath;
            logWriter = new PrintWriter(new FileWriter(logFilePath, true));
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("Invalid file path!");
        }
    }
    @Override
    public String getLogFile() {
        if(logWriter==null){
            throw new IllegalStateException("Logger not initialized. Call setLogFile method to do so.");
        }
        return logFilePath;
    }

    @Override
    public void flush() {
        if(logWriter != null){
            logWriter.flush();
        }
    }

    @Override
    public void close() {
        if(logWriter != null){
            logWriter.close();
            logWriter = null;
        }
    }
}
