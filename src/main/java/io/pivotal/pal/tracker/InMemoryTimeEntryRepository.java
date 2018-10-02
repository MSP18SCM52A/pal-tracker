package io.pivotal.pal.tracker;


import org.springframework.http.ResponseEntity;

import java.util.*;


public class InMemoryTimeEntryRepository<T> implements TimeEntryRepository {

    HashMap<Long,TimeEntry> timeEntries = new HashMap<>();

    @Override
    public TimeEntry create(TimeEntry timeEntry){
        Long id = timeEntries.size() + 1L;
      TimeEntry  timeEntry1 = new TimeEntry(id,timeEntry.getId(),timeEntry.getProjectId(),timeEntry.getDate(),timeEntry.getHours());
//        timeEntry1.setId(1L);
//        timeEntry1.setProjectId(timeEntry.getId());
//        timeEntry1.setUserId(timeEntry.getProjectId());
//        timeEntry1.setDate(timeEntry.getDate());
//        timeEntry1.setHours(timeEntry.getHours());
        timeEntries.put(id,timeEntry1);
        return timeEntry1;

    }
    @Override
    public List<TimeEntry> list() {
        List<TimeEntry> timeEntryList = new ArrayList<>(timeEntries.values());
        return timeEntryList;
    }
    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {
        timeEntries.put(id,timeEntry);
        return timeEntry;
    }
    @Override
    public ResponseEntity<TimeEntry> delete(long id) {
        timeEntries.remove(id);
        return null;
    }
    @Override
    public TimeEntry find(long l) {
        return timeEntries.get(l);
    }
}
