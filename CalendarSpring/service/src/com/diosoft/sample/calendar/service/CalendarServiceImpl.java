package com.diosoft.sample.calendar.service;

import com.diosoft.sample.calendar.common.Event;
import com.diosoft.sample.calendar.common.EventType;
import com.diosoft.sample.calendar.common.Person;
import com.diosoft.sample.calendar.datastore.CalendarDataStore;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Logger;

import static java.util.Arrays.asList;

public class CalendarServiceImpl implements CalendarService {

    public static final Logger logger = Logger.getAnonymousLogger();
    private final CalendarDataStore dataStore;

    public CalendarServiceImpl(CalendarDataStore dataStore) {

        this.dataStore = dataStore;
    }

    @Override
    public void addEvent2(String name, String description, GregorianCalendar startDate, GregorianCalendar endDate, List<Person> attenders, EventType type) {

        if (type == null){
            dataStore.publish(new Event.Builder()
                            .name(name)
                            .description(description)
                            .startTime(startDate)
                            .endTime(endDate)
                            .attenders(attenders)
                            .build()
            );
        }else {
            dataStore.publish(new Event.Builder()
                            .name(name)
                            .description(description)
                            .startTime(startDate)
                            .endTime(endDate)
                            .attenders(attenders)
                            .type(type)
                            .build()
            );
        }
        logger.info("Published even on service side " + name);
    }

    @Override
    public Event removeEvent(String name) {
        return dataStore.remove(name);

    }

    @Override
    public Event getEvent(String name) {
        return dataStore.getEvent(name);
    }

    @Override
    public List<Event> searchEventByTimeForAttender(GregorianCalendar date, Person attender) throws RemoteException {
        return dataStore.searchEventByTimeForAttender(date, attender);
    }

    @Override
    public Event addAttender(String name, Person... newPersons) {

        Event originEvent = dataStore.remove(name);
        if (originEvent == null) {
            return null;
        }
        List<Person> newAttenders = new ArrayList<>(originEvent.getAttenders());
        newAttenders.addAll(asList(newPersons));

        Event newEvent = new Event.Builder(originEvent)
                .attenders(newAttenders)
                .build();
        dataStore.publish(newEvent
        );
        return newEvent;
    }
}
