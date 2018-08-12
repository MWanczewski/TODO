package property;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EventTxtRepository implements EventRep{
    private List<Event> Events= new ArrayList<>();
    private PropertiesLoader propertiesLoader;
    private EventParser eventParser = new EventParser();
    public EventTxtRepository(PropertiesLoader propertiesLoader) {
        this.propertiesLoader = propertiesLoader;
    }

    @Override
    public List<Event> getAllEventList() {
        try {
            EventParser eventParser = new EventParser();
            Path path = Paths.get(propertiesLoader.getEventPath());
            Stream<Event> eventStream = Files.lines(path)
                    .map(s -> {
                        return eventParser.parseFromDatabase(s);
                    });
            return eventStream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public Event getNextEvent() {
        return null;
    }

    @Override
    public void addEvent(Event event) {


    }

    @Override
    public void save(Event event) {

    }
}
