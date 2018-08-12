package property;

import java.util.List;

public interface EventRep {
    List<Event> getAllEventList();
    Event getNextEvent();
    void addEvent(Event event);
    void save(Event event);
}
