package io.pivotal.pal.tracker;

import io.pivotal.pal.tracker.TimeEntry;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class TimeEntryController {
    public TimeEntryController(TimeEntryRepository timeEntryRepository) {

    }

    public ResponseEntity<TimeEntry> create(TimeEntry timeEntryToCreate) {
        return null;
    }

    public ResponseEntity<TimeEntry> read(long l) {
        return null;
    }

    public ResponseEntity<TimeEntry> update(long l, TimeEntry expected) {
        return null;
    }

    public ResponseEntity<TimeEntry> delete(long l) {
        return null;
    }

    public ResponseEntity<List<TimeEntry>> list() {
        return null;
    }
}