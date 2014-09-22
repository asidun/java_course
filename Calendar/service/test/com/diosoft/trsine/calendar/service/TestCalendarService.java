package com.diosoft.trsine.calendar.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import static org.mockito.Mockito.*;


import org.junit.Test;

import com.diosoft.trsine.calendar.common.Event;

public class TestCalendarService {

	@Test
    void testAdd(){
		CalendarService calendar = mock(CalendarService.class);
		Event event = new Event.Builder()
						.attendees(null)
						.description("desc")
						.endDate(new Date())
						.startDate(new Date())
						.id(UUID.randomUUID())
						.location("location")
						.build();
		calendar.add(event);
		verify(calendar).add(event);
    	
    }

	void testAdd_Null(Event event){
    	
    }
    void testAdd_Empty(Event event){
    	
    }
//    void testRemove(UUID id){
//    	
//    }
//    List<Event> TestSearchByTitle(String title){
//    	
//    }
//    List<Event> TestSearchByDay(Date day){
//    	
//    }
	
}
