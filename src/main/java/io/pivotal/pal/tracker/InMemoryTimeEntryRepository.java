package io.pivotal.pal.tracker;


import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;


public class InMemoryTimeEntryRepository<T> implements TimeEntryRepository {
//    TimeEntry timeEntry1 ;
    public TimeEntry create(TimeEntry timeEntry){
      TimeEntry  timeEntry1 = new TimeEntry(1L,timeEntry.getId(),timeEntry.getProjectId(),timeEntry.getDate(),timeEntry.getHours());
        timeEntry1.setId(1L);
        timeEntry1.setProjectId(timeEntry.getId());
        timeEntry1.setUserId(timeEntry.getProjectId());
        timeEntry1.setDate(timeEntry.getDate());
        timeEntry1.setHours(timeEntry.getHours());

        return timeEntry1;

    }

    public List<TimeEntry> list() {
        return null;
    }

    public TimeEntry update(long id, TimeEntry timeEntry) {
        return null;
    }

    public TimeEntry delete(long id) {
        return null;
    }

    public TimeEntry find(long l) {
        return null;
    }
}
