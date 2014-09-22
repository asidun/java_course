package com.diosoft.sample.calendar.datastore;

import com.diosoft.sample.calendar.common.Event;
import com.diosoft.sample.calendar.common.Person;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.*;

public class CalendarDataStoreImpl implements CalendarDataStore {

    private final Map<String, Event> store = new HashMap<>();

    @Override
    public void publish(Event event) {
        store.put(event.getName(), event);
        persistEvent(event);
    }

    @Override
    public Event remove(String eventName) {
        Event event = store.get(eventName);
        store.remove(eventName);
        return event;
    }

    @Override
    public Event getEvent(String name) {
        return store.get(name);
    }

    @Override
    public List<Event>  searchEventByTimeForAttender(GregorianCalendar date, Person attender) {
        List<Event> returnList = new ArrayList<>();
        for (Map.Entry<String, Event> entry : store.entrySet()){
            Event event = entry.getValue();
            if (event.getAttenders().contains(attender) && eventInDate(event, date)){
                returnList.add(event);
            }
        }
        return returnList;
    }

    private boolean eventInDate(Event event, GregorianCalendar date) {
        if (event.getStartTime().compareTo(date) >=0 && event.getEndTime().compareTo(date) <=0 ){
            return true;
        }
        return false;
    }

    private void persistEvent(Event expectedEvent){

        JAXBContext context = null;

        EventAdapter eventAdapter = new EventAdapter(expectedEvent);
        try {
            context = JAXBContext.newInstance(EventAdapter.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(eventAdapter, new File("./"+expectedEvent.getName() +". xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
