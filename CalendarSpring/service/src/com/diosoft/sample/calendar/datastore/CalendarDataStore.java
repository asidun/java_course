package com.diosoft.sample.calendar.datastore;

import com.diosoft.sample.calendar.common.Event;
import com.diosoft.sample.calendar.common.Person;

import java.util.GregorianCalendar;
import java.util.List;

public interface CalendarDataStore {

    void publish(Event event);

    Event remove(String eventName);

    Event getEvent(String name);

    List<Event> searchEventByTimeForAttender(GregorianCalendar date, Person attender);
}
