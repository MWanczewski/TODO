package property;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class EventService {
    public static void main(String[] args) {
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        EventRep eventTxtRep = new EventTxtRepository(propertiesLoader);
        List<Event> allEventList = eventTxtRep.getAllEventList();
        allEventList.stream().forEach(s -> System.out.println(s));
        System.out.println();
        System.out.println(eventTxtRep.getNextEvent());
        eventTxtRep.addEvent(new Event("wesele", "16122016 13:45"));


    }
}
