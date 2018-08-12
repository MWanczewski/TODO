package property;

import java.io.*;
import java.util.Properties;

public class ShowProperty {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\r\\TODO\\src\\main\\resources\\app.properties");
        InputStream inputStream = new FileInputStream(file);
        Properties properties = new Properties();
        properties.load(inputStream);
    }
}
