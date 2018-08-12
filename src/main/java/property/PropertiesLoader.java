package property;

import jdk.internal.util.xml.impl.Input;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {
    private String inputDateFormat;
    private String outputDateFormat;
    private String todoPath;
    private String eventPath;

    public String getInputDateFormat() {
        return inputDateFormat;
    }

    public void setInputDateFormat(String inputDateFormat) {
        this.inputDateFormat = inputDateFormat;
    }

    public String getOutputDateFormat() {
        return outputDateFormat;
    }

    public void setOutputDateFormat(String outputDateFormat) {
        this.outputDateFormat = outputDateFormat;
    }

    public String getTodoPath() {
        return todoPath;
    }

    public void setTodoPath(String todoPath) {
        this.todoPath = todoPath;
    }

    public String getEventPath() {
        return eventPath;
    }

    public void setEventPath(String eventPath) {
        this.eventPath = eventPath;
    }
    public PropertiesLoader() {
        try (InputStream resourceAsStream = PropertiesLoader.class.getClassLoader().getResourceAsStream("app.properties")) {
        Properties properties = new Properties();
            properties.load(resourceAsStream);
            eventPath = properties.getProperty("path.event");
            todoPath = properties.getProperty("path.todo");
            inputDateFormat = properties.getProperty("dateInput");
            outputDateFormat = properties.getProperty("dateOutput");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
