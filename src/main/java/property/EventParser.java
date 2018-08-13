package property;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EventParser {
    public static final Pattern PATTERN = Pattern.compile("(.+)\\s;\\s(.+)");
    public Event parseFromDatabase(String line) {
        Matcher matcher = PATTERN.matcher(line);
        while(matcher.find()) {
            String date = matcher.group(1);
            String name = matcher.group(2);
            return new Event(name, date);
        }
        return null;
    }
    public String parseToDatabase(Event event) {
        String value1 = event.getEventDate();
        String value2 = event.getEventName();
        String output = value1 +" ; "+ value2;
        return output;
    }
}
