package property;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EventTxtRepository implements EventRep{
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
        List<Event> events = getAllEventList();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(propertiesLoader.getInputDateFormat());
        LocalDateTime localNow = LocalDateTime.now();
        LocalDateTime nearestDate = LocalDateTime.parse(events.get(0).getEventDate(), formatter);
        int indexOfNextEvent = 0;
        for(int i = 0; i < events.size(); i++) {
            LocalDateTime localDateTime = LocalDateTime.parse(events.get(i).getEventDate(), formatter);
            if((localDateTime.isAfter(localNow)) && (localDateTime.isBefore(nearestDate))) {
                nearestDate = localDateTime;
                indexOfNextEvent = i;
            } else if(nearestDate.isBefore(localNow)) {
                indexOfNextEvent = -1;
            }
        }
        return events.get(indexOfNextEvent);
    }

    @Override
    public void addEvent(Event event) {
        try{
            Path path = Paths.get(propertiesLoader.getEventPath());
            String fileName = path.toString();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, true));
            bufferedWriter.newLine();
            bufferedWriter.write(eventParser.parseToDatabase(event));
            bufferedWriter.close();
        } catch(IOException e) {
            e.getMessage();
        }

    }

    @Override
    public void save(Event event) {
        addEvent(event);
    }
}
