package io.pivotal.pal.tracker;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TimeEntryRepository {
    TimeEntry create(TimeEntry any);

    TimeEntry update(long eq, TimeEntry any);

    List<TimeEntry> list();

    public void delete(long l);
    public TimeEntry find(long l);
}
