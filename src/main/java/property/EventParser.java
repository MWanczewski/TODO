package property;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EventParser {
    public static final Pattern PATTERN = Pattern.compile("(.+);(.+)");
    public Event parseFromDatabase(String line) {
        Matcher matcher = PATTERN.matcher(line);
        String date = matcher.group(1);
        String name = matcher.group(2);
        return new Event(date, name);
    }
}
